package com.combatgame.core;
import com.combatgame.gamestate.StatSelectUI;
import com.combatgame.gamestate.WeaponSelectUi;
import com.combatgame.models.EnemyFactory;
import com.combatgame.models.WorldEffect;
import com.combatgame.models.characters.Fighter;
import com.combatgame.models.characters.Player;

public class main {
    public static void main(String[] args) {
        WeaponSelectUi weaponSelect = new WeaponSelectUi();
        StatSelectUI statSelect = new StatSelectUI();


        Player player = new Player();
        statSelect.StatSelectMenu(player);
        weaponSelect.WeaponSelectMenu(player);

        // Mostrar weapon y stats
        System.out.println("Player weapon: " + player.getWeapon().getName());
        System.out.println("Player primary attack: " + player.getPrimaryAttack().getName());
        System.out.println("Player secondary attack: " + player.getSecondaryAttack().getName());


        // Mundo seleccionado
        WorldEffect currentWorld = WorldEffect.JUNGLE;

        // Prueba de 3 enemigos creados aleatoriamente en ese mundo
        for (int i = 0; i < 3; i++) {
            Fighter enemy = EnemyFactory.createEnemy(currentWorld);
            System.out.println("Enemy type: " + enemy.getType());
            System.out.println("Health: " + enemy.getAttributes().getHealth());
            enemy.takeTurn();
            enemy.receiveDamage(player.getPrimaryAttack(), player);
            System.out.println("After damage: " + enemy.getAttributes().getHealth());
            System.out.println("----------------------------");
        }


    }
}
