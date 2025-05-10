package com.combatgame.models;

import com.combatgame.models.characters.*;

import java.util.Random;

public class EnemyFactory {
    public static Enemy createEnemy(WorldEffect world) {
        int pick = new Random().nextInt(3);
        switch (pick) {
            case 0: return new Warrior();
            case 1: return new Sorcerer(world);
            case 2: return new Mutant(world);
            default: return new Warrior();
        }
    }
}
