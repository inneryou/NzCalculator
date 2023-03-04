package com.turedurenaru;

import java.awt.*;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.Size;
import com.jgoodies.forms.layout.*;

public class JStatusBar extends JPanel{
    private JPanel contentPanel;
    private JLabel resizeIconLabel;
    private JPanel rightPanel;
    private FormLayout layout;
    private int layoutCoordinateX = 1;
    private int layoutCoordinateY = 1;

    public JStatusBar(){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(getWidth(), 23));
        resizeIconLabel = new JLabel(new TriangleSquareWindowsCornerIcon());
        resizeIconLabel.setOpaque(false);
        rightPanel = new JPanel(new BorderLayout());

        rightPanel.setOpaque(false);
        rightPanel.add(resizeIconLabel, BorderLayout.SOUTH);
        add(rightPanel, BorderLayout.EAST);

        contentPanel = new JPanel();
        JLabel testLabel = new JLabel("これはテストです");
        contentPanel.add(testLabel);
        contentPanel.setOpaque(false);
        add(contentPanel, BorderLayout.WEST);

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

        // layout = new FormLayout("2dlu, pref:grow","3dlu, fill:10dlu, 2dlu");
        // contentPanel.setLayout(layout);
    }

    public void setMainLeftComponent(JComponent component){
        // contentPanel.add(component, new CellConstraints(2,2));
    }
    public void setRightComponent(JComponent component, int dialogUnits){
        // layout.appendColumn(new ColumnSpec("2dlu"));
        // layout.appendColumn(new ColumnSpec(dialogUnits + "dlu"));

        layoutCoordinateX++;
        // contentPanel.add(new SeparatorPanel(Color.GRAY, Color.WHITE),new CellConstraints(layoutCoordinateX, layoutCoordinateY));
        layoutCoordinateX++;
        // contentPanel.add(component, new CellConstraints(layoutCoordinateX, layoutCoordinateY));
    }
}
