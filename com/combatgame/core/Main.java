package com.combatgame.core;

import com.combatgame.models.characters.Player;
import com.combatgame.models.objects.Weapon;
import com.combatgame.gamestate.StatSelectUI;
import com.combatgame.gamestate.WeaponSelectUi;
import com.combatgame.gamestate.RandomEnemyGenerator;
import com.combatgame.models.characters.Fighter;

public class Main {
    public static void main(String[] args) {
        // Create the player character
        Player player = new Player();

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
        System.out.println("Strength: " + player.getAttributes().getStrength());
        System.out.println("Speed: " + player.getAttributes().getSpeed());
        System.out.println("Defense: " + player.getAttributes().getDefense());
        System.out.println("Magic: " + player.getAttributes().getMagic());
        System.out.println("Agility: " + player.getAttributes().getAgility());
    }
}

