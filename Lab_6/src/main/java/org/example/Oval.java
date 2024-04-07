package org.example;
import java.awt.*;

public class Oval {
    private int x; // coordonata x a ovalului
    private int y; // coordonata y a ovalului
    private int width; // latimea ovalului
    private int height; // inaltimea ovalului
    private Color color; // culoarea ovalului

    // Constructor care initializează un oval cu coordonatele (x, y), lățimea și înălțimea specificate
    public Oval(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.BLACK; // Setăm culoarea implicită la negru
    }

    // Metoda pentru a desena ovalul pe un context grafic
    public void paint(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, width, height);
    }

    // Metoda pentru a seta culoarea ovalului
    public void setColor(Color color) {
        this.color = color;
    }

    // Metoda pentru a obține coordonata x a ovalului
    public int getX() {
        return x;
    }

    // Metoda pentru a obține coordonata y a ovalului
    public int getY() {
        return y;
    }

    // Metoda pentru a obține latimea ovalului
    public int getWidth() {
        return width;
    }

    // Metoda pentru a obține înălțimea ovalului
    public int getHeight() {
        return height;
    }
}
