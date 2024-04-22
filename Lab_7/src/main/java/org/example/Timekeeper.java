package org.example;

public class Timekeeper implements Runnable {
    private final Game game;
    private final long timeLimit; //in milliseconds

    public Timekeeper(Game game, long timeLimit) {
        this.game = game;
        this.timeLimit = timeLimit ;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeLimit);
        } catch (InterruptedException e) {
            System.out.println("Timekeeper was interrupted.");
            return;
        }
        System.out.println("---------------------------------");
        System.out.println("Timekeeper : Timpul a expirat.");
        System.out.println("---------------------------------");
        game.stopGame();
    }
}
