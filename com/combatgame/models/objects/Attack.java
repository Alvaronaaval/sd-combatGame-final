package com.combatgame.models.objects;

public interface Attack {
    void executeAttack();
    int getDamage(); // Return the damage of this attack
    String getName(); // Return the name of this attack
}