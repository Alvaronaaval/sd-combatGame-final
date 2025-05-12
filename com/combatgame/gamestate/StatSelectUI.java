package com.combatgame.gamestate;
import com.combatgame.models.characters.Player;
import java.util.Scanner;

public class StatSelectUI {
    Scanner scan = new Scanner(System.in);
    private int strength = 0;
    private int agility = 0;
    private int defense = 0;
    private int magic = 0;
    private int speed = 0;
    private int totalPoints = 30;

    private boolean validStat(int stat) {
        if (stat < 0 || stat > 10) {
            System.out.println("Invalid stat value. Must be between 0 and 10.");
            return false;
        }
        return true;
    }

    public void StatSelectMenu(Player player) {        
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
        player.setAttributes(100, strength, agility, defense, magic, speed);
    }
}