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
import java.util.ArrayList;
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
ButtonRound botonEditar){
tabla.setDefaultRenderer(Object.class, new TablaButton());
ArrayList<Clientes_E> clientesDato=clientes.viewClientes(entidadCliente);
for(Clientes_E cliente:clientesDato){
Object datos[]={cliente.getDocumento(),cliente.getApellidos()+" "+cliente.getNombres(),
cliente.getDireccion(),cliente.getCorreoElectronico(),botonEditar};  
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

}
