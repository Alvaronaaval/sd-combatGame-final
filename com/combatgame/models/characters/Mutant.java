package com.combatgame.models.characters;

import java.util.Random;

public class Mutant implements Enemy {
    private int health = 100;
    private int strength = new Random().nextInt(10);
    private int defense = new Random().nextInt(10);
    private WorldEffect worldEffect;

    public Mutant(WorldEffect worldEffect) {
        this.worldEffect = worldEffect;
    }

    @Override
    public void takeTurn() {
        System.out.println("Mutant does something unpredictable!");
        if (worldEffect == WorldEffect.VOLCANO) {
            health += 5;
            System.out.println("Mutant regenerates health!");
        }
    }

    @Override
    public void receiveDamage(int damage) {
        health -= Math.max(damage - defense, 1);
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String getType() {
        return "Mutant";
    }

    @Override
    public int getHealth() {
        return health;
    }
}
