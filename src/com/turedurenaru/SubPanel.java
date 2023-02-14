package com.turedurenaru;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubPanel extends JPanel implements ActionListener{
    private JTextField resultField;
    private JTextField pointField;
    private BasePanel parent;
    private JButton buttonSum;
    private JButton buttonAllClear;
    public SubPanel(BasePanel parent){
        setLayout(new FlowLayout());
        this.parent = parent;
        resultField = new JTextField(8);
        pointField = new JTextField(8);
        buttonSum = new JButton("合計");
        buttonSum.setActionCommand("Calc Sum");
        buttonSum.addActionListener(this);
        buttonAllClear = new JButton("AllClear");
        buttonAllClear.setActionCommand("All Clear");
        buttonAllClear.addActionListener(this);
        add(resultField);
        add(pointField);
        add(buttonSum);
        add(buttonAllClear);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj instanceof JButton){
            if(((JButton)obj).getActionCommand() == "Calc Sum"){
                resultField.setText(String.format("%f",parent.getSum()));
                pointField.setText(String.format("%f",Double.parseDouble(resultField.getText())/100));
            }
            if(((JButton)obj).getActionCommand() == "All Clear"){
                parent.allClear();
                resultField.setText("");
            }
        }
    }
}
