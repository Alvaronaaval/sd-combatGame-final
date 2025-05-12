package com.combatgame.core;
import com.combatgame.models.characters.Player;
import com.combatgame.models.objects.Attack;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.WeaponBow;
import com.combatgame.models.objects.WeaponSword;
import com.combatgame.models.objects.factory.AttackFactory;
import com.combatgame.models.objects.factory.SwordAttackFactory;


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
        player.setWeapon(sword);
        player.setPlayerStats();

        PlayerSecondary.executeAttack();
        System.out.println("Damage: " + PlayerSecondary.getDamage());
    }
}
