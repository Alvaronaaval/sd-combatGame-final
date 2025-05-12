package com.combatgame.models.objects.attackdecorators.dagger;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.Attack;

public class  Slash implements Attack {
    private final Weapon weapon;

    public Slash(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void executeAttack() {
        System.out.println("Executing Slash!");
    }

    @Override
    public int getDamage() {
        return weapon.getDamage() + 2; // Slash adds 2 damage
    }
    @Override
    public String getName() {
        return "Slash";
    }
}
