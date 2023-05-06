package com.turedurenaru;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class PasetPanel extends JPanel{
  JTabbedPane tabbedPane = new JTabbedPane();
  public static List<JTextArea> taList = new ArrayList<JTextArea>();
  public PasetPanel(){
    taList.clear();
    createArryList();
    createTabbedPanels();
    tabbedPane.setPreferredSize(new Dimension(400,400));
    this.add(tabbedPane);
    // this.setPreferredSize(new Dimension(400, 400));
  }

  private void createArryList(){
    for(int i = 0; i < 10; i++){
      JTextArea jta = new JTextArea();
      taList.add(jta);
    }
  }

  private void createTabbedPanels(){
    for(int i = 0;i < taList.size(); i++){
      tabbedPane.addTab(String.valueOf(i + 1),taList.get(i));
    }
  }

  public String getValue(){
    String result;
    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < taList.size(); i++ ){
      sb.append(taList.get(i).getText().toString());
    }
    result = sb.toString();
    return result;
  }
}