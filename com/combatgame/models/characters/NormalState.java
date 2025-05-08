package com.combatgame.models.characters;

public class NormalState implements CharacterState {
    void wounded(CharacterState state) {
        state.changeState(new WoundedState());
        System.out.println("Character is now in Wounded State.");
    }
    void paralyzed(CharacterState state) {
        state.changeState(new ParalyzedState());
        System.out.println("Character is now in Paralyzed State.");
    }
    void enraged(CharacterState state) {
        state.changeState(new EnragedState());
        System.out.println("Character is now in Enraged State.");
    }
    void healed(CharacterState state) {
        System.out.println("Character is already healed.");
    }
    String getStateName() {
        return "Normal State";
    }
}