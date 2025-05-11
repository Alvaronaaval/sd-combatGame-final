package com.combatgame.models.characters;
import com.combatgame.models.Attributes;
import com.combatgame.models.WorldEffect;

public class NewWarrior extends AbstractEnemy {
    public NewWarrior(WorldEffect worldEffect) {
        super(worldEffect, new Attributes(9, 5, 4, 2, 3));
    }

    @Override
    public void takeTurn() {
        System.out.println("Warrior attacks with brute strength!");
    }

    @Override
    public String getType() {
        return "Warrior";
    }
}
