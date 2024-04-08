package org.example;

import org.example.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;

public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private final JButton saveBtn;
    private final JButton loadBtn;
    private final JButton exitBtn;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        this.saveBtn = new JButton("Save");
        this.loadBtn = new JButton("Load");
        this.exitBtn = new JButton("Exit");

        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 3));
        add(loadBtn);
        add(saveBtn);
        add(exitBtn);

        loadBtn.addActionListener(this::load);
        exitBtn.addActionListener(this::exit);
    }

    private void load(ActionEvent e) {
        try {
            URL url = new URL("");
            // Use the URL to load image
            // BufferedImage img = ImageIO.read(url);
            // frame.getCanvas().reset();
            // frame.getCanvas().setImage(img);
            // frame.repaint();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void exit(ActionEvent e) {
        frame.dispose();
    }
}
