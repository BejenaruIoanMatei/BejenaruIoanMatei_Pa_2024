package org.example;

import java.awt.Color;
import java.io.Serializable;

public class Stone implements Serializable {
    private static final long serialVersionUID = 1L;
    private int row;
    private int col;
    private Color color;

    public Stone()
    {

    }
    public Stone(int row, int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Color getColor() {
        return color;
    }
}
