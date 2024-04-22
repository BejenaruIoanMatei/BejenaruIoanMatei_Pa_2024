package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Player implements Runnable {
    private String name;
    private Game game;
    private List<List<Tile>> sequences = new ArrayList<>();
    private int points = 0;
    private boolean playerRunning = true;

    public Player(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (playerRunning&&game.gameRunning) {
            List<Tile> tiles = game.getBag().extractTiles(2);
            if (tiles.isEmpty()) {
                playerRunning = false;
                break;
            }
            System.out.println(name + " a extras " + tiles);
            updateSequences(tiles);
        }
        System.out.println(name + " a terminat. Secvente: " + sequences);
    }

    private void updateSequences(List<Tile> tiles) {
        for (Tile tile : tiles) {
            for (List<Tile> sequence : sequences) {
                if (isValidSequence(sequence, tile)) {
                    sequence.add(tile);
                    points = Math.max(points, sequence.size());
                    return;
                }
            }
            List<Tile> newSequence = new ArrayList<>();
            newSequence.add(tile);
            sequences.add(newSequence);
            points = Math.max(points, 1);
        }
    }

    private boolean isValidSequence(List<Tile> sequence, Tile newTile) {
        Tile lastTile = sequence.get(sequence.size() - 1);
        return lastTile.getNumber2() == newTile.getNumber1();
    }

    public int getPoints() {
        return points;
    }
    public void stopPlayer() {
        playerRunning = false;
    }
}