package com.combatgame.models.characters;
import com.combatgame.models.characters.Attributes;
import com.combatgame.models.WorldEffect;

public class NewWarrior extends AbstractEnemy {
    public NewWarrior(WorldEffect worldEffect) {
        super(worldEffect, new Attributes(100, 5, 4, 2, 3, 4)); // fuerza, agilidad, defensa, magia, velocidad
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
