package com.combatgame.models.characters;
import com.combatgame.models.objects.Attack;
import com.combatgame.models.objects.DamageType;
import com.combatgame.models.objects.Weapon;
import java.util.ArrayList;
import java.util.List;

public class Player implements Fighter, Subject  {
    protected Attributes attributes; // player attributes
    private CharacterState state; // character state
    private boolean skipTurn = false; // skip turn flag
    private Weapon weapon; // player weapon
    private Attack primaryAttack; // player attack
    private Attack secondaryAttack; // player attack

    public Player() {
        this.state = new NormalState(); //Default state
    }

    public void setAttributes(int health, int strength, int agility, int defense, int magic, int speed) {
        this.attributes = new Attributes(health, strength, agility, defense, magic, speed);
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public void setPrimaryAttack(Attack primaryAttack) {
        this.primaryAttack = primaryAttack;
    }
    public void setSecondaryAttack(Attack secondaryAttack) {
        this.secondaryAttack = secondaryAttack;
    }

    @Override public String getType() { return "Player"; }
    @Override public Attributes getAttributes() { return attributes; }
    @Override public boolean getSkipTurn() { return skipTurn; }
    @Override public Weapon getWeapon() { return weapon; }
    @Override public Attack getPrimaryAttack() { return primaryAttack; }
    @Override public Attack getSecondaryAttack() { return secondaryAttack; }

    @Override
    public void applyState(CharacterState newState) {
        this.state = newState;
    }

    @Override
    public void setSkipTurn(boolean skipTurn) {
        this.skipTurn = skipTurn;
    }

    @Override
    public void takeTurn() {
        System.out.println("Player's turn.");       // Unfinished method
    }

    public void checkStatusEffect(Fighter opponent, Attack attack) {
        if(opponent.getWeapon().getName() == "Staff") {
            if(opponent.getPrimaryAttack().getName() == "Fireball") {
                applyState(new BurnedState());
            } else if(opponent.getPrimaryAttack().getName() == "IceShard") {
                applyState(new ParalyzedState());
            }
        }
    }

    @Override
    public void receiveDamage(Attack attack, Fighter opponent) { // Receive damage from opponent
        int damageTaken = 0;
        if(opponent.getWeapon().getDamageType() == DamageType.PHYSICAL) {
            damageTaken = (attack.getDamage() + opponent.getAttributes().getStrength()*2) - attributes.getDefense();
        } else {
            damageTaken = (attack.getDamage() + opponent.getAttributes().getMagic()*2) - (attributes.getDefense()*50)/100;
        }
    }

    @Override
    public boolean isFaster(Fighter opponent) {
        if(attributes.getSpeed() > opponent.getAttributes().getSpeed()) {
            return true;
        } else if(attributes.getSpeed() < opponent.getAttributes().getSpeed()) {
            return false;
        } else {
            return Math.random() < 0.5; // Randomly decide who goes first
        }
    }

    @Override
    public boolean isAlive() {
        return attributes.getHealth() > 0;
    }

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyEnemyDefeated() {
        for (Observer o : observers) {
            o.onEnemyDefeated();
        }
    }

    // usar este metodo para notificar a los observadores cuando un enemigo es derrotado
    public void onEnemyKilled(Fighter enemy) {
        if (!enemy.isAlive()) {
            notifyEnemyDefeated();
        }
    }

}