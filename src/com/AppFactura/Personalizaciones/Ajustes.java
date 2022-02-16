/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Personalizaciones;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
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
private int filas,columnas;public static int filaExiste;
private TableRowSorter<DefaultTableModel> sorter ;
/**
 * Limpiar Jtable
 */
 public void clearTable(DefaultTableModel mdt){
 while(mdt.getRowCount()>0){
  mdt.removeRow(0);
 }    
 } 
 public void clearItemsCombo(DefaultComboBoxModel modelCombo)
 {
 modelCombo.removeAllElements();
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

/// método sirve para abrir el explorador de archivos (JFileChooser)
public String getExplorer(JFileChooser explorer,String titulo){
int ventanaExplorer;String ruta = null;
explorer.setDialogTitle(titulo);
explorer.setCurrentDirectory(new File(""));
ventanaExplorer = explorer.showOpenDialog(null);
if(ventanaExplorer==JFileChooser.APPROVE_OPTION){
ruta=explorer.getSelectedFile().getAbsolutePath();
}
return ruta;
}

/// foto defecto
public void DefectPreviewFoto(JLabel label,int tmA,int tmL){
label.setText("FOTO");label.setHorizontalAlignment((int)CENTER_ALIGNMENT);
label.setFont(new Font("Arial Black", tmA, tmL));label.setBackground(Color.white);
label.setOpaque(true);label.setToolTipText("Seleccione una Foto");
}

public Icon PreviewFoto(String ruta,int ancho,int alto){
ImageIcon imagen = new ImageIcon(ruta);
Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(ancho, alto,Image.SCALE_DEFAULT));
return icono;
}
/// Método para ocultar una columna expecifico de un Jtable
public void HiddenColumnTable(JTable tabla,int columna){
tabla.getColumnModel().getColumn(columna).setMaxWidth(0);
tabla.getColumnModel().getColumn(columna).setMinWidth(0);

tabla.getTableHeader().getColumnModel().getColumn(columna).setMaxWidth(0);
tabla.getTableHeader().getColumnModel().getColumn(columna).setMinWidth(0);
}
/**
 * verificar la existencia de un dato en Tabla
 * @return 
 */
public boolean existeDatoTable(JTable tabla, int pos,String dato){
boolean bandera = false;
for (int i = 0; i <tabla.getRowCount(); i++) {
if(tabla.getValueAt(i,pos).equals(dato)){
bandera=true;filaExiste = i; 
}
}
return bandera;
}
/**
 * SUMAR UNA COLUMNA DE JTABLE(IMPORTE)-->COLUMNA 4
 */
public String getSum(JTable tabla,int pos){
double total =0.00;
for (int i = 0; i <tabla.getRowCount(); i++) {
total+=Double.parseDouble(tabla.getValueAt(i, pos).toString());
}
return String.valueOf(total);
}
/**
 * Método para eliminar una fila de la tabla
 */
public void eliminarFilaTable(DefaultTableModel mdt, int filaSeleccionado){
mdt.removeRow(filaSeleccionado);
}












}
