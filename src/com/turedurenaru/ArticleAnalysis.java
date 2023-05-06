package com.turedurenaru;

import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextArea;

public class ArticleAnalysis implements ActionListener{
    private JTextArea ta;
    private MainFrame parentFrame;
    public ArticleAnalysis(MainFrame parentFrame,JTextArea textArea){
        ta = textArea;
        this.parentFrame = parentFrame;
    }

    public void setTaxInclude(int price){
        this.parentFrame.setTaxInclude(price);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "Analysis"){
            System.out.println("Analysis button clicked!");
            String[] aryStr = ta.getText().split("\n");
            for(int i=0;i<aryStr.length;i++){
                if(aryStr[i].indexOf("税込価格")>-1){
                    Matcher m = Pattern.compile("[0-9]+").matcher(aryStr[i]);
                    while (m.find()) {
                        String s = m.group();
                        this.setTaxInclude(Integer.parseInt(s));
                    }
                }
            }
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < PasetPanel.taList.size(); i++){
                sb.append(PasetPanel.taList.get(i).getText().toString());
                sb.append("\n");
            }
            String str = sb.toString();
            SubPanel.cpArea.setText(str);
        }
    }
    
}
