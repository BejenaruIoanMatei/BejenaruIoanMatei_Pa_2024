package org.example;

public class Player {
    private final String name;
    private long remainingTime; // Remaining time in milliseconds

    public Player(String name, long startingTime) {
        this.name = name;
        this.remainingTime = startingTime;
    }

    public String getName() {
        return name;
    }

    public long getRemainingTime() {
        return remainingTime;
    }

    public void decrementTime(long timeSpent) {
        this.remainingTime -= timeSpent;
    }

    public boolean hasTimeLeft() {
        return remainingTime > 0;
    }
}
