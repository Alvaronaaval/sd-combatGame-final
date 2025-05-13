package com.combatgame.models.characters;

public class NormalState implements CharacterState {
    @Override
    public void paralyzed(Fighter fighter) {
        fighter.applyState(new ParalyzedState());
        System.out.println("Character is now in Paralyzed State.");
    }
    @Override
    public void enraged(Fighter fighter) {
        fighter.applyState(new EnragedState());
        System.out.println("Character is now in Enraged State.");
    }
    @Override
    public void burned(Fighter fighter) {
        fighter.applyState(new BurnedState());
        System.out.println("Character is now in Burned State.");
    }
    @Override
    public void healed(Fighter fighter) {
        System.out.println("Character is already healed.");
    }

    @Override
    public void checkStatus(Fighter fighter, Fighter opponent) {
        if(fighter.getAttributes().getHealth() < 20) // Enter Enraged state if health is below 20
            enraged(fighter);
        if(opponent.getWeapon().getName() == "Staff") {
            if(opponent.getPrimaryAttack().getName() == "Fireball") {
                burned(fighter);
            } else if(opponent.getSecondaryAttack().getName() == "IceShard") {
                paralyzed(fighter);
            }
        }
    }
    @Override
    public void stateEffect(Fighter fighter) {
        System.out.println("Status: normal"); // No effect on attributes
    }
    @Override
    public String getStateName() {
        return "Normal State";
    }
}