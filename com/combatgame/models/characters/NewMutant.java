package com.combatgame.models.characters;
import com.combatgame.models.characters.Attributes;
import com.combatgame.models.WorldEffect;

public class NewMutant extends AbstractEnemy {
    public NewMutant(WorldEffect worldEffect) {
        super(worldEffect, Attributes.randomAttributes());// crea atributos aleatorios
    }

    @Override
    public void takeTurn() {
        System.out.println("Mutant performs an unpredictable action!");
        if (worldEffect == WorldEffect.VOLCANO) {
            attributes.setHealth(attributes.getHealth() + 5);
            System.out.println("Mutant regenerates health!");
        }
    }

    @Override
    public String getType() {
        return "Mutant";
    }
}
