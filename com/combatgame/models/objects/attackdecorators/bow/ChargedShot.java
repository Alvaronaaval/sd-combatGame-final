package com.combatgame.models.objects.attackdecorators.bow;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.Attack;

public class ChargedShot implements Attack {
    private Weapon weapon;

    public ChargedShot(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void executeAttack() {
        System.out.println("Executing Charged Shot! Charging...");
        // Implement 2 turn charging logic here
        // For example, you can use a boolean flag to indicate if the shot is charged
        // and then apply the damage bonus when the shot is executed
    }

    @Override
    public int getDamage() {
        return weapon.getDamage() + 15; // Charged Shot adds more damage
    }
}
