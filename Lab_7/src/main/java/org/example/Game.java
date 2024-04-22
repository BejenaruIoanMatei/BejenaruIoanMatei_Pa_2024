package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Game {
    private Bag bag;
    private List<Player> players = new ArrayList<>();
    private int currentPlayerIndex = 0;
    private final Object turnLock = new Object();

    public Game() {
        this.bag = new Bag(5);
        // Placile o sa contina numere din intervalul 1-5
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() {
        List<Thread> playerThreads = new ArrayList<>();
        for (Player player : players) {
            Thread playerThread = new Thread(player);
            playerThreads.add(playerThread);
            playerThread.start();
        }
        for (Thread playerThread : playerThreads) {
            try {
                playerThread.join(); // Wait for all player threads to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Player winner = determineWinner();
        System.out.println("-------Anuntam castigatorul--------");
        System.out.println("Winner is: " + winner.getName() + " with " + winner.getPoints() + " points.");
    }

    public Bag getBag() {
        return bag;
    }

    public Player determineWinner() {
        Player winner = players.get(0);
        for (Player player : players) {
            if (player.getPoints() > winner.getPoints()) {
                winner = player;
            }
        }
        return winner;
    }

    //am folosit turnLock pentru a sincroniza jucatorii
    //fiecare jucator isi asteapta randul pentru a extrage din punga
    public void nextPlayerTurn() {
        synchronized (turnLock) {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            turnLock.notifyAll();
        }
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }
}
