package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bag {
    // Am o lista de placi 1-5 pe care le pun intr o punga
    private List<Tile> tiles = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public Bag(int n)
    {
        for (int i = 1; i <= n; i++)
        {
            for (int j = i + 1; j <= n; j++)
            {
                tiles.add(new Tile(i, j));
            }
        }
    }

    public synchronized List<Tile> extractTiles(int howMany)
    {
        List<Tile> extracted = new ArrayList<>();
        lock.lock();
        for (int i = 0; i < howMany && !tiles.isEmpty(); i++)
        {
            extracted.add(tiles.remove(0));
        }
        lock.unlock();
        return extracted;
    }

}