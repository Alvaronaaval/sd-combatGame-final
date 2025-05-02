package com.combatgame.models.objects;

public class WeaponStaff implements Weapons {
    private String name;
    private int damage;
    private boolean damageType; // false = physical damage, true = magical damage
    private int defense;

    public WeaponStaff() {
        this.name = "Staff";
        this.damage = 12;
        this.damageType = true; // Staff typically deals magical damage
        this.defense = 5; // Example defense value for the staff
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
