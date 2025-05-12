package com.combatgame.models.characters;
import com.combatgame.models.WorldEffect;
import com.combatgame.models.objects.Attack;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.WeaponStaff;
import com.combatgame.models.objects.factory.AttackFactory;
import com.combatgame.models.objects.factory.StaffAttackFactory;

public class NewSorcerer extends AbstractEnemy {
    private final Weapon staff; // enemy weapon
    private final Attack primaryAttack; // enemy attack
    private final Attack secondaryAttack; // enemy attack

    public NewSorcerer(WorldEffect worldEffect) {
        super(worldEffect, new Attributes(100, 4, 3, 9, 4, 3)); // fuerza, agilidad, defensa, magia, velocidad
        staff = new WeaponStaff();
        AttackFactory factory = new StaffAttackFactory();
        primaryAttack = factory.createPrimaryAttack(staff);
        secondaryAttack = factory.createSecondaryAttack(staff);

        if(worldEffect == WorldEffect.JUNGLE) {
            attributes.setAgility(7); // Aumenta agilidad en la jungla
        }
    }

    @Override public Weapon getWeapon() { return staff; }
    @Override public Attack getPrimaryAttack() { return primaryAttack; }
    @Override public Attack getSecondaryAttack() { return secondaryAttack; }

    @Override
    public void takeTurn() {
        if (worldEffect == WorldEffect.OCEAN) {
            System.out.println("Sorcerer casts a freezing spell!");
            // Aquí se podría aplicar lógica de congelación (ej. cambiar el estado del jugador)
        } else {
            System.out.println("Sorcerer casts a powerful magical attack.");
        }
    }

    @Override
    public String getType() {
        return "Sorcerer";
    }
}
