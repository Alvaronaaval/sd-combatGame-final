package com.combatgame.models.objects;

public class WeaponDagger extends AbstractWeapon {
    public WeaponDagger() {
        this.name = "Dagger";
        this.damage = 10;
        this.defense = 5;
        this.damageType = DamageType.PHYSICAL;
    }

    @Override
    public void displayIllustration() {
        System.out.println("""
     ==== DAGGER ====
          /\\
          ||
          ||
          ||
          ||
          ||
         /||\\
        /_||_\\
          ||
          ||
         /__\\
     """);
    }
}
