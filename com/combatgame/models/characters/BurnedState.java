package com.combatgame.models.characters;

public class BurnedState implements CharacterState {
    int burnedCount = 0; // Counter for burn effect
    static int maxBurnedCount = 3; // Maximum number of burn effects

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
        burnedCount = 0; // Reset burn count after healing
    }
    public void checkStatus(CharacterState state, Attributes attributes) {
        System.out.println("Character is in Burned State.");
        if(burnedCount >= maxBurnedCount)
            healed(state); // Return to Normal State after Burned State is active for 3 turns
    }
    @Override
    public void stateEffect(Attributes attributes) {
        attributes.setHealth(attributes.getHealth() - 5); // Burn effect reduces health by 5
        burnedCount++;
    }
    @Override
    public String getStateName() {
        return "Burned State";
    }
}