
package com.combatgame.models;
import com.combatgame.models.characters.*;

public class EnemyFactory {
    public static Enemy createEnemy(WorldType world) {
        switch (world) {
            case JUNGLE:
                return new JungleWarrior();
            case VOLCANO:
                return new VolcanoSorcerer();
            case OCEAN:
                return new OceanMutant();
            default:
                throw new IllegalArgumentException("Unknown world");
        }
    }
}
