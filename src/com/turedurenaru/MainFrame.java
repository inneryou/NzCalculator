package com.turedurenaru;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
    public static BasePanel basePanel;
    public MainFrame(String title){
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("icon.png"));
        this.setIconImage(icon.getImage());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(title);
        basePanel = new BasePanel(this);
        BottomPanel bp = new BottomPanel();
        this.getContentPane().add(basePanel,BorderLayout.CENTER);
        this.getContentPane().add(bp,BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }
    public void setTaxInclude(int price){
        basePanel.setTaxInclude(price);
    }
}
