package com.combatgame.models.characters;

public class JungleWarrior implements Enemy {
    private int health = 100;

    @Override
    public void takeTurn() {
        System.out.println("Jungle Warrior attacks with jungle fury!");
    }

    @Override
    public String getType() {
        return "Jungle Warrior";
    }

    @Override
    public int getHealth() {
        return health;
    }
}
