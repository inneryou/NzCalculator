package com.turedurenaru;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubPanel extends JPanel implements ActionListener{
    private JTextField resultField;
    private JTextField pointField;
    private JFrame parentFrame;
    private JButton buttonSum;
    private JButton buttonAllClear;
    private JButton btnOpenSubWindow;
    public SubPanel(JFrame parent){
        super();
        setLayout(new FlowLayout());
        this.parentFrame = parent;

        // アクションの設定
        MyFrameAction action = new MyFrameAction();
        action.setParentFrame(parentFrame);

        resultField = new JTextField(8);
        pointField = new JTextField(8);
        buttonSum = new JButton("合計");
        buttonSum.setActionCommand("Calc Sum");
        buttonSum.addActionListener(this);
        btnOpenSubWindow = new JButton("ペーストパネル");
        btnOpenSubWindow.setActionCommand("BUTTON_CLICKED");
        btnOpenSubWindow.addActionListener(action);
        buttonAllClear = new JButton("AllClear");
        buttonAllClear.setActionCommand("All Clear");
        buttonAllClear.addActionListener(this);

        add(resultField);
        add(pointField);
        add(buttonSum);
        add(buttonAllClear);
        add(btnOpenSubWindow);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj instanceof JButton){
            System.out.println("Button clicked");
        }
    }
}
