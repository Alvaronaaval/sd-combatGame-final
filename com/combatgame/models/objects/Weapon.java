package com.combatgame.models.objects;


public interface Weapon {
    String getName();
    int getDamage();
    int getDefense();
    DamageType getDamageType();

    void setName(String name);
    void setDamage(int damage);
    void setDefense(int defense);
    void setDamageType(DamageType damageType);

    void displayIllustration();
}
