package com.combatgame.models.objects.factory;

import com.combatgame.models.objects.Attack;
import com.combatgame.models.objects.Weapon;
import com.combatgame.models.objects.attackdecorators.bow.ChargedShot;
import com.combatgame.models.objects.attackdecorators.bow.QuickShot;

public class BowAttackFactory implements AttackFactory {
    public Attack createPrimaryAttack(Weapon weapon) {
        return new QuickShot(weapon);
    }

    public Attack createSecondaryAttack(Weapon weapon) {
        return new ChargedShot(weapon);
    }
}

