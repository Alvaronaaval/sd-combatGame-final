package com.combatgame.models.characters;
import com.combatgame.models.characters.Observer;

public interface Subject {

    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyEnemyDefeated();

}
