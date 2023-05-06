package com.turedurenaru;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class InputRow extends JPanel{
    private JTextField textField;
    private JTextField textWithoutTax;
    private int id;
    private int colorIndex = 0;
    private List<Color> colorList = new ArrayList<Color>();
    private GroupCombobox gcb;
    public InputRow(int id){
        this.id = id;
        setColorList();
        setColorIndex(0);
        setLayout(new FlowLayout());
        // setBorder(new LineBorder(Color.BLUE, 1, true));
        textField = new JTextField(8);
        textWithoutTax = new JTextField(8);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        JLabel labelId = new JLabel(String.valueOf(id+1));
        JLabel label = new JLabel("税込");
        textWithoutTax.setHorizontalAlignment(JTextField.RIGHT);
        JLabel label2 = new JLabel("税抜");
        gcb = new GroupCombobox(colorList.size());
        add(labelId);
        add(label);
        add(textField);
        add(label2);
        add(textWithoutTax);
        add(gcb);
        gcb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                switch(e.getStateChange()){
                    case ItemEvent.SELECTED:
                    int index = gcb.getSelectedIndex();
                    setColorIndex(index);
                    break;
                }
            }
        });
    }

    public int getId(){
        return this.id;
    }

    private void setColorList(){
        colorList.add(Color.LIGHT_GRAY);
        colorList.add(Color.GRAY);
        colorList.add(Color.RED);
        colorList.add(Color.GREEN);
        colorList.add(Color.ORANGE);
        colorList.add(Color.YELLOW);
        colorList.add(Color.CYAN);
        colorList.add(Color.PINK);
    }

    public void clear(){
        textField.setText("");
        textWithoutTax.setText("");
    }

    public String getInputText(){
        return textField.getText();
    }

    public void setTextField(int price){
        textField.setText(String.valueOf(price));
    }

    public void setColorIndex(int num){
        if(num >= colorList.size()){
            this.colorIndex = 0;
        }
        if(num < colorList.size()){
            this.colorIndex = num;
        }
        setBackground(this.colorIndex);
        try{
            gcb.setSelectedIndex(this.colorIndex);
        }catch(NullPointerException ne){
            ne.printStackTrace();
        }
    }
    private void setBackground(int num){
        super.setBackground((Color)colorList.get(num));
    }
    public int getColorIndex(){
        return this.colorIndex;
    }
}
