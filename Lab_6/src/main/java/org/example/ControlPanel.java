package org.example;

import org.example.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
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

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        exitBtn.addActionListener(this::exit);
    }

    private void load(ActionEvent e) {
        try {
            URL url = new URL("");
            //Aici vine partea de load a unei imagini in tabla de joc
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void save(ActionEvent e) {

        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getAbsolutePath();
            //Pentru a salva imaginea
            frame.getCanvas().exportGameBoardImage(fileName);
        }
    }

    private void exit(ActionEvent e) {
        frame.dispose();
    }
}
