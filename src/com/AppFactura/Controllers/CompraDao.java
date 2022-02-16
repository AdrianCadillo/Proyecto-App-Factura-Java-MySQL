/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Controllers;

import com.AppFactura.Modells.Entidades.DetalleCompra_E;
import com.AppFactura.Modells.Entidades.Productos_E;
import com.AppFactura.Modells.Entidades.Proveedor_E;
import com.AppFactura.Modells.Logica.L_Compras;
import com.AppFactura.Personalizaciones.Ajustes;
import com.AppFactura.Personalizaciones.TablaButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adrian
 */
public class CompraDao {
Ajustes confis = new Ajustes();   
L_Compras cm= new L_Compras();
DetalleCompra_E dc = new DetalleCompra_E();
Proveedor_E prov = new Proveedor_E();
Productos_E prod = new Productos_E(); 
public void addDetalleCompra(DefaultTableModel mdt,JTable tabla,int ID,String descripcion,int cantidad,
double precioCompra,JButton botonQuitar,JLabel labelGasto){
int nuevaCantidad=0;double newImporte=0.00;
tabla.setDefaultRenderer(Object.class, new TablaButton());
double Importe = precioCompra*cantidad;
if(!confis.existeDatoTable(tabla, 1, descripcion)){
Object datosCompra[]={ID,descripcion,cantidad,precioCompra,Importe,botonQuitar};
mdt.addRow(datosCompra);    
}else{
 int cantidadCelda = Integer.parseInt(tabla.getValueAt(confis.filaExiste, 2).toString());
 nuevaCantidad=cantidadCelda+cantidad;
 newImporte = nuevaCantidad*precioCompra;
 tabla.setValueAt(nuevaCantidad,confis.filaExiste,2);
 tabla.setValueAt(newImporte,confis.filaExiste,4);
}
labelGasto.setText(confis.getSum(tabla, 4)+"0");
}    
public void saveCompras(String documento,String serie,String usuario){
prov.setDocumento(documento);
dc.setProveedor(prov);
dc.setSerieCompra(serie);dc.setNameUser(usuario);
cm.addCompra(dc);
JOptionPane.showMessageDialog(null,"La compra se a registrado sin problemas","SuccessFull (:",
JOptionPane.INFORMATION_MESSAGE);
}

public void saveDetalleCompra(String documento,String serieCompra,String usuario,JTable tabla){
saveCompras(documento, serieCompra, usuario);
int ID;int ct;double precioC;double importeC;
for (int i = 0; i <tabla.getRowCount(); i++) {
ID=Integer.parseInt(tabla.getValueAt(i,0).toString());
ct=Integer.parseInt(tabla.getValueAt(i,2).toString());
precioC = Double.parseDouble(tabla.getValueAt(i, 3).toString());
importeC = Double.parseDouble(tabla.getValueAt(i, 4).toString());
prod.setIdProducto(ID);
dc.setSerieCompra(serieCompra);
dc.setCatalogo(prod);dc.setCantidadCompra(ct);
dc.setPrecioCompra(precioC);dc.setImporteCompra(importeC); 
cm.addDetalleCompra(dc);
}
 
}

    
}
