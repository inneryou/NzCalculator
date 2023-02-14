package com.turedurenaru;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubPanel extends JPanel implements ActionListener{
    private JTextField resultField;
    private BasePanel parent;
    public SubPanel(BasePanel parent){
        setLayout(new FlowLayout());
        this.parent = parent;
        resultField = new JTextField(8);
        JButton buttonSum = new JButton("合計");
        buttonSum.setActionCommand("Calc Sum");
        buttonSum.addActionListener(this);
        add(resultField);
        add(buttonSum);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        resultField.setText(String.format("%f",parent.getSum()));
    }
}
