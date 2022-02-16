/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Controllers;

import com.AppFactura.Modells.Entidades.Clientes_E;
import com.AppFactura.Modells.Logica.L_Clientes;
import com.AppFactura.Personalizaciones.Ajustes;
import com.AppFactura.Personalizaciones.TablaButton;
import com.AppFactura.Vistas.Clientes.FR_Add_Clientes;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.edisoncor.gui.button.ButtonRound;

/**
 *
 * @author Adrian
 */
public class ClientesDao {
L_Clientes clientes = new L_Clientes();
Clientes_E entidadCliente = new Clientes_E();
Ajustes configuraciones = new Ajustes();
public void CrearClientes(String doc,String lastName,String name,
String address,String email){
String clienteData = lastName+" "+name;
entidadCliente.setDocumento(doc);entidadCliente.setApellidos(lastName);
entidadCliente.setNombres(name);entidadCliente.setDireccion(address);
entidadCliente.setCorreoElectronico(email);
int dataCliente = clientes.registrarClientes(entidadCliente);
if(dataCliente==1){
JOptionPane.showMessageDialog(null, "El Cliente "+clienteData+""
+ " se a registrado sin problemas","Successfull (:",JOptionPane.INFORMATION_MESSAGE);
}else{
if(dataCliente==2){
JOptionPane.showMessageDialog(null, "El cliente con el documento "+doc+" ya existe",
"!ADVERTENCIA¡",JOptionPane.WARNING_MESSAGE);
}else{
JOptionPane.showMessageDialog(null, "Error al reigstrar cliente, intentelo nuevamente",
"Error ):",JOptionPane.ERROR_MESSAGE);
}
}
}  
/**
 * 
 * @param mdt 
 */
public void mostrarClientes(DefaultTableModel mdt,JTable tabla,
ButtonRound botonEditar,ButtonRound botonSelect){
configuraciones.clearTable(mdt);
tabla.setDefaultRenderer(Object.class, new TablaButton());
ArrayList<Clientes_E> clientesDato=clientes.viewClientes(entidadCliente);
for(Clientes_E cliente:clientesDato){
Object datos[]={cliente.getDocumento(),cliente.getApellidos()+" "+cliente.getNombres(),
cliente.getDireccion(),cliente.getCorreoElectronico(),botonEditar,botonSelect};  
mdt.addRow(datos);
}
}

public void ListarPorDocumento(String documento,
JTextField txtDoc,JTextField txtApell,JTextField txtNomb,JTextField txtDir,
JTextField txtCorr){
entidadCliente.setDocumento(documento);
ArrayList<Clientes_E> listaXDoc=clientes.BuscarPorDocumento(entidadCliente);
for(Clientes_E clientes: listaXDoc){
txtDoc.setText(clientes.getDocumento());
txtApell.setText(clientes.getApellidos());
txtNomb.setText(clientes.getNombres());
txtDir.setText(clientes.getDireccion());
txtCorr.setText(clientes.getCorreoElectronico());
}
}
/**
 * Modificar clientes
 */
public void modifyClientes(String doc,String lastName,String name,
String address,String email,String dniModify){
String clienteData = lastName+" "+name;
entidadCliente.setDocumento(doc);entidadCliente.setApellidos(lastName);
entidadCliente.setNombres(name);entidadCliente.setDireccion(address);
entidadCliente.setCorreoElectronico(email);
int dataCliente = clientes.editarClientes(entidadCliente,dniModify);
if(dataCliente==1){
JOptionPane.showMessageDialog(null, "El Cliente "+clienteData+""
+ " se a modificado sin problemas","Successfull (:",JOptionPane.INFORMATION_MESSAGE);
}else{
JOptionPane.showMessageDialog(null, "Error al modificar cliente, intentelo nuevamente",
"Error ):",JOptionPane.ERROR_MESSAGE);
}
}  
/**
 * Mostrar cliente por documento
 * @param labResultado
 * @param documento 
 */
   public void find(JLabel labResultado,String documento){
   if(documento.trim().length()>0 && (documento.trim().length()!=8 && documento.trim().length()<11)){
   labResultado.setText("Buscando...");
   labResultado.setForeground(Color.orange);
   }else{
   if(documento.trim().length()==0){
   labResultado.setText("");
   }else{
   entidadCliente.setDocumento(documento);
   String Data = clientes.getCliente(entidadCliente);
   if(Data.equals("Error")){
     labResultado.setText("¡NO EXISTE CLIENTE!");  
     labResultado.setForeground(Color.red);
     FR_Add_Clientes clienteFr = new FR_Add_Clientes(null, true);
     FR_Add_Clientes.txtDocumento.setText(documento);
     FR_Add_Clientes.txtApellidos.grabFocus();
     clienteFr.setVisible(true);
   }else{
    labResultado.setText(Data);
    labResultado.setForeground(Color.blue);
   }  
   } 
   }
   }

}
