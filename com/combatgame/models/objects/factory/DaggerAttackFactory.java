package com.combatgame.models.objects.factory;

import com.combatgame.models.objects.Attack;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.attackdecorators.dagger.QuickStab;
import com.combatgame.models.objects.attackdecorators.dagger.Slash;

public class DaggerAttackFactory implements AttackFactory {
    public Attack createPrimaryAttack(Weapon weapon) {
        return new QuickStab(weapon);
    }

    public Attack createSecondaryAttack(Weapon weapon) {
        return new Slash(weapon);
    }
}