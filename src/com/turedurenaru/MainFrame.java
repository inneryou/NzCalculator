package com.turedurenaru;

import java.awt.*;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
    BasePanel basePanel;
    public MainFrame(String title){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(title);
        basePanel = new BasePanel();
        BottomPanel bp = new BottomPanel();
        this.getContentPane().add(basePanel,BorderLayout.CENTER);
        this.getContentPane().add(bp,BorderLayout.SOUTH);
        this.setVisible(true);
    }
}
