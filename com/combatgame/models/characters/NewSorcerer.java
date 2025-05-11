package com.combatgame.models.characters;
import com.combatgame.models.characters.Attributes;
import com.combatgame.models.WorldEffect;

public class NewSorcerer extends AbstractEnemy {
    public NewSorcerer(WorldEffect worldEffect) {
        super(worldEffect, new Attributes(2, 4, 3, 9, 4, 3)); // fuerza, agilidad, defensa, magia, velocidad
    }

    @Override
    public void takeTurn() {
        if (worldEffect == WorldEffect.OCEAN) {
            System.out.println("Sorcerer casts a freezing spell!");
            // Aquí se podría aplicar lógica de congelación (ej. cambiar el estado del jugador)
        } else {
            System.out.println("Sorcerer casts a powerful magical attack.");
        }
    }

    @Override
    public void receiveDamage(int damage) {
        if (worldEffect == WorldEffect.JUNGLE && Math.random() < 0.3) {
            System.out.println("Sorcerer dodged the attack with flight!");
            return;
        }
        super.receiveDamage(damage);
    }

    @Override
    public String getType() {
        return "Sorcerer";
    }
}
