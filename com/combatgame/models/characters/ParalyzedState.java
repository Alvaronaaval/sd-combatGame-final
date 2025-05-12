package com.combatgame.models.characters;

public class ParalyzedState implements CharacterState {
    private int paralysisCount = 0;
    private static int maxParalysisCount = 2; // Number of turns before returning to Normal State

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
        fighter.setSkipTurn(false); // Disable skip turn
        paralysisCount = 0; // Reset paralysis count after healing
    }

    @Override
    public void checkStatus(Fighter fighter) {
        if(paralysisCount >= maxParalysisCount)
            healed(fighter); // Return to Normal State
    }
    @Override
    public void stateEffect(Fighter fighter) {
        fighter.setSkipTurn(true);  // Enable skip turn
        paralysisCount++;
    }
    @Override
    public String getStateName() {
        return "Paralyzed State";
    }
}