/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Personalizaciones;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Adrian
 */
public class Ajustes {
private int filas,columnas;
private TableRowSorter<DefaultTableModel> sorter ;
/**
 * Limpiar Jtable
 */
 public void clearTable(DefaultTableModel mdt){
 while(mdt.getRowCount()>0){
  mdt.removeRow(0);
 }    
 } 
 
 /**
  * Método para validar la logitud de la cadna
  */
 public void lengthCadena(String cadena,int tm,KeyEvent e){
 if(cadena.trim().length()==tm){
 e.consume();
 }   
 }
 /**
  * Método para validar el ingreso de letras y digitos
  */
 public void isDigit_isLetter(boolean letra,KeyEvent e){
 if(letra){e.consume();}    
 }
 
public JButton BotonDinamico(JTable tabla,MouseEvent evento){
     JButton Boton=null;
     try {
       columnas=tabla.getColumnModel().getColumnIndexAtX(evento.getX());
       filas=evento.getY()/tabla.getRowHeight();
       if(columnas<=tabla.getColumnCount() && columnas>=0 && filas<=tabla.getRowCount() && filas>=0){
           Object objeto=tabla.getValueAt(filas, columnas);
           if(objeto instanceof JButton){
           ((JButton)objeto ).doClick();
            Boton=(JButton)objeto;
        }
       }    
     } catch (Exception e) {}
     return  Boton;
 }

public void BuscarSorterTable(DefaultTableModel mdt,JTable tabla,
JTextField txtBuscador){
tabla.setAutoCreateRowSorter(true);
sorter = new TableRowSorter<>(mdt);
tabla.setRowSorter(sorter);

txtBuscador.addKeyListener(new KeyAdapter() {
    @Override
    public void keyReleased(KeyEvent e) {
    sorter.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscador.getText()));
    }
});
}
         
}
