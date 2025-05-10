package com.combatgame.models.characters;

public class OceanMutant implements Enemy {
    private int health = 100;

    @Override
    public void takeTurn() {
        System.out.println("Ocean Mutant uses an unpredictable move!");
    }

    @Override
    public String getType() {
        return "Ocean Mutant";
    }

    @Override
    public int getHealth() {
        return health;
    }
}
