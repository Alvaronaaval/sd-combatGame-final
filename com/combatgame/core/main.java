package com.combatgame.core;
import com.combatgame.models.objects.WeaponSword;
public class main {
    public static void main(String[] args) {
        WeaponSword sword = new WeaponSword();
        sword.displayIllustration();
        System.out.println("Weapon Name: " + sword.getName());
        System.out.println("Weapon Damage: " + sword.getDamage());
        System.out.println("Is Magical Damage: " + sword.getDamageType());
    }
}
