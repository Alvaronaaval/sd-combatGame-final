package com.combatgame.models;

import com.combatgame.models.characters.*;

import java.util.Random;

public class EnemyFactory {
    public static Fighter createEnemy(WorldEffect world) {
        int pick = new Random().nextInt(3);
        switch (pick) {
            case 0: return new NewWarrior(world);
            case 1: return new NewSorcerer(world);
            case 2: return new NewMutant(world);
            default: return new NewWarrior(world);
        }
    }
}
