package com.turedurenaru;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SubSingletonFrame extends JFrame implements ActionListener{
    private static SubSingletonFrame uniqueInstance = null;
    private JTextArea pastArea;
    private JButton btnAnalysis;
    private MainFrame parentFrame;
    private PasetPanel pp = new PasetPanel();

    private SubSingletonFrame(MainFrame parentFrame) {
        super();
        this.parentFrame = parentFrame;
        pastArea = new JTextArea();
        getContentPane().add(pp,BorderLayout.CENTER);
        btnAnalysis = new JButton("解析");
        btnAnalysis.setActionCommand("Analysis");
        ArticleAnalysis action = new ArticleAnalysis(this.parentFrame,pastArea);
        btnAnalysis.addActionListener(action);
        getContentPane().add(btnAnalysis,BorderLayout.SOUTH);
    }

    public static SubSingletonFrame getInstance(MainFrame parentFrame) {

        if ( uniqueInstance == null ) {
            uniqueInstance = new SubSingletonFrame(parentFrame);

            /** 親フレームのタイトルをそのまま表示 */
            uniqueInstance.setTitle(parentFrame.getTitle());

            /** サイズと位置を指定 */
            uniqueInstance.setBounds(300, 200, 300, 200);
            uniqueInstance.pack();
            uniqueInstance.setVisible(true);

            uniqueInstance.addWindowListener(new WindowAdapter(){
                                                  public void windowClosing( WindowEvent e ) {
                                                      // インスタンスも消滅させる
                                                      uniqueInstance = null;
                                                  }
                                              }
                                            );
        } else {
            System.err.println( "既にサブウィンドウがオープンしています！" );
        }

        return uniqueInstance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action");
        if(e.getActionCommand() == "Analysis"){
            System.out.println("Analysis button clicked");
            SubPanel.cpArea.setText(pp.getValue());
        }
    }
}
