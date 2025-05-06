package com.combatgame.models.objects;

public class WeaponBow implements Weapons {
    private String name;
    private int damage;
    private boolean damageType;
    private int defense;

    public WeaponBow() {
        this.name = "Bow";
        this.damage = 15;
        this.damageType = false; // false = physical damage, true = magical damage
        this.defense = 3; // Example defense value for the bow
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