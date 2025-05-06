package com.combatgame.models.objects;

public class WeaponBow extends AbstractWeapon {
    public WeaponBow() {
        this.name = "Bow";
        this.damage = 15;
        this.defense = 2;
        this.damageType = DamageType.PHYSICAL;
    }
    @Override
    public void displayIllustration() {
        System.out.println( """
    ==== BOW ====
        (
         )\\
        /  )
       |  (
        \\  )
         )/
        (
    """);
    }

}