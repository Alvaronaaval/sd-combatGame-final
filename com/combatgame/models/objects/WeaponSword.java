package com.combatgame.models.objects;

public class WeaponSword implements Weapons {
    private String name;
    private int damage;
    private boolean damageType;
    private int defense;

    public WeaponSword() {
        this.name = "Sword";
        this.damage = 15;
        this.damageType = false;// false = physical damage, true = magical damage
        this.defense = 7; // Example defense value for the sword
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }
    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public boolean getDamageType() {
        return damageType;
    }

    @Override
    public void setDamageType(boolean damageType) {
        this.damageType = damageType;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }
    @Override
    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
