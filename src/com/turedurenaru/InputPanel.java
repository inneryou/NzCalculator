package com.turedurenaru;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;

public class InputPanel extends JPanel{
    private int rowMaxCount = 100;
    private ArrayList<InputRow> aryInputRow;
    public InputPanel(){
        setLayout(new GridLayout(rowMaxCount,1));
        setBackground(Color.CYAN);
        aryInputRow = new ArrayList<>();
        for(int i=0;i<rowMaxCount;i++){
            setInputRow(i);
        }
        for(int i=0;i<rowMaxCount;i++){
            this.add(aryInputRow.get(i));
        }
    }

    public double getSum(){
        double result = 0.0;
        for(InputRow ir: aryInputRow){
            try{
                if(!ir.getInputText().equals("")){
                    result += Double.parseDouble(ir.getInputText());
                }
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
        }
        return result;
    }

    private void setInputRow(int id){
        InputRow ir = new InputRow(id);
        aryInputRow.add(ir);
    }
}
