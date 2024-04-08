package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    protected ConfigPanel configPanel;
    private ControlPanel controlPanel;
    private DrawingPanel canvas;
    private Game game; // Adăugăm instanța clasei Game

    public MainFrame() {
        super("Positional Game");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creăm o instanță a jocului cu o anumită dimensiune a tablei
        game = new Game(5, 5);
        game.initialize(); // Inițializăm jocul

        canvas = new DrawingPanel(5, 5);
        controlPanel = new ControlPanel(this);
        configPanel = new ConfigPanel(this);

        // Adăugăm un MouseListener pentru a permite plasarea pietrelor pe tablă
        canvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int col = evt.getX() / canvas.getCellWidth();
                int row = evt.getY() / canvas.getCellHeight();
                game.makeMove(row, col); // Facem mutarea în joc
                canvas.repaint(); // Repictăm tabla după mutare
            }
        });

        // Adăugăm canvas-ul pe panel-ul central
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(canvas);

        add(centerPanel, BorderLayout.CENTER);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Centrăm fereastra pe ecran
    }

    public Game getGame() {
        return game;
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }
}
