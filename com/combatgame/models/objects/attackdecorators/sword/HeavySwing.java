package com.combatgame.models.objects.attackdecorators.sword;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.Attack;

public class HeavySwing implements Attack {
    private Weapon weapon;

    public HeavySwing(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void executeAttack() {
        System.out.println("Executing Heavy Swing!");
        // I need to add logic here to make the attack have a chance to miss
    }

    @Override
    public int getDamage() {
        return weapon.getDamage() + 10; // Heavy Swing adds 10 damage
    }
}