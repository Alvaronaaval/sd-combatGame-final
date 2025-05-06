package com.combatgame.models.objects;

public class WeaponStaff extends AbstractWeapon {
    public WeaponStaff() {
        this.name = "Staff";
        this.damage = 12;
        this.defense = 3;
        this.damageType = DamageType.MAGICAL;
    }
    @Override
    public void displayIllustration() {
        System.out.println("""
    ==== STAFF ====
       *
      ***
     *****
      ***
       *
       |
       |
       |
       |
       |
       |
       |
       |
       |
       |
    """);
    }

}
