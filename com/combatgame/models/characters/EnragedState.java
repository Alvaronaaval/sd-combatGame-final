package com.combatgame.models.characters;

public class EnragedState implements CharacterState {
    private int firstTime = 0;  // Variable to track if the state effect has been applied

    @Override
    public void paralyzed(Fighter fighter) {
        System.out.println("Character cannot become Paralyzed State.");
    }
    @Override
    public void enraged(Fighter fighter) {
        System.out.println("Character cannot become Enraged State.");
    }
    @Override
    public void burned(Fighter fighter) {
        System.out.println("Character cannot become Burned State.");
    }
    @Override
    public void healed(Fighter fighter) {
        fighter.applyState(new NormalState());
        System.out.println("Character is now in Normal State.");
        fighter.getAttributes().setStrength((fighter.getAttributes().getStrength()*50)/100);
        fighter.getAttributes().setMagic((fighter.getAttributes().getMagic()*50)/100);
        firstTime = 0; // Reset firstTime when healed
    }

    public void checkStatus(Fighter fighter) {
        if(fighter.getAttributes().getHealth() >= 20)
            healed(fighter); // Return to Normal State if health is above 20
    }
    @Override
    public void stateEffect(Fighter fighter) {
        if(firstTime == 0) {    // Boosts attributes only once
            fighter.getAttributes().setStrength((fighter.getAttributes().getStrength()*200)/100);
            fighter.getAttributes().setMagic((fighter.getAttributes().getMagic()*200)/100);
        }
        firstTime++;
        System.out.println("Status: Enraged (Magic and strength increased by 50%)");
    }
    @Override
    public String getStateName() {
        return "Enrgaged State";
    }
}