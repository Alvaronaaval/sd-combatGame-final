package com.combatgame.models.characters;

public class ParalyzedState implements CharacterState {
    @Override
    public void wounded(CharacterState state) {
        System.out.println("Character cannot become Wounded State.");
    }
    @Override
    public void paralyzed(CharacterState state) {
        System.out.println("Character cannot become Paralyzed State.");
    }
    @Override
    public void enraged(CharacterState state) {
        System.out.println("Character cannot become Enraged State.");
    }
    @Override
    public void healed(CharacterState state) {
        state.changeState(new NormalState());
        System.out.println("Character is now in Normal State.");
    }
    @Override
    public void stateEffect(Attributes attributes) {
        
    }
    @Override
    public String getStateName() {
        return "Paralyzed State";
    }
}