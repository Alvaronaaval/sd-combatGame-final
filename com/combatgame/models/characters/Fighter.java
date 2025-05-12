package com.combatgame.models.characters;
import com.combatgame.models.objects.Attack;
import com.combatgame.models.objects.Weapon;

public interface Fighter {
    void takeTurn();
    void receiveDamage(Attack attack, Fighter opponent);
    boolean isAlive();
    String getType();
    boolean isFaster(Fighter opponent);
    void checkStatusEffect(Fighter opponent, Attack attack);

    Attributes getAttributes();
    boolean getSkipTurn();
    Attack getPrimaryAttack();
    Attack getSecondaryAttack();
    Weapon getWeapon();

    void applyState(CharacterState newState);
    void setSkipTurn(boolean skipTurn);
}

// interfaz que sirve para definir los métodos que deben implementar tanto los enemigos como los jugadores
