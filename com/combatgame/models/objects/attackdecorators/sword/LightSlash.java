package com.combatgame.models.objects.attackdecorators.sword;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.Attack;

public class LightSlash implements Attack {
    private Weapon weapon;

    public LightSlash(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void executeAttack() {
        System.out.println("Executing Light Slash!");
    }

    @Override
    public int getDamage() {
        return weapon.getDamage(); // Example: Light Slash adds 5 damage
    }
}
