package com.combatgame.models.objects;

public interface Weapons {
    String getName();

    int getDamage();

    boolean getDamageType();

    void setDamageType(boolean damageType);

    void setDamage(int damage);

    void setName(String name);
}
