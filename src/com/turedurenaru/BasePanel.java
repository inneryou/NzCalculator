package com.turedurenaru;

import java.awt.*;
import javax.swing.JPanel;

public class BasePanel extends JPanel{
    private MainPanel mp;
    public BasePanel(){
        setLayout(new GridLayout(2,1));
        mp = new MainPanel();
        SubPanel sp = new SubPanel(this);
        add(mp);
        add(sp);
    }

    public double getSum(){
        return mp.getSum();
    }
}
