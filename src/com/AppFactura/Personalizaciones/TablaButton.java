/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Personalizaciones;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Adrian
 */
public class TablaButton extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
     if(value instanceof JButton){
      JButton boton=(JButton)value;  
      return boton;
     }
     
     if(value instanceof JLabel){
      JLabel labelImagen=(JLabel)value;  
      labelImagen.setHorizontalAlignment((int)CENTER_ALIGNMENT);
      return labelImagen;
     }
     return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }
    
}
