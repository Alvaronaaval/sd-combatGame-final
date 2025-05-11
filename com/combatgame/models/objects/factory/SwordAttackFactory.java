package com.combatgame.models.objects.factory;

import com.combatgame.models.objects.Attack;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.attackdecorators.sword.LightSlash;
import com.combatgame.models.objects.attackdecorators.sword.HeavySwing;

public class SwordAttackFactory implements AttackFactory {
    public Attack createPrimaryAttack(Weapon weapon) {
        return new LightSlash(weapon);
    }

    public Attack createSecondaryAttack(Weapon weapon) {
        return new HeavySwing(weapon);
    }
}
