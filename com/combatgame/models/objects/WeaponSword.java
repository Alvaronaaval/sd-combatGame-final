package com.combatgame.models.objects;

public class WeaponSword extends AbstractWeapon {

    public WeaponSword() {
        this.name = "Sword";
        this.damage = 20;
        this.defense = 5;
        this.damageType = DamageType.PHYSICAL;
    }
    @Override
    public void displayIllustration() {
        System.out.println("""
    ==== SWORD ====
       /\\
      ||||
      ||||
      ||||
      ||||
      ||||
      ||||
      ||||
      ||||
      ||||
      ||||
      ||||
     /____\\
      |  |
      |__|
    """);
    }
}
