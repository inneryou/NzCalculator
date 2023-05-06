package com.turedurenaru;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DriverDownload implements ActionListener{
    private MainFrame parent;
    private static JDialog dialog;
    private JButton btnOK;
    private JLabel label;
    private String downloadUrl;
    public DriverDownload(MainFrame parent){
        this.parent = parent;
        String chromeDriverUrl = "https://chromedriver.storage.googleapis.com/LATEST_RELEASE";
        String chromeDriverVersion = "";
        try {
            URL url = new URL(chromeDriverUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            chromeDriverVersion = reader.readLine();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        downloadUrl = "https://chromedriver.storage.googleapis.com/" + chromeDriverVersion + "/chromedriver_win32.zip";
        
        dialog = new JDialog();
        dialog.setLayout(new FlowLayout());
        btnOK = new JButton("OK");
        btnOK.setActionCommand("Download complete");
        btnOK.addActionListener(this);
        label = new JLabel("ダウンロードが完了しました。");
        dialog.getContentPane().add(label);
        dialog.getContentPane().add(btnOK);
        dialog.pack();
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
        if(e.getActionCommand() == "Download complete"){
            dialog.dispose();
        }else{
            try {
                URL url = new URL(downloadUrl);
                if(downloadFile(url, fileName, this.parent)){
                    dialog.setTitle("ダウンロード");
                    dialog.setPreferredSize(new Dimension(200,200));
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

                    // ダイアログのサイズを取得する
                    Dimension dialogSize = dialog.getSize();
            
                    // ダイアログを中央に配置する
                    int x = (int) (screenSize.getWidth() - dialogSize.getWidth()) / 2;
                    int y = (int) (screenSize.getHeight() - dialogSize.getHeight()) / 2;
                    dialog.setLocation(x, y);
                    dialog.setVisible(true);
                }
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
