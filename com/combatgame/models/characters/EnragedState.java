package com.combatgame.models.characters;

public class NormalState implements CharacterState {
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
    public void checkStatus(CharacterState state, Attributes attributes) {
        if(attributes.getHealth() >= 20)
            healed(state); // Return to Normal State if health is above 20
        System.out.println("");
    }
    @Override
    public void stateEffect(Attributes attributes) {
        attributes.setStrength(attributes.getStrength()*1.5);
        attributes.setMagic(attributes.getMagic()*1.5);
    }
    @Override
    public String getStateName() {
        return "Enrgaged State";
    }
}