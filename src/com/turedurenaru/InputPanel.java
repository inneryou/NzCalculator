package com.turedurenaru;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class InputPanel extends JPanel implements MouseListener{
    private int rowMaxCount = 100;
    private ArrayList<InputRow> aryInputRow;
    public InputPanel(){
        setLayout(new GridLayout(rowMaxCount,1));
        // setBackground(Color.CYAN);
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

    public void allClear(){
        for(InputRow ir: aryInputRow){
            ir.clear();
        }
    }

    private void setInputRow(int id){
        InputRow ir = new InputRow(id);
        ir.addMouseListener(this);
        aryInputRow.add(ir);
    }

    public void setTaxInclude(int price){
        for(InputRow ir: aryInputRow){
            if(ir.getInputText() == ""){
                ir.setTextField(price);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        InputRow clickedPanel = (InputRow) e.getComponent();
        int colorIndex = clickedPanel.getColorIndex();
        clickedPanel.setColorIndex(colorIndex + 1);
        SubPanel.cpArea.setText("Clicked!");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }
}
