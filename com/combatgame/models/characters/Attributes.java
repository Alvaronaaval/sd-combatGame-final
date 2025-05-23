package com.combatgame.models.characters;

public class Attributes {

    private int health;     // 0-100
    private int strength;   // 0-10
    private int agility;    // 0-10
    private int defense;    // 0-10
    private int magic;      // 0-10
    private int speed;      // 0-10

    public Attributes(int health, int strength, int agility, int defense, int magic, int speed) {           // constructor
        setHealth(health);
        setStrength(strength);
        setAgility(agility);
        setDefense(defense);
        setMagic(magic);
        setSpeed(speed);
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
        this.health = Math.max(0, Math.min(100, health));                // All characters start with 100 health
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

    public static Attributes randomAttributes() {                       // crea atributos aleatorios
        java.util.Random r = new java.util.Random();
        return new Attributes(
                100,                    // health inicial siempre 100
                r.nextInt(11),          // fuerza 0–10
                r.nextInt(11),          // agilidad 0–10
                r.nextInt(11),          // defensa 0–10
                r.nextInt(11),          // magia 0–10
                r.nextInt(11)           // velocidad 0–10
        );
    }
}