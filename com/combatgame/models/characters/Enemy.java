package com.combatgame.models.characters;

public interface Enemy {
    void takeTurn();
    String getType();
    int getHealth();
    void receiveDamage(int damage);
    boolean isAlive();
}
