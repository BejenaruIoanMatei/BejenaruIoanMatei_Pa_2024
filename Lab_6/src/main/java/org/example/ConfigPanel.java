package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ConfigPanel extends JPanel {
    private final MainFrame frame;
    private final JLabel rowsLabel;
    private final JSpinner rowsSpinner;
    private final JLabel colsLabel;
    private final JSpinner colsSpinner;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        this.rowsLabel = new JLabel("Rows:");
        this.rowsSpinner = new JSpinner(new SpinnerNumberModel(5, 1, 100, 1));
        this.colsLabel = new JLabel("Cols:");
        this.colsSpinner = new JSpinner(new SpinnerNumberModel(5, 1, 100, 1));

        init();
    }

    private void init() {
        add(rowsLabel);
        add(rowsSpinner);
        add(colsLabel);
        add(colsSpinner);

        // Pentru a detecta schimbarile si pt a actualiza Drawing Panel ul
        rowsSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int rows = (int) rowsSpinner.getValue();
                int cols = (int) colsSpinner.getValue();
                frame.getCanvas().setGridSize(rows, cols);
            }
        });

        colsSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int rows = (int) rowsSpinner.getValue();
                int cols = (int) colsSpinner.getValue();
                frame.getCanvas().setGridSize(rows, cols);
            }
        });
    }
}
