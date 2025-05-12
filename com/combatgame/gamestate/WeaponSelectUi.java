package com.combatgame.gamestate;

import com.combatgame.models.characters.Fighter;
import com.combatgame.models.characters.Player;
import com.combatgame.models.objects.*;
import com.combatgame.models.objects.factory.*;

import java.util.Scanner;

public class WeaponSelectUi {

    Scanner scan = new Scanner(System.in);
    AttackFactory factory;
    Weapon weapon;
    Attack primaryAttack;
    Attack secondaryAttack;

    public void WeaponSelectMenu(Player Player) {
        System.out.println("Select a weapon: ");
        System.out.println("1. Sword");
        System.out.println("2. Dagger");
        System.out.println("3. Bow");
        System.out.println("4. Staff");
        int choice = scan.nextInt();
        scan.close();
        switch (choice) {
            case 1:
                Player.setWeapon(new WeaponSword());
                factory = new SwordAttackFactory();
                System.out.println("Sword selected.");
                break;
            case 2:
                Player.setWeapon(new WeaponDagger());
                factory = new DaggerAttackFactory();
                System.out.println("Dagger selected.");
                break;
            case 3:
                Player.setWeapon(new WeaponBow());
                factory = new BowAttackFactory();
                System.out.println("Bow selected.");
                break;
            case 4:
                Player.setWeapon(new WeaponStaff());
                factory = new StaffAttackFactory();
                System.out.println("Staff selected.");
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Sword.");
                Player.setWeapon(new WeaponSword());
                factory = new SwordAttackFactory();
                break;
        }
        Player.setPrimaryAttack(factory.createPrimaryAttack(Player.getWeapon()));
        Player.setSecondaryAttack(factory.createSecondaryAttack(Player.getWeapon()));

    }
}



