package com.turedurenaru;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main{
    static Logger logger;
    public static void main(String[] args){
        logger = Logger.getLogger("Sample");
        try {
            FileHandler fhandler = new FileHandler("sample.log",true);
            fhandler.setFormatter(new SimpleFormatter());
            fhandler.setLevel(Level.INFO);
            logger.addHandler(fhandler);
            // Loggerクラスのメソッドを使ってメッセージを出力
            // logger.finest("FINEST");
            // logger.finer("FINER");
            // logger.fine("FINE");
            // logger.config("CONFIG");
            logger.info(System.getProperty("user.name") + " Program started...");
            // logger.warning("WARNING");
            // logger.severe("SEVERE");
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        MainFrame mainFrame = new MainFrame("NzCalculator");
        mainFrame.setBounds(100,100,400,600);
        Thread hook = new Thread(){
            public void run(){
                Main.logger.info(System.getProperty("user.name") + " closed...");
            }
        };
        Runtime.getRuntime().addShutdownHook(hook);
    }
}