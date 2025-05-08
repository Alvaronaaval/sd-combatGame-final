package com.combatgame.models.entities;

public interface Character {
    void attack();
    void takeDamage(int damage);
    void applyState();
    int getHealth();
}
