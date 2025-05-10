package com.combatgame.models.characters;
import java.util.Random;

public class Sorcerer implements Enemy {
    private int health = 100;
    private int magic = 9;
    private int defense = 2;
    private WorldEffect worldEffect;

    public Sorcerer(WorldEffect worldEffect) {
        this.worldEffect = worldEffect;
    }

    @Override
    public void takeTurn() {
        if (worldEffect == WorldEffect.OCEAN) {
            System.out.println("Sorcerer casts a freezing spell!");
            if (new Random().nextInt(100) < 40) {
                System.out.println("Player is frozen!");
            }
        } else {
            System.out.println("Sorcerer casts a powerful magic attack!");
        }
    }

    @Override
    public void receiveDamage(int damage) {
        if (worldEffect == WorldEffect.JUNGLE && new Random().nextInt(100) < 30) {
            System.out.println("Sorcerer dodged the attack with flight!");
            return;
        }
        health -= Math.max(damage - defense, 1);
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String getType() {
        return "Sorcerer";
    }

    @Override
    public int getHealth() {
        return health;
    }
}
