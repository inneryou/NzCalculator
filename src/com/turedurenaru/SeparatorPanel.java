package com.turedurenaru;

import java.awt.*;

import javax.swing.JPanel;

public class SeparatorPanel extends JPanel{
    private Color leftColor;
    private Color rightColor;

    public SeparatorPanel(Color left, Color right){
        this.leftColor = left;
        this.rightColor = right;
        setOpaque(false);
    }

    protected void paintComponent(Graphics g){
        g.setColor(leftColor);
        g.drawLine(0,0, 0,getHeight());
        g.setColor(rightColor);
        g.drawLine(1,0,1,getHeight());
    }
}
