package com.combatgame.models.characters;

public abstract class Attributes {

    private int health;     // 0-100
    private int strength;   // 0-10
    private int agility;    // 0-10
    private int defense;    // 0-10
    private int magic;      // 0-10
    private int speed;      // 0-10

    priavate CharacterState state; // character state

    public Attributes(int health, int strength, int agility, int defense, int magic, int speed) {           // constructor
        setHealth(health);
        setStrength(strength);
        setAgility(agility);
        setDefense(defense);
        setMagic(magic);
        setSpeed(speed);
        state = new NormalState(); //Default state
    }

    // getters
    public int getHealth() { return health; }
    public int getStrength() { return strength; }
    public int getAgility() { return agility; }
    public int getDefense() { return defense; }
    public int getMagic() { return magic; }
    public int getSpeed() { return speed; }

    // setters
    public void setHealth(int health) {
        this.health = Math.max(0, Math.min(100, health));               // usa una validacion de rango 0-100
    }

    public void setStrength(int strength) {
        this.strength = Math.max(0, Math.min(10, strength));            // usa una validacion de rango 0-10
    }

    public void setAgility(int agility) {
        this.agility = Math.max(0, Math.min(10, agility));              // usa una validacion de rango 0-10
    }

    public void setDefense(int defense) {
        this.defense = Math.max(0, Math.min(10, defense));              // usa una validacion de rango 0-10
    }

    public void setMagic(int magic) {
        this.magic = Math.max(0, Math.min(10, magic));                  // usa una validacion de rango 0-10
    }

    public void setSpeed(int speed) {
        this.speed = Math.max(0, Math.min(10, speed));                  // usa una validacion de rango 0-10
    }

    public void applyState(CharacterState newState) {
        this.state = newState;
    }
}