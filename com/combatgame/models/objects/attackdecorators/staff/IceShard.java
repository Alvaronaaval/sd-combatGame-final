package com.combatgame.models.objects.attackdecorators.staff;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.Attack;

public class IceShard implements Attack {
    private Weapon weapon;

    public IceShard(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void executeAttack() {
        System.out.println("Casting Ice Shard! May freeze the enemy.");
    }

    @Override
    public int getDamage() {
        return weapon.getDamage() + 8; // Ice Shard adds 8 damage
    }

    @Override
    public String getName() {
        return "Ice Shard";
    }
}