package com.combatgame.models.characters;

public class ParalyzedState implements CharacterState {
    public void wounded(CharacterState state) {
        System.out.println("Character cannot become already Wounded State.");
    }
    public void paralyzed(CharacterState state) {
        System.out.println("Character cannot become Paralyzed State.");
    }
    public void enraged(CharacterState state) {
        System.out.println("Character cannot become Enraged State.");
    }
    public void healed(CharacterState state) {
        state.changeState(new NormalState());
        System.out.println("Character is now in Normal State.");
    }
    public String getStateName() {
        return "Paralyzed State";
    }
}