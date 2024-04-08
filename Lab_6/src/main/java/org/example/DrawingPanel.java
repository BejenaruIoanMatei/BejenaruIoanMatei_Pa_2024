package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    private int rows;
    private int cols;
    private final int stoneSize = 20;
    private boolean isPlayer1Turn = true;

    private List<Stone> stones = new ArrayList<>(); // Keep track of stones placed on the board

    public DrawingPanel(int initialRows, int initialCols) {
        this.rows = initialRows;
        this.cols = initialCols;
        init();
    }

    private void init() {
        setPreferredSize(new Dimension(400, 400));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int cellWidth = getWidth() / cols;
                int cellHeight = getHeight() / rows;

                int centerX = e.getX() / cellWidth * cellWidth + cellWidth / 2;
                int centerY = e.getY() / cellHeight * cellHeight + cellHeight / 2;

                Color stoneColor = isPlayer1Turn ? Color.BLUE : Color.RED;

                // Add the stone to the list
                stones.add(new Stone(centerX - stoneSize / 2, centerY - stoneSize / 2, stoneColor));

                // Repaint the panel to reflect the changes
                repaint();

                // Save the updated image
                exportGameBoardImage("board.png");

                isPlayer1Turn = !isPlayer1Turn;
            }

        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGrid(g);

        // Paint all stones
        for (Stone stone : stones) {
            g.setColor(stone.getColor());
            g.fillOval(stone.getX(), stone.getY(), stoneSize, stoneSize);
        }
    }

    public void setGridSize(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        revalidate();
        repaint();
    }

    private void paintGrid(Graphics g) {
        int cellWidth = getWidth() / cols;
        int cellHeight = getHeight() / rows;

        g.setColor(Color.GRAY);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * cellWidth + cellWidth / 2 - stoneSize / 2;
                int y = row * cellHeight + cellHeight / 2 - stoneSize / 2;
                g.drawLine(x, y, x, y);
                g.fillOval(x, y, stoneSize, stoneSize);
            }
        }

        g.setColor(Color.BLACK);

        for (int col = 0; col < cols; col++) {
            int x = col * cellWidth + cellWidth / 2;
            g.drawLine(x, 0, x, getHeight());
        }

        for (int row = 0; row < rows; row++) {
            int y = row * cellHeight + cellHeight / 2;
            g.drawLine(0, y, getWidth(), y);
        }
    }

    public void exportGameBoardImage(String fileName) {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        paintComponent(g2d); // Paint the board with stones on the BufferedImage
        g2d.dispose();

        File outputFile = new File(fileName);
        try {
            ImageIO.write(image, "png", outputFile);
            System.out.println("Imaginea tabloului de joc a fost exportată cu succes în fișierul " + fileName);
        } catch (IOException e) {
            System.err.println("Eroare la exportarea imaginii tabloului de joc: " + e.getMessage());
        }
    }

    private static class Stone {
        private int x;
        private int y;
        private Color color;

        public Stone(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Color getColor() {
            return color;
        }
    }
}
