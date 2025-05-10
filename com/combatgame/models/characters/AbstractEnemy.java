package com.combatgame.models.characters;

import com.combatgame.models.Attributes;
import com.combatgame.models.WorldEffect;

public abstract class AbstractEnemy implements Fighter {
    protected Attributes attributes;
    protected int health = 100;
    protected WorldEffect worldEffect;

    public AbstractEnemy(WorldEffect worldEffect, Attributes attributes) {
        this.worldEffect = worldEffect;
        this.attributes = attributes;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public void receiveDamage(int damage) {
        int realDamage = Math.max(damage - attributes.getDefense(), 1);
        health -= realDamage;
    }
}
