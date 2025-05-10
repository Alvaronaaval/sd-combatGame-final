package com.combatgame.models.characters;

public class VolcanoSorcerer implements Enemy {
    private int health = 100;

    @Override
    public void takeTurn() {
        System.out.println("Volcano Sorcerer casts a fire spell and regenerates health!");
        health += 5; // Regeneración simple como diceen el PDF
    }

    @Override
    public String getType() {
        return "Volcano Sorcerer";
    }

    @Override
    public int getHealth() {
        return health;
    }
}
