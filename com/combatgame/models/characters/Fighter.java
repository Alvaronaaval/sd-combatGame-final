package com.combatgame.models.characters;

public interface Fighter {
    void takeTurn();
    void receiveDamage(int damage);
    boolean isAlive();
    String getType();
    int getHealth();
}

// interfaz que sirve para definir los métodos que deben implementar tanto los enemigos como los jugadores
