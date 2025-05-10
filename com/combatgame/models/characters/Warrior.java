package com.combatgame.models.characters;

public class Warrior implements Enemy {
    private int health = 100;
    private int strength = 9;
    private int defense = 6;

    @Override
    public void takeTurn() {
        System.out.println("Warrior strikes with brute force!");
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
        return "Warrior";
    }

    @Override
    public int getHealth() {
        return health;
    }
}
