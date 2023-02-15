package com.turedurenaru;

import java.awt.*;
import java.awt.event.*;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class MyFrameAction extends AbstractAction {

    private JFrame parentFrame = null;

    public MyFrameAction(){
        super();
    }

    public void setParentFrame(JFrame parentFrame){
        this.parentFrame = parentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();

        // 実行されたコマンドをダンプします
        System.out.println( eventName );

        //　イベント発生源の情報をダンプする
        System.out.println();
        System.out.println( event.getSource() );

        //　イベント発生源のクラスを表示する
        System.out.println();
        Object source = event.getSource();
        System.out.println( source.getClass().getName() );

        // 親オブジェクトを辿っていく
        System.out.println();
        JComponent component = ( JComponent ) event.getSource();
        Container parent = component.getParent();
        int i = 0;
        while ( parent != null ) {
            System.out.println( ++i + ": " + parent );
            parent = parent.getParent();
        }

        if ( "BUTTON_CLICKED".equals( eventName ) ) {
            // System.exit( 0 );

            // 必ずサブウィンドウは１個しかオープンしないようにシングルトンにしておく
            // 親フレームの参照を引き渡す
            SubSingletonFrame subwin = SubSingletonFrame.getInstance( parentFrame );
        }
    }
}
