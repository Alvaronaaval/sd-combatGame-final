package com.combatgame.models.characters;

public abstract class Character {
    private int health;
    private int strength;
    private int defense;
    private int agility;
    private int magic;
    private int stealth;
    private CharacterState state;

    public Character(int health, int strength, int defense, int agility, int magic, int stealth) {
        this.health = health;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
        this.magic = magic;
        this.stealth = stealth;
        state = new NormalState(this); //Default state
    }

    public void applyState(CharacterState newState) {
        this.state = newState;
    }


}