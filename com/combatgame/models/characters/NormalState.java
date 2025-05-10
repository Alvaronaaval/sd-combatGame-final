package com.combatgame.models.characters;

public class NormalState implements CharacterState {
    @Override
    public void wounded(CharacterState state) {
        state.changeState(new WoundedState());
        System.out.println("Character is now in Wounded State.");
    }
    @Override
    public void paralyzed(CharacterState state) {
        state.changeState(new ParalyzedState());
        System.out.println("Character is now in Paralyzed State.");
    }
    @Override
    public void enraged(CharacterState state) {
        state.changeState(new EnragedState());
        System.out.println("Character is now in Enraged State.");
    }
    @Override
    public void healed(CharacterState state) {
        System.out.println("Character is already healed.");
    }
    public void checkStatus(CharacterState state, Attributes attributes) {
        
    }
    @Override
    public void stateEffect(Attributes attributes) {
        System.out.println("Normal State has no effect."); // No effect on attributes
    }
    @Override
    public String getStateName() {
        return "Normal State";
    }
}