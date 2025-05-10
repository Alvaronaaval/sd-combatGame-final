package com.combatgame.models.characters;

public abstract class Attributes {

    private int health;     // 0-100
    private int strength;   // 0-10
    private int agility;    // 0-10
    private int defense;    // 0-10
    private int magic;      // 0-10
    private int speed;      // 0-10

    private CharacterState state; // character state

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
        this.health = Math.max(0, Math.min(10, health));                                              // All characters start with 100 health
    }

    public void setStrength(int strength, int points) {
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

    private bool validStat(int stat) {
        if (stat < 0 || stat > 10) {
            System.out.println("Invalid stat value. Must be between 0 and 10.");
            return false;
        }
        return true;
    }

    public void setPlayerStats() {
        Scanner scan = new Scanner(System.in);
		int strength, agility, defense, magic, speed;
        int totalPoints = 30;
        
        System.out.println("Distribute a total of 30 points to your character (0-10 per stat): ");
        while(totalPoints != 0) {
            totalPoints = 30;
            do {
                System.out.printf("\nStrength: ");
                strength = scan.nextInt();
            } while(!validStat(strength));
            do {
                System.out.printf("\nDefense: ");
                defense = scan.nextInt();
            } while(!validStat(defense));
            do {
                System.out.printf("\nSpeed: ");
                speed = scan.nextInt();
            } while(!validStat(speed));
            do {
                System.out.printf("\nAgility: ");
                agility = scan.nextInt();
            } while(!validStat(agility));
            do {
                System.out.printf("\nMagic: ");
                magic = scan.nextInt();
            } while(!validStat(magic));

            totalPoints = totalPoints - (strength + agility + defense + magic + speed);
            if(totalPoints != 0) System.out.println("\nThe 30 points have been distributed incorrectly. Please try again.");
            else System.out.println("\nThe 30 points have been distributed correctly.");
        }
        scanner.close();

        setHealth(100);
        setStrength(strength);
        setAgility(agility);
        setDefense(defense);
        setMagic(magic);
        setSpeed(speed);
    }

    public void applyState(CharacterState newState) {
        this.state = newState;
    }
}