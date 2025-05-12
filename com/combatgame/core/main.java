package com.combatgame.core;
import com.combatgame.models.characters.Player;
import com.combatgame.models.objects.Attack;
import com.combatgame.models.objects.WeaponSword;
import com.combatgame.models.objects.factory.AttackFactory;
import com.combatgame.models.objects.factory.SwordAttackFactory;
import com.combatgame.models.EnemyFactory;
import com.combatgame.models.WorldEffect;
import com.combatgame.models.characters.Fighter;


public class main {
    public static void main(String[] args) {
        WeaponSword sword = new WeaponSword();
        sword.displayIllustration();
        System.out.println("Weapon Name: " + sword.getName());
        System.out.println("Weapon Base Damage: " + sword.getDamage());
        System.out.println("Damage Type: " + sword.getDamageType());

        AttackFactory swordFactory = new SwordAttackFactory();

        Attack PlayerPrimary = swordFactory.createPrimaryAttack(sword);
        Attack PlayerSecondary = swordFactory.createSecondaryAttack(sword);

        Player player = new Player();
        player.setPlayerStats();
        player.setWeapon();

        PlayerSecondary.executeAttack();
        System.out.println("Damage: " + PlayerSecondary.getDamage());

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
