package com.combatgame.models.objects.attackdecorators.dagger;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.Attack;

public class QuickStab implements Attack {
    private Weapon weapon;

    public QuickStab(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void executeAttack() {
        System.out.println("Executing Quick Stab!");
    }

    @Override
    public int getDamage() {
        return weapon.getDamage(); // Quick Stab adds 3 damage
        // function to apply wounded status effect
    }
}
