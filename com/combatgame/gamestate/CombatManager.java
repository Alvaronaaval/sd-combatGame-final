package com.combatgame.gamestate;

import com.combatgame.models.characters.Fighter;
import com.combatgame.models.objects.Attack;
import com.combatgame.models.objects.DamageType;

public class CombatManager {

    public void performAttack(Fighter attacker, Fighter defender, int attackType) {
        // Determines who attacks first based on speed
        Fighter firstAttacker = (attacker.isFaster(defender)) ? attacker : defender;
        Fighter secondAttacker = (firstAttacker == attacker) ? defender : attacker;

        // The first attacker performs their attack
        Attack attackToExecute = getAttack(attackType, firstAttacker);
        executeAttack(firstAttacker, secondAttacker, attackToExecute);
    }

    private Attack getAttack(int attackType, Fighter attacker) {
        // Retrieves the attack based on type (1 = primary, 2 = secondary)
        if (attackType == 1) {
            return attacker.getPrimaryAttack();
        } else {
            return attacker.getSecondaryAttack();
        }
    }

    private void executeAttack(Fighter attacker, Fighter defender, Attack attack) {
        // Calculates base damage
        int damage = calculateBaseDamage(attacker, defender, attack);

        // Determines if the attack is dodged
        if (isAttackDodged(attacker, defender)) {
            System.out.println(defender.getType() + " dodged the attack!");
            return; // The attack was dodged
        }

        // If not dodged, apply the damage
        defender.receiveDamage(attack, attacker);

        System.out.println(attacker.getType() + " attacked " + defender.getType() + " with " + attack.getName() + " dealing " + damage + " damage.");
    }

    private int calculateBaseDamage(Fighter attacker, Fighter defender, Attack attack) {
        // Calculates base damage according to the rules
        int baseDamage = attack.getDamage();
        int strengthMultiplier = attacker.getAttributes().getStrength() * 2;
        int defense = defender.getAttributes().getDefense();

        if (attacker.getWeapon().getDamageType() == DamageType.PHYSICAL) {
            return baseDamage + strengthMultiplier - defense;
        } else { // MAGICAL
            return baseDamage + (attacker.getAttributes().getMagic() * 2) - (defender.getAttributes().getDefense() / 2);
        }
    }

    private boolean isAttackDodged(Fighter attacker, Fighter defender) {
        // Calculates the dodge chance
        double dodgeChance = 0.10; // Base dodge chance is 10%

        // Increases or decreases the probability based on agility
        int agilityDifference = defender.getAttributes().getAgility() - attacker.getAttributes().getAgility();
        if (agilityDifference > 0) {
            dodgeChance -= 0.05 * agilityDifference;
        } else {
            dodgeChance += 0.05 * Math.abs(agilityDifference);
        }

        // Ensures the probability cannot be negative
        dodgeChance = Math.max(0, dodgeChance);

        // If the random value is less than the dodge chance, the attack is dodged
        return Math.random() < dodgeChance;
    }
}
