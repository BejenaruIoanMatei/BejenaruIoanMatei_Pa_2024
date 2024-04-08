package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    protected ConfigPanel configPanel;
    private ControlPanel controlPanel;
    private DrawingPanel canvas;
    private Game game;

    public MainFrame() {
        super("Positional Game");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        game = new Game(5, 5);
        game.initialize();

        canvas = new DrawingPanel(5, 5);
        controlPanel = new ControlPanel(this);
        configPanel = new ConfigPanel(this);

        canvas.addMouseListener(new java.awt.event.MouseAdapter() {//Asta e pentru plasarea pietrelor
                                                                    // pe tabela
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int col = evt.getX() / canvas.getCellWidth();
                int row = evt.getY() / canvas.getCellHeight();
                game.makeMove(row, col); // Facem mutarea in joc
                canvas.repaint(); // Refacem tabela dupa fieacare mutare
            }
        });

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(canvas);

        add(centerPanel, BorderLayout.CENTER);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
        //Asta i pentru a centra fereastra pe ecran
        setLocationRelativeTo(null);
    }

    public Game getGame() {
        return game;
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }
}
