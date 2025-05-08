package com.combatgame.models.objects.attackdecorators.bow;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.Attack;

public class QuickShot implements Attack {
    private Weapon weapon;

    public QuickShot(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void executeAttack() {
        System.out.println("Executing Quick Shot!");
    }

    @Override
    public int getDamage() {
        return weapon.getDamage(); // Quick Shot adds 3 damage
    }
}
