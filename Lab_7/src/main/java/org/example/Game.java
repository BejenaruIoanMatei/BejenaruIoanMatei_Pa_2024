package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Game
{
    private Bag bag;
    private List<Player> players = new ArrayList<>();

    public Game() {
        this.bag = new Bag(5);
        //Placile o sa contina numere din interv 1-5
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play()
    {
        for (Player player : players)
        {
            new Thread(player).start();
        }
    }

    public Bag getBag() {
        return bag;
    }
}
