package com.combatgame.models.objects.attackdecorators.staff;
import  com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.Attack;

public class Fireball implements Attack {
    private Weapon weapon;

    public Fireball(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void executeAttack() {
        System.out.println("Casting Fireball! Causes burn over time.");
        // Fireball burn logic can be added here
    }

    @Override
    public int getDamage() {
        return weapon.getDamage(); // Fireball adds burn damage
    }
}
