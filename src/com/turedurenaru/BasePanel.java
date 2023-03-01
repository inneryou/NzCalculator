package com.turedurenaru;

import java.awt.*;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class BasePanel extends JPanel{
    private MainFrame parentFrame;
    private MainPanel mp;
    private JTabbedPane tabbedPane;
    private DisplayPanel dp;
    public BasePanel(MainFrame parentFrame){
        tabbedPane = new JTabbedPane();
        this.parentFrame = parentFrame;
        setLayout(new GridLayout(2,1));
        mp = new MainPanel();
        SubPanel sp = new SubPanel(parentFrame);
        tabbedPane.add(mp);
        tabbedPane.setTitleAt(0,"メイン");
        tabbedPane.add(sp);
        tabbedPane.setTitleAt(1,"サブ");
        dp = new DisplayPanel();
        tabbedPane.addTab("ディスプレイ",dp);
        add(tabbedPane);
        setDisplayMessage();
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

    private void setDisplayMessage(){
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>");
        sb.append("<p><font size=\"14\">テスト</font></p>");
        sb.append("<p><font color=\"red\">今日のテスト</font></p>");
        sb.append("<h1>H1</h1>");
        sb.append("<h2>H2</h2>");
        sb.append("<h3>H3</h3>");
        sb.append("<p><b>太文字</b></p>");
        sb.append("<p><i>イタリック文字</i></p>");
        sb.append("<p><font color=\"rgb(255,100,50)\">FONT COLOR</font></p>");
        sb.append("<p>洗濯機がエラーE22<br />内蓋、洗剤投入口のエラーらしい</p>");
        sb.append("<p><a href=\"https://google.co.jp\">Google</a></p>");
        
        sb.append("</body></html>");
        dp.setMessage(sb.toString());
    }
}
