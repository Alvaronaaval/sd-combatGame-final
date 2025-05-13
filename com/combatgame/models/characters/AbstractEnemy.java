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
        this.state = new NormalState();

    }

    @Override
    public void applyState(CharacterState newState) {
        this.state = newState;
    }

    @Override
    public boolean getSkipTurn() {
        return skipTurn;
    }

    @Override
    public CharacterState getState() {
        return state;
    }

    @Override
    public void setSkipTurn(boolean skipTurn) {
        this.skipTurn = skipTurn;
    }

    @Override
    public Attributes getAttributes() {
        return attributes;
    }

    @Override
    public boolean isAlive() {
        return attributes.getHealth() > 0;
    }

    @Override
    public void receiveDamage(Attack attack, Fighter opponent) {
        int damageTaken;
        if(opponent.getWeapon().getDamageType() == DamageType.PHYSICAL) {
            damageTaken = (attack.getDamage() + opponent.getAttributes().getStrength()*2) - attributes.getDefense();
        } else {
            damageTaken = (attack.getDamage() + opponent.getAttributes().getMagic()*2) - (attributes.getDefense()*50)/100;
        }

        damageTaken = Math.max(0, damageTaken); // Prevent negative damage
        attributes.setHealth(attributes.getHealth() - damageTaken);
    }


    @Override
    public boolean isFaster(Fighter opponent) {
        if(attributes.getSpeed() > opponent.getAttributes().getSpeed()) {
            return true;
        } else if(attributes.getSpeed() < opponent.getAttributes().getSpeed()) {
            return false;
        } else {
            return Math.random() < 0.5; // Randomly decide who goes first
        }
    }
}
