package com.combatgame.models.characters;

public class NormalState implements CharacterState {
    public void wounded(CharacterState state) {
        state.changeState(new WoundedState());
        System.out.println("Character is now in Wounded State.");
    }
    public void paralyzed(CharacterState state) {
        state.changeState(new ParalyzedState());
        System.out.println("Character is now in Paralyzed State.");
    }
    public void enraged(CharacterState state) {
        state.changeState(new EnragedState());
        System.out.println("Character is now in Enraged State.");
    }
    public void healed(CharacterState state) {
        System.out.println("Character is already healed.");
    }
    public String getStateName() {
        return "Normal State";
    }
}