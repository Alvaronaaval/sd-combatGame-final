package com.combatgame.models.characters;

public interface Enemies {
    void attack();
    void takeDamage(int damage);
    void applyState();
    int getHealth();
}
