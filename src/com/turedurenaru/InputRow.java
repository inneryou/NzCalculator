package com.turedurenaru;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class InputRow extends JPanel implements ActionListener{
    private JTextField textField;
    private JTextField textWithoutTax;
    private int id;
    public InputRow(int id){
        this.id = id;
        setLayout(new FlowLayout());
        setBorder(new LineBorder(Color.GRAY, 1, true));
        textField = new JTextField(8);
        textField.addActionListener(this);
        textWithoutTax = new JTextField(8);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        JLabel labelId = new JLabel(String.valueOf(id+1));
        JLabel label = new JLabel("税込");
        textWithoutTax.setHorizontalAlignment(JTextField.RIGHT);
        JLabel label2 = new JLabel("税抜");
        add(labelId);
        add(label);
        add(textField);
        add(label2);
        add(textWithoutTax);
    }

    public int getId(){
        return this.id;
    }

    public void clear(){
        textField.setText("");
        textWithoutTax.setText("");
    }

    public String getInputText(){
        return textField.getText();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("TEST");
        Object obj = e.getSource();
        if(obj instanceof JTextField){
            textWithoutTax.setText(String.format("%f" ,Double.parseDouble(((JTextField)obj).getText())/1.1));
        }
    }
}
