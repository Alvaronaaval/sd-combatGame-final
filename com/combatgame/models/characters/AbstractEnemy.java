package com.combatgame.models.characters;

import com.combatgame.models.Attributes;
import com.combatgame.models.WorldEffect;

public abstract class AbstractEnemy implements Fighter {
    protected Attributes attributes;
    protected WorldEffect worldEffect;

    public AbstractEnemy(WorldEffect worldEffect, Attributes attributes) {
        this.worldEffect = worldEffect;
        this.attributes = attributes;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    @Override
    public boolean isAlive() {
        return attributes.getHealth() > 0;
    }

    @Override
    public void receiveDamage(int damage) {
        int realDamage = Math.max(damage - attributes.getDefense(), 1);
        attributes.getHealth(); -= realDamage;
    }
}
