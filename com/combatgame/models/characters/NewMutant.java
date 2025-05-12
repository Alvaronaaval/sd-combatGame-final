package com.combatgame.models.characters;
import com.combatgame.models.WorldEffect;
import com.combatgame.models.objects.Attack;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.WeaponDagger;
import com.combatgame.models.objects.factory.AttackFactory;
import com.combatgame.models.objects.factory.DaggerAttackFactory;

public class NewMutant extends AbstractEnemy {
    private final Weapon dagger; // enemy weapon
    private final Attack primaryAttack; // enemy attack
    private final Attack secondaryAttack; // enemy attack

    public NewMutant(WorldEffect worldEffect) {
        super(worldEffect, Attributes.randomAttributes());// crea atributos aleatorios
        dagger = new WeaponDagger();
        AttackFactory factory = new DaggerAttackFactory();
        primaryAttack = factory.createPrimaryAttack(dagger);
        secondaryAttack = factory.createSecondaryAttack(dagger);
    }

    @Override public Weapon getWeapon() { return dagger; }
    @Override public Attack getPrimaryAttack() { return primaryAttack; }
    @Override public Attack getSecondaryAttack() { return secondaryAttack; }

    @Override
    public void takeTurn() {
        System.out.println("Mutant performs an unpredictable action!");
        if (worldEffect == WorldEffect.VOLCANO) {
            attributes.setHealth(attributes.getHealth() + 5);
            System.out.println("Mutant regenerates health!");
        }
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
        return "Mutant";
    }
}
