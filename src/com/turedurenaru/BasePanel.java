package com.turedurenaru;

import java.awt.*;

import javax.swing.JPanel;

public class BasePanel extends JPanel{
    private MainFrame parentFrame;
    static public MainPanel mp;
    static public SubPanel sp;
    public BasePanel(MainFrame parentFrame){
        this.parentFrame = parentFrame;
        setLayout(new GridLayout(2,1));
        mp = new MainPanel();
        sp = new SubPanel(parentFrame);
        add(mp);
        add(sp);
    }

    public double getSum(){
        return mp.getSum();
    }

    public void allClear(){
        mp.allClear();
    }

    public void setTaxInclude(int price){
        mp.setTaxInclude(price);
    }
}
