package com.turedurenaru;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomPanel extends JPanel implements ActionListener{
    JButton buttonClose;
    public BottomPanel(){
        setLayout(new FlowLayout());
        buttonClose = new JButton("終了");
        buttonClose.setActionCommand("Close application");
        buttonClose.addActionListener(this);
        add(buttonClose);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj instanceof JButton){
            if(((JButton)obj).getActionCommand() == "Close application"){
                System.out.println("Close");
                System.exit(0);
            }
        }
    }
}
