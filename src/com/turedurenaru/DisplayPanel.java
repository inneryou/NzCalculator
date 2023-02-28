package com.turedurenaru;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DisplayPanel extends JPanel{
    private JLabel labelDisplay;
    public DisplayPanel(){
        labelDisplay = new JLabel();
        labelDisplay.setFont(new Font("Arial",Font.PLAIN,14));
        setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(labelDisplay);
        add(scroll, BorderLayout.CENTER);
    }

    public void setMessage(String message){
        labelDisplay.setText(message);
    }
}
