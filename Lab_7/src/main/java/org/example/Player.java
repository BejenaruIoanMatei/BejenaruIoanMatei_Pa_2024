package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Player implements Runnable
{
    private String name;
    private Game game;
    private boolean playerRunning = true;

    public Player(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void run()
    {
        while (playerRunning)
        {
            List<Tile> tiles = game.getBag().extractTiles(2);
            if (tiles.isEmpty())
            {
                playerRunning = false;
                break;
            }
            System.out.println(name + " a extras " + tiles);
        }
    }
}