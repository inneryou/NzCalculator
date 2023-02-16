package com.turedurenaru;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;

public class SubPanel extends JPanel implements ActionListener{
    private JTextField resultField;
    private JTextField pointField;
    private MainFrame parent;
    private JButton buttonSum;
    private JButton buttonAllClear;
    private JButton btnOpenSubWindow;
    private JTextArea cpArea;

    public SubPanel(MainFrame parent){
        super();
        setLayout(new FlowLayout());
        this.parent = parent;
        cpArea = new JTextArea(10,20);
        cpArea.setBorder(new LineBorder(Color.GRAY));

        // // アクションの設定
        // MyFrameAction action = new MyFrameAction();
        // action.setParentFrame(parentFrame);

        resultField = new JTextField(8);
        pointField = new JTextField(8);
        buttonSum = new JButton("合計");
        buttonSum.setActionCommand("Calc Sum");
        buttonSum.addActionListener(this);
        btnOpenSubWindow = new JButton("ペーストパネル");
        btnOpenSubWindow.setActionCommand("BUTTON_CLICKED");
        btnOpenSubWindow.addActionListener(this);
        buttonAllClear = new JButton("AllClear");
        buttonAllClear.setActionCommand("All Clear");
        buttonAllClear.addActionListener(this);

        add(resultField);
        add(pointField);
        add(buttonSum);
        add(buttonAllClear);
        add(btnOpenSubWindow);
        add(cpArea);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        String cmd = e.getActionCommand();
        if(cmd == "BUTTON_CLICKED"){
            SubSingletonFrame.getInstance(parent);
            String[] aryStr = cpArea.getText().split("\n");
            for(int i=0;i<aryStr.length;i++){
                if(aryStr[i].indexOf("税込")>-1){
                    System.out.println("TSDT");
                    
                }
            }
        }
    }
}
