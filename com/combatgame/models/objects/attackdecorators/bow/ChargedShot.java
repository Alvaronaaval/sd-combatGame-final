package com.combatgame.models.objects.attackdecorators.bow;
import com.combatgame.models.objects.ChargeableWeapon;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.Attack;


public class ChargedShot implements Attack {
    private final ChargeableWeapon bow;
    private String name = "Charged Shot";

    public ChargedShot(ChargeableWeapon bow) {
        this.bow = bow;
    }

    @Override
    public void executeAttack() {
        if (bow.isCharged()) {
            System.out.println("Charged arrow Shot!");
            bow.uncharge();
        } else {
            System.out.println("Executing Charged Shot! Charging...");
            bow.charge();

        }
    }

    @Override
    public int getDamage() {
        return bow.getDamage() + 15; // Charged Shot adds more damage
    }
    @Override
    public String getName() {
        return name;
    }

}
