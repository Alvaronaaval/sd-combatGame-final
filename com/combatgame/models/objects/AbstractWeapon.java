package com.combatgame.models.objects;

public abstract class AbstractWeapon implements Weapon {
    protected String name;
    protected int damage;
    protected int defense;
    protected DamageType damageType;

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
    public DamageType getDamageType() {
        return damageType;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }
}
