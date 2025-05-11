package com.combatgame.core;
import com.combatgame.models.objects.WeaponBow;
import com.combatgame.models.objects.WeaponSword;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.Attack;
import com.combatgame.models.objects.factory.AttackFactory;
import com.combatgame.models.objects.factory.SwordAttackFactory;
import com.combatgame.models.characters;

public class main {
    public static void main(String[] args) {
        WeaponSword sword = new WeaponSword();

        sword.displayIllustration();
        System.out.println("Weapon Name: " + sword.getName());
        System.out.println("Weapon Damage: " + sword.getDamage());
        System.out.println("Is Magical Damage: " + sword.getDamageType());

        AttackFactory swordFactory = new SwordAttackFactory();

        Attack primary = swordFactory.createPrimaryAttack(sword);
        Attack secondary = swordFactory.createSecondaryAttack(sword);

        primary.executeAttack();
        System.out.println("Damage: " + primary.getDamage());

    }
}
