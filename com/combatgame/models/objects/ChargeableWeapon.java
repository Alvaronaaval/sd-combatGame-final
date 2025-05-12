package com.combatgame.models.objects;

public interface ChargeableWeapon extends Weapon {
    void charge();
    void uncharge();
    boolean isCharged();
}

