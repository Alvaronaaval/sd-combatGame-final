package com.combatgame.models.characters;
import com.combatgame.models.objects.Attack;
import com.combatgame.models.objects.DamageType;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.WeaponBow;
import com.combatgame.models.objects.WeaponDagger;
import com.combatgame.models.objects.WeaponStaff;
import com.combatgame.models.objects.WeaponSword;
import com.combatgame.models.objects.factory.AttackFactory;
import com.combatgame.models.objects.factory.BowAttackFactory;
import com.combatgame.models.objects.factory.DaggerAttackFactory;
import com.combatgame.models.objects.factory.StaffAttackFactory;
import com.combatgame.models.objects.factory.SwordAttackFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player implements Fighter, Subject  {
    protected Attributes attributes; // player attributes
    private CharacterState state; // character state
    private boolean skipTurn = false; // skip turn flag
    private Weapon weapon; // player weapon
    private Attack primaryAttack; // player attack
    private Attack secondaryAttack; // player attack

    public Player() {
        this.state = new NormalState(); //Default state
    }

    private boolean validStat(int stat) {
        if (stat < 0 || stat > 10) {
            System.out.println("Invalid stat value. Must be between 0 and 10.");
            return false;
        }
        return true;
    }

    public void setPlayerStats() {
        Scanner scan = new Scanner(System.in);
		int strength = 0, agility = 0, defense = 0, magic = 0, speed = 0;
        int totalPoints = 30;
        
        System.out.println("Distribute a total of 30 points to your character (0-10 per stat): ");
        while(totalPoints != 0) {
            totalPoints = 30;
            do {
                System.out.printf("\nStrength: ");
                strength = scan.nextInt();
            } while(!validStat(strength));
            do {
                System.out.printf("\nDefense: ");
                defense = scan.nextInt();
            } while(!validStat(defense));
            do {
                System.out.printf("\nSpeed: ");
                speed = scan.nextInt();
            } while(!validStat(speed));
            do {
                System.out.printf("\nAgility: ");
                agility = scan.nextInt();
            } while(!validStat(agility));
            do {
                System.out.printf("\nMagic: ");
                magic = scan.nextInt();
            } while(!validStat(magic));

            totalPoints = totalPoints - (strength + agility + defense + magic + speed);
            if(totalPoints != 0) System.out.println("\nThe 30 points have been distributed incorrectly. Please try again.");
            else System.out.println("\nThe 30 points have been distributed correctly.");
        }
        this.attributes = new Attributes(100, strength, agility, defense, magic, speed);

    }

    public void setWeapon() {
        Scanner scan = new Scanner(System.in);
        AttackFactory factory;
        System.out.println("Select a weapon: ");
        System.out.println("1. Sword");
        System.out.println("2. Dagger");
        System.out.println("3. Bow");
        System.out.println("4. Staff");
        int choice = scan.nextInt();
        scan.close();
        switch(choice) {
            case 1:
                weapon = new WeaponSword();
                factory = new SwordAttackFactory();
                System.out.println("Sword selected.");
                break;
            case 2:
                weapon = new WeaponDagger();
                factory = new DaggerAttackFactory();
                System.out.println("Dagger selected.");
                break;
            case 3:
                weapon = new WeaponBow();
                factory = new BowAttackFactory();
                System.out.println("Bow selected.");
                break;
            case 4:
                weapon = new WeaponStaff();
                factory = new StaffAttackFactory();
                System.out.println("Staff selected.");
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Sword.");
                weapon = new WeaponSword();
                factory = new SwordAttackFactory();
                break;
        }
        primaryAttack = factory.createPrimaryAttack(weapon);
        secondaryAttack = factory.createSecondaryAttack(weapon);
    }
    @Override public String getType() { return "Player"; }
    @Override public Attributes getAttributes() { return attributes; }
    @Override public boolean getSkipTurn() { return skipTurn; }
    @Override public Weapon getWeapon() { return weapon; }
    @Override public Attack getPrimaryAttack() { return primaryAttack; }
    @Override public Attack getSecondaryAttack() { return secondaryAttack; }

    @Override
    public void applyState(CharacterState newState) {
        this.state = newState;
    }

    @Override
    public void setSkipTurn(boolean skipTurn) {
        this.skipTurn = skipTurn;
    }

    @Override
    public void takeTurn() {
        System.out.println("Player's turn.");       // Unfinished method
    }

    @Override
    public void receiveDamage(Attack attack, Fighter opponent) { // Receive damage from opponent
        int damageTaken = 0;
        if(opponent.getWeapon().getDamageType() == DamageType.PHYSICAL) {
            damageTaken = (attack.getDamage() + opponent.getAttributes().getStrength()*2) - attributes.getDefense();
        } else {
            damageTaken = (attack.getDamage() + opponent.getAttributes().getMagic()*2) - (attributes.getDefense()*50)/100;
        }
        //  return damageTaken;
    }

    @Override
    public boolean isFaster(Fighter opponent) {
        if(attributes.getSpeed() > opponent.getAttributes().getSpeed()) {
            return true;
        } else if(attributes.getSpeed() < opponent.getAttributes().getSpeed()) {
            return false;
        } else {
            return Math.random() < 0.5; // Randomly decide who goes first
        }
    }

    @Override
    public boolean isAlive() {
        return attributes.getHealth() > 0;
    }

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyEnemyDefeated() {
        for (Observer o : observers) {
            o.onEnemyDefeated();
        }
    }

    // usar este metodo para notificar a los observadores cuando un enemigo es derrotado
    public void onEnemyKilled(Fighter enemy) {
        if (!enemy.isAlive()) {
            notifyEnemyDefeated();
        }
    }

}