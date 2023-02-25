package com.turedurenaru;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class MyDialog extends JDialog implements ActionListener{
    private String str;
    MyDialogType type;
    public MyDialog(String str,MyDialogType type){
        this.str = str;
        this.type = type;
        if(this.type == MyDialogType.OK_ONLY){
            createDialogOkOnly(str);
        }
    }

    private void createDialogOkOnly(String str){
        GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        DisplayMode displayMode = genv.getDefaultScreenDevice().getDisplayMode();
        int dWidth = displayMode.getWidth();
        int dHeight = displayMode.getHeight();
        this.setLayout(new FlowLayout());
        JButton btnOK = new JButton("OK");
        btnOK.setActionCommand("Close");
        btnOK.addActionListener(this);
        JLabel label = new JLabel(str);
        this.getContentPane().add(label);
        this.getContentPane().add(btnOK);
        this.pack();
        this.setVisible(true);
        this.setTitle("MyDialog");
        this.setBounds(dWidth / 2-(this.getWidth() / 2),dHeight / 2 - (this.getHeight() / 2), 200, 100);
        this.setPreferredSize(new Dimension(200,200));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd == "Close"){
            this.setVisible(false);
        }
    }
    
}
