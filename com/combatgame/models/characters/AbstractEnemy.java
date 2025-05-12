package com.combatgame.models.characters;

import com.combatgame.models.WorldEffect;
import com.combatgame.models.objects.Attack;
import com.combatgame.models.objects.DamageType;

public abstract class AbstractEnemy implements Fighter {
    protected Attributes attributes;
    protected WorldEffect worldEffect;
    protected boolean skipTurn = false;
    protected CharacterState state;


    public AbstractEnemy(WorldEffect worldEffect, Attributes attributes) {
        this.worldEffect = worldEffect;
        this.attributes = attributes;
    }

    public void applyState(CharacterState newState) {
        this.state = newState;
    }

    public boolean getSkipTurn() {
        return skipTurn;
    }

    public void setSkipTurn(boolean skipTurn) {
        this.skipTurn = skipTurn;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    @Override
    public boolean isAlive() {
        return attributes.getHealth() > 0;
    }

    @Override
    public int receiveDamage(Attack attack, Fighter opponent) { // Receive damage from opponent
        int damageTaken = 0;
        if(opponent.getWeapon().getDamageType() == DamageType.PHYSICAL) {
            damageTaken = (attack.getDamage() + opponent.getAttributes().getStrength()*2) - attributes.getDefense();
        } else {
            damageTaken = (attack.getDamage() + opponent.getAttributes().getMagic()*2) - (attributes.getDefense()*50)/100;
        }
        return damageTaken;
    }
}
