package com.combatgame.models.characters;

public class Player implements Fighter {

    protected Attributes attributes; // player attributes
    private CharacterState state; // character state

    public Player() {
        state = new NormalState(); //Default state
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

        attributes.setHealth(100);
        attributes.setStrength(strength);
        attributes.setAgility(agility);
        attributes.setDefense(defense);
        attributes.setMagic(magic);
        attributes.setSpeed(speed);
    }

    public void applyState(CharacterState newState) {
        this.state = newState;
    }
}