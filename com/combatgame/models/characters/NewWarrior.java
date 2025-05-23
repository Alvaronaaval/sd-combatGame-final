package com.combatgame.models.characters;
import com.combatgame.models.WorldEffect;
import com.combatgame.models.objects.Attack;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.WeaponSword;
import com.combatgame.models.objects.factory.AttackFactory;
import com.combatgame.models.objects.factory.SwordAttackFactory;

public class NewWarrior extends AbstractEnemy {
    private final Weapon sword; // enemy weapon
    private final Attack primaryAttack; // enemy attack
    private final Attack secondaryAttack; // enemy attack

    public NewWarrior(WorldEffect worldEffect) {
        super(worldEffect, new Attributes(100, 5, 4, 2, 3, 4)); // fuerza, agilidad, defensa, magia, velocidad
        sword = new WeaponSword();
        AttackFactory factory = new SwordAttackFactory();
        primaryAttack = factory.createPrimaryAttack(sword);
        secondaryAttack = factory.createSecondaryAttack(sword);
    }

    @Override public Weapon getWeapon() { return sword; }
    @Override public Attack getPrimaryAttack() { return primaryAttack; }
    @Override public Attack getSecondaryAttack() { return secondaryAttack; }

    @Override
    public void takeTurn() {
        System.out.println("Warrior attacks with brute strength!");
    }
    
    public void randomizeAttack() {
        java.util.Random r = new java.util.Random();
        int randomAttack = r.nextInt(2); // 0 or 1
        if (randomAttack == 0) {
            primaryAttack.executeAttack();
        } else {
            secondaryAttack.executeAttack();
        }
    }

    @Override
    public String getType() {
        return "Warrior";
    }
}
