// com/combatgame/gamestate/RandomEnemyGenerator.java
package com.combatgame.gamestate;

import com.combatgame.models.EnemyFactory;
import com.combatgame.models.WorldEffect;
import com.combatgame.models.characters.Fighter;

import java.util.Random;

public class RandomEnemyGenerator {

    public static Fighter generate() {

        WorldEffect[] worlds = WorldEffect.values();
        WorldEffect randomWorld = worlds[new Random().nextInt(worlds.length)];

        // Crear enemigo para ese mundo
        Fighter enemy = EnemyFactory.createEnemy(randomWorld);

        // Mensaje opcional de depuración
        System.out.println("🧬 Enemy generated in " + randomWorld + ": " + enemy.getType());

        return enemy;
    }
}
