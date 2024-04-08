package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class DrawingPanel extends JPanel {
    private int rows;
    private int cols;
    private final int stoneSize = 20;
    private boolean isPlayer1Turn = true; // Variabilă pentru a ține evidența rândului jucătorului

    private Stone[][] stones; // Matrice pentru a stoca pietrele
    private Random random = new Random(); // Obiect pentru generarea de numere aleatoare



    public DrawingPanel(int initialRows, int initialCols) {
        this.rows = initialRows;
        this.cols = initialCols;
        init();
    }



    private void init() {
        setPreferredSize(new Dimension(400, 400));
        // Adăugăm un MouseListener pentru a detecta clicurile pentru a plasa pietrele
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int cellWidth = getWidth() / cols;
                int cellHeight = getHeight() / rows;

                // Determinăm centrul celulei în care s-a făcut clic
                int centerX = e.getX() / cellWidth * cellWidth + cellWidth / 2;
                int centerY = e.getY() / cellHeight * cellHeight + cellHeight / 2;

                // Schimbăm culoarea pietrei în funcție de rândul jucătorului
                Color stoneColor = isPlayer1Turn ? Color.BLUE : Color.RED;

                // Desenăm piatra la locația mouse-ului
                Graphics g = getGraphics();
                drawStone(g, centerX - stoneSize / 2, centerY - stoneSize / 2, stoneColor);

                // Schimbăm rândul jucătorului
                isPlayer1Turn = !isPlayer1Turn;
            }

        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGrid(g);
    }

    public void setGridSize(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        revalidate(); // Aici adăugăm revalidarea pentru a asigura recalculele layout-ului
        repaint(); // Redesenează componenta cu noile dimensiuni
    }

    private void paintGrid(Graphics g) {
        int cellWidth = getWidth() / cols;
        int cellHeight = getHeight() / rows;

        g.setColor(Color.GRAY);

        // Desenează liniile orizontale și nodurile (intersecțiile)
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * cellWidth + cellWidth / 2 - stoneSize / 2; // Ajustăm pentru a centra punctele în celulă
                int y = row * cellHeight + cellHeight / 2 - stoneSize / 2; // Ajustăm pentru a centra punctele în celulă
                g.drawLine(x, y, x, y); // Desenăm punctul la aceeași poziție cu linia
                g.fillOval(x, y, stoneSize, stoneSize);
            }
        }

        g.setColor(Color.BLACK);

        // Desenează liniile verticale
        for (int col = 0; col < cols; col++) {
            int x = col * cellWidth + cellWidth / 2; // Ajustăm pentru a centra liniile în celulă
            g.drawLine(x, 0, x, getHeight());
        }



        // Desenează liniile orizontale
        for (int row = 0; row < rows; row++) {
            int y = row * cellHeight + cellHeight / 2; // Ajustăm pentru a centra liniile în celulă
            g.drawLine(0, y, getWidth(), y);
        }

        /*
        g.setColor(Color.RED);

        // Desenează liniile verticale
        for (int col = random.nextInt(cols); col < cols; col++) {
            int x = col * cellWidth + cellWidth / 2; // Ajustăm pentru a centra liniile în celulă
            g.drawLine(x, 0, x, getHeight());
        }
        */

    }
    private void drawStone(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.fillOval(x, y, stoneSize, stoneSize);
    }

    // Funcție pentru exportarea imaginii tabloului de joc într-un fișier PNG
    public void exportGameBoardImage(String fileName) {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        paint(g2d);
        g2d.dispose();

        File outputFile = new File(fileName);
        try {
            ImageIO.write(image, "png", outputFile);
            System.out.println("Imaginea tabloului de joc a fost exportată cu succes în fișierul " + fileName);
        } catch (IOException e) {
            System.err.println("Eroare la exportarea imaginii tabloului de joc: " + e.getMessage());
        }
    }
}

