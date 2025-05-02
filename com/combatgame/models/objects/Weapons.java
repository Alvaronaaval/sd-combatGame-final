package com.combatgame.models.objects;

public interface Weapons {
    String getName();

    int getDamage();

    int getDefense();

    boolean getDamageType();

    void setDamageType(boolean damageType);

    void setDamage(int damage);

    void setName(String name);

    void displayIllustration(); // Method to display weapon illustration

    void setDefense(int defense); // Method to set defense value
}
