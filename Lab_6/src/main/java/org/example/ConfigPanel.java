package org.example;

import javax.swing.*;

public class ConfigPanel<MainFrame> extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;
    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        JLabel sidesLabel = new JLabel("Grid size:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(10);
        sidesField.setValue(10);
        String values[]={"Red","Blue"};
        colorCombo= new JComboBox(values);

        //TODO
        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }

    protected int getSidesValue(){
        return (Integer)sidesField.getValue();
    }


}