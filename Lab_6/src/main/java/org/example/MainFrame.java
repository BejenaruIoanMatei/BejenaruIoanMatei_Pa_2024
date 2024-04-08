package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    protected ConfigPanel configPanel;
    private ControlPanel controlPanel;
    private DrawingPanel canvas;

    public MainFrame() {
        super("Positional Game");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        canvas = new DrawingPanel(5, 5);
        controlPanel = new ControlPanel(this);
        configPanel = new ConfigPanel(this);

        // Creăm un JPanel pentru a centra DrawingPanel
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(canvas);

        add(centerPanel, BorderLayout.CENTER);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Centrăm fereastra pe ecran
    }


    public DrawingPanel getCanvas() {
        return canvas;
    }
}
