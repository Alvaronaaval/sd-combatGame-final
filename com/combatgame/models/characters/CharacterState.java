package com.combatgame.models.characters;

public interface CharacterState {
    void wounded(CharacterState state);
    void paralyzed(CharacterState state);
    void enraged(CharacterState state);
    void healed(CharacterState state);

    void checkStatus(CharacterState state, Attributes attributes);
    void stateEffect(Attributes attributes);
    String getStateName();
}