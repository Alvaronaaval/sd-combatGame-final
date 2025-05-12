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
        super(worldEffect, new Attributes(9, 5, 4, 2, 3, 4)); // fuerza, agilidad, defensa, magia, velocidad
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

    @Override
    public String getType() {
        return "Warrior";
    }
}
