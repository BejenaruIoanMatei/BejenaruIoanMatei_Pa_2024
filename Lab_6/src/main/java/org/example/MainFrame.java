package org.example;

import javax.swing.*;

import java.awt.*;

import static java.awt.BorderLayout.CENTER;

public class MainFrame extends JFrame {
    protected ConfigPanel configPanel;
    private ControlPanel controlPanel;
    private DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }

    private void init()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new DrawingPanel(this,10,10);
        controlPanel = new ControlPanel(this);
        configPanel = new ConfigPanel(this);

        add(canvas, BorderLayout.CENTER);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel,BorderLayout.SOUTH);

        pack();
    }
}