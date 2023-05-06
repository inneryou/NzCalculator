package com.turedurenaru;

import javax.swing.JComboBox;

public class GroupCombobox extends JComboBox<String>{
  String[] aryData = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N"};

  public GroupCombobox(int max){
    if(max > aryData.length){
      max = aryData.length;
    }
    this.setItems(max);
  }
  private void setItems(int max){
    for(int i = 0; i < max; i++){
      this.addItem(aryData[i]);
    }
  }
}
