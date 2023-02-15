package com.turedurenaru;

import java.awt.*;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainPanel extends JPanel{
    private InputPanel ip;
    public MainPanel(){
        JScrollPane scrollPane = new JScrollPane();
        setLayout(new GridLayout(1,1));
        ip = new InputPanel();
        scrollPane.setViewportView(ip);
        add(scrollPane);
    }

    public double getSum(){
        double result = 0.0;
        result = ip.getSum();
        return result;
    }

    public void allClear(){
        ip.allClear();
    }

    public void setTaxInclude(int price){
        ip.setTaxInclude(price);
    }
}
