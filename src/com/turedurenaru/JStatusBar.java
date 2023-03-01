package com.turedurenaru;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JStatusBar extends JPanel{
    private JPanel contentPanel;
    public JStatusBar(){
        setPreferredSize(new Dimension(getWidth(), 23));
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int y = 0;
        g.setColor(new Color(156,154,140));
        g.drawLine(0,y,getWidth(),y);
        y++;
        g.setColor(new Color(196,194,183));
        g.drawLine(0,y,getWidth(),y);
        y++;
        g.setColor(new Color(218,215,201));
        g.drawLine(0,y,getWidth(),y);
        y++;
        g.setColor(new Color(233,231,217));
        g.drawLine(0,y,getWidth(),y);
        
        y = getHeight() - 3;
        g.setColor(new Color(233,232,218));
        g.drawLine(0,y,getWidth(),y);
        y++;
        g.setColor(new Color(233,231,216));
        g.drawLine(0,y,getWidth(),y);
        y = getHeight() - 1;
        g.setColor(new Color(221,221,220));
        g.drawLine(0,y,getWidth(),y);

        JLabel resizeIconLabel = new JLabel(new TriangleSquareWindowsCornerIcon());
        resizeIconLabel.setOpaque(false);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setOpaque(false);
        rightPanel.add(resizeIconLabel, BorderLayout.SOUTH);
        add(rightPanel, BorderLayout.EAST);

        contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        add(contentPanel, BorderLayout.CENTER);
    }
}
