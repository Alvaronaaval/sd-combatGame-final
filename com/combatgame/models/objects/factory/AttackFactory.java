package com.combatgame.models.objects.factory;

import com.combatgame.models.objects.Attack;
import com.combatgame.models.objects.Weapon;

public interface AttackFactory {
    Attack createPrimaryAttack(Weapon weapon);
    Attack createSecondaryAttack(Weapon weapon);
}

