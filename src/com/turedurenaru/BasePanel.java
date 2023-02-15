package com.turedurenaru;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BasePanel extends JPanel{
    private JFrame parentFrame;
    private MainPanel mp;
    public BasePanel(JFrame parentFrame){
        this.parentFrame = parentFrame;
        setLayout(new GridLayout(2,1));
        mp = new MainPanel();
        SubPanel sp = new SubPanel(this.parentFrame);
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
