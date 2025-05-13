package com.combatgame.core;

import com.combatgame.gamestate.CombatManager;
import com.combatgame.gamestate.RandomEnemyGenerator;
import com.combatgame.gamestate.StatSelectUI;
import com.combatgame.gamestate.WeaponSelectUi;
import com.combatgame.models.characters.Fighter;
import com.combatgame.models.characters.Player;
import com.combatgame.models.characters.Score;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create the player character
        Player player = new Player();
        player.addObserver(Score.getInstance());


        // Step 1: Stat selection
        StatSelectUI statSelectUI = new StatSelectUI();
        statSelectUI.StatSelectMenu(player); // Let the player distribute their stats

        // Step 2: Weapon selection
        WeaponSelectUi weaponSelectUi = new WeaponSelectUi();
        weaponSelectUi.WeaponSelectMenu(player); // Let the player choose their weapon

        // Step 3: Create an enemy and Scenario
        Fighter enemy = RandomEnemyGenerator.generate();

        // Now you can display the player's selected weapon and stats
        System.out.println("Player selected: " + player.getWeapon().getName());
        System.out.println("Health: " + player.getAttributes().getHealth());
        System.out.println("Strength: " + player.getAttributes().getStrength());
        System.out.println("Speed: " + player.getAttributes().getSpeed());
        System.out.println("Defense: " + player.getAttributes().getDefense());
        System.out.println("Magic: " + player.getAttributes().getMagic());
        System.out.println("Agility: " + player.getAttributes().getAgility());

        // Display enemy stats
        System.out.println("Enemy selected: " + enemy.getWeapon().getName());
        System.out.println("Health: " + enemy.getAttributes().getHealth());
        System.out.println("Strength: " + enemy.getAttributes().getStrength());
        System.out.println("Speed: " + enemy.getAttributes().getSpeed());
        System.out.println("Defense: " + enemy.getAttributes().getDefense());
        System.out.println("Magic: " + enemy.getAttributes().getMagic());
        System.out.println("Agility: " + enemy.getAttributes().getAgility());

        // Step 4: Start combat (simplified)
        startCombat(player, enemy);

    }

    // Method to start combat between player and enemy
    private static void startCombat(Player player, Fighter enemy) {
        // Create an instance of the CombatManager to handle combat logic
        CombatManager combatManager = new CombatManager();

        // Simple combat loop (player vs enemy)
        System.out.println("\nCombat begins!");

        // Create a scanner for user input (do not close it here)
        Scanner scanner = new Scanner(System.in);

        // While both are alive, continue the combat
        while (player.isAlive() && enemy.isAlive()) {
            // Display status
            System.out.println("\nPlayer Health: " + player.getAttributes().getHealth());
            System.out.println("Enemy Health: " + enemy.getAttributes().getHealth());

            // Prompt player to choose an attack (primary or secondary)
            int attackChoice = getValidAttackChoice(scanner); // Get user input for the attack

            // Determine who attacks first based on speed
            if (player.isFaster(enemy)) {
                if(!player.getSkipTurn()) { // Execute if player skipTurn is false
                    // Player attacks first, perform selected attack
                    if (attackChoice == 1) {
                        combatManager.performAttack(player, enemy, 1); // Player uses primary attack
                    } else {
                        combatManager.performAttack(player, enemy, 2); // Player uses secondary attack
                    }
                }
                if(!enemy.getSkipTurn()) {  // Execute if enemy skipTurn is false
                    if (enemy.isAlive()) {
                        java.util.Random r = new java.util.Random();
                        int randomEnemyAttack = r.nextInt(2) + 1; // Randomly choose number 1 or 2
                        combatManager.performAttack(enemy, player, randomEnemyAttack); // Enemy attacks back
                    }
                }
            } else {
                if(!enemy.getSkipTurn()) {  // Execute if enemy skipTurn is false
                    // Enemy attacks first
                    java.util.Random r = new java.util.Random();
                    int randomEnemyAttack = r.nextInt(2) + 1; // Randomly choose number 1 or 2
                    combatManager.performAttack(enemy, player, randomEnemyAttack); // Enemy uses random attack
                }
                if(!player.getSkipTurn()) { // Execute if player skipTurn is false
                    if (player.isAlive()) {
                        // Prompt the player to choose their attack after the enemy's turn
                        System.out.println("It's your turn!");
                        attackChoice = getValidAttackChoice(scanner); // Get user input for the attack
                        if (attackChoice == 1) {
                            combatManager.performAttack(player, enemy, 1); // Player uses primary attack
                        } else {
                            combatManager.performAttack(player, enemy, 2); // Player uses secondary attack
                        }
                    }
                }
            }
        }

        // Determine the outcome
        if (player.isAlive()) {
            System.out.println("Player wins!");
            // Comprobamos si el player es una instancia de Player real
            if (player instanceof Player) {
                ((Player) player).onEnemyKilled(enemy); // onEnemyKilled es un metodo específico de la clase Player.
                                                        // pero estamos usando un player de tipo Fighter (interfaz),
                                                        // que no usa ese metodo, y por eso lo casteamos a Player para usarlo
            }
        } else {
            System.out.println("Enemy wins!");
        }
        System.out.println("Final Score: " + Score.getInstance().getTotalPoints());


        // Close the scanner here after the combat ends
        scanner.close();
    }

    // Helper method to get a valid attack choice from the user
    private static int getValidAttackChoice(Scanner scanner) {
        int attackChoice = 0;
        while (attackChoice != 1 && attackChoice != 2) {
            System.out.println("Choose your attack:");
            System.out.println("1. Primary Attack");
            System.out.println("2. Secondary Attack");

            if (scanner.hasNextInt()) {
                attackChoice = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer to consume the newline character
                if (attackChoice != 1 && attackChoice != 2) {
                    System.out.println("Invalid input. Please choose 1 or 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number (1 or 2).");
                scanner.nextLine(); // Consume the invalid input (the non-numeric input)
            }
        }
        return attackChoice;
    }
}