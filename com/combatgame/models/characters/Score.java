package com.combatgame.models.characters;

import com.combatgame.models.characters.Observer;

public class Score implements Observer {
    private static Score instance;
    private int totalPoints;

    private Score() {
        totalPoints = 0;
    }

    public static Score getInstance() {                                 // Singleton to avoid multiple instances
        if (instance == null) {
            instance = new Score();
        }
        return instance;
    }

    public void addPoints(int points) {
        totalPoints += points;
        System.out.println("🟢 +"+points+" points! Total Score: " + totalPoints);
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void resetScore() {
        totalPoints = 0;
    }

    @Override
    public void onEnemyDefeated() {
        addPoints(100);  // le ponemos la cantidad de puntos que queremos que sume al derrotar un enemigo
    }
}
