package com.combatgame.models.objects;

public class WeaponBow extends AbstractWeapon implements ChargeableWeapon {
    private boolean charged = false;

    public void charge() { this.charged = true; }
    public void uncharge() { this.charged = false; }
    public boolean isCharged() { return charged; }
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