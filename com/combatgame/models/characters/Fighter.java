package com.combatgame.models.characters;

public interface Fighter {
    void takeTurn();
    void receiveDamage(int damage);
    boolean isAlive();
    String getType();
    Attributes getAttributes();
    void applyState(CharacterState newState);
    boolean getSkipTurn();
    void setSkipTurn(boolean skipTurn);
}

// interfaz que sirve para definir los métodos que deben implementar tanto los enemigos como los jugadores
