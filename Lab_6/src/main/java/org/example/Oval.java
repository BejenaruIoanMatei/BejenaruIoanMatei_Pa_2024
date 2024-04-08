package org.example;
import java.awt.*;

public class Oval {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Oval(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.BLACK;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, width, height);
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
