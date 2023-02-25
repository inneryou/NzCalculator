package com.turedurenaru;

import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class DriverDownload implements ActionListener{
    private MainFrame parent;
    public DriverDownload(MainFrame parent){
        this.parent = parent;
    }

    private boolean downloadFile(URL url,String outputFileName,MainFrame parent){
        System.out.println("download started...");
        try {
            InputStream is = url.openStream();
            ReadableByteChannel rbc = Channels.newChannel(is);
            FileOutputStream fos = new FileOutputStream(outputFileName);
            fos.getChannel().transferFrom(rbc,0,Long.MAX_VALUE);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fileName = "chromedriver.zip";
        try {
            URL url = new URL("https://chromedriver.storage.googleapis.com/111.0.5563.19/chromedriver_linux64.zip");
            if(downloadFile(url, fileName, this.parent)){
                System.out.println("Show dialog...");
                JDialog dialog = new JDialog();
                dialog.setLayout(new FlowLayout());
                JButton btnOK = new JButton("OK");
                JLabel label = new JLabel("ダウンロードが完了しました。");
                dialog.getContentPane().add(label);
                dialog.getContentPane().add(btnOK);
                dialog.pack();
                dialog.setVisible(true);
                dialog.setTitle("ダウンロード");
                dialog.setPreferredSize(new Dimension(200,200));
            }
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
    }
}
