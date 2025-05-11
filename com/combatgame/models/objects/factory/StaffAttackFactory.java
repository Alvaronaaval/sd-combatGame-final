package com.combatgame.models.objects.factory;

import com.combatgame.models.objects.Attack;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.attackdecorators.staff.Fireball;
import com.combatgame.models.objects.attackdecorators.staff.IceShard;

public class StaffAttackFactory implements AttackFactory {
    public Attack createPrimaryAttack(Weapon weapon) {
        return new Fireball(weapon);
    }

    public Attack createSecondaryAttack(Weapon weapon) {
        return new IceShard(weapon);
    }
}