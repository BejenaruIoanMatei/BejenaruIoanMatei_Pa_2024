package org.example;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    private int rows, cols;
    private int canvasWidth = 400, canvasHeight = 400;
    private int boardWidth, boardHeight;
    private int cellWidth, cellHeight;
    private int padX, padY;
    private int stoneSize = 20;

    public DrawingPanel(MainFrame frame, int rows, int cols) {
        this.frame = frame;
        this.rows = rows;
        this.cols = cols;
        init();
    }

    public void reset()
    {

    }

    private void init() {
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(g);
    }

    private void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        // Draw horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }
        // Draw vertical lines
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            g.drawLine(x1, y1, x2, y2);
        }
        // Draw nodes (intersections)
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth - stoneSize / 2;
                int y = padY + row * cellHeight - stoneSize / 2;
                g.setColor(Color.LIGHT_GRAY);
                g.fillOval(x, y, stoneSize, stoneSize);
            }
        }
    }
}
