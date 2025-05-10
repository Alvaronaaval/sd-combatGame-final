package com.combatgame.models.characters;

public interface CharacterState {
    void paralyzed(Fighter fighter);
    void enraged(Fighter fighter);
    void burned(Fighter fighter);
    void healed(Fighter fighter);

    void checkStatus(Fighter fighter);
    void stateEffect(Fighter fighter);
    String getStateName();
}