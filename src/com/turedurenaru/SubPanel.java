package com.turedurenaru;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
    private JButton btnDownload;
    private JTextArea cpArea;
    private JButton btnUrl;
    private JScrollPane scroll;
    private JPanel panel;

    public SubPanel(MainFrame parent){
        super();
        GridBagLayout gblayout = new GridBagLayout();
        setLayout(gblayout);
        this.parent = parent;
        cpArea = new JTextArea(10,20);
        cpArea.setBorder(new LineBorder(Color.GRAY));
        cpArea.setLineWrap(true);
        panel = new JPanel();
        panel.setLayout(new GridLayout(7,1));

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
        btnUrl = new JButton("URL");
        btnUrl.setActionCommand("Open url");
        btnUrl.addActionListener(this);
        btnDownload = new JButton("Download");
        btnDownload.addActionListener(new DriverDownload(parent));
        scroll = new JScrollPane();
        scroll.setViewportView(cpArea);

        
        panel.add(resultField);
        panel.add(pointField);
        panel.add(buttonSum);
        panel.add(buttonAllClear);
        panel.add(btnOpenSubWindow);
        panel.add(btnUrl);
        panel.add(btnDownload);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(1,1,1,1);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gblayout.setConstraints(scroll, gbc);
        add(scroll);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0 ;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(1,1,1,1);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gblayout.setConstraints(panel, gbc);
        add(panel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
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
        if(cmd == "Open url"){
            InputStreamReader isr = null;
            try {
                URL url = new URL("http://innerfashion.sakura.ne.jp/");
                InputStream is = url.openStream();
                isr = new InputStreamReader(is);
                int data = is.read();
                while(data != -1){
                    cpArea.append(String.valueOf((char)data));
                    data = is.read();
                }
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            }catch(IOException ie){
                ie.printStackTrace();
            }finally{
                try {
                    isr.close();
                } catch (IOException e1) {}
            }
        }
    }
}
