package com.combatgame.models.characters;

public class BurnedState implements CharacterState {
    private int burnedCount = 0; // Counter for burn effect
    private static int maxBurnedCount = 3; // Maximum number of burn effects

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
        burnedCount = 0; // Reset burn count after healing
    }

    @Override
    public void checkStatus(Fighter fighter) {
        if(burnedCount >= maxBurnedCount)
            healed(fighter); // Return to Normal State
    }
    @Override
    public void stateEffect(Fighter fighter) {
        fighter.getAttributes().setHealth(fighter.getAttributes().getHealth() - 5); // Burn effect reduces health by 5
        burnedCount++;
        System.out.println("Status: Burned (5 damage taken per turn)");
    }
    @Override
    public String getStateName() {
        return "Burned State";
    }
}