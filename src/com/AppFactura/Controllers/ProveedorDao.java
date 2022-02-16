/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Controllers;

import com.AppFactura.Modells.Entidades.Personas_E;
import com.AppFactura.Modells.Entidades.Proveedor_E;
import com.AppFactura.Modells.Logica.L_Proveedor;
import com.AppFactura.Personalizaciones.Ajustes;
import com.AppFactura.Personalizaciones.TablaButton;
import com.AppFactura.Vistas.Proveedores.FR_Add_Proveedores;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adrian
 */
public class ProveedorDao {
    L_Proveedor proveedorLogica = new L_Proveedor();
    Personas_E personaEntity = new Personas_E();
    Proveedor_E provedorEntity = new Proveedor_E();
    Ajustes configs= new Ajustes();
   public void create(String documento,String nombres,
   String direccion,String PaginaWeb,String Correo){
    personaEntity.setDocumento(documento);personaEntity.setNombres(nombres);
    personaEntity.setDireccion(direccion);provedorEntity.setPaginaWeb(PaginaWeb);
    provedorEntity.setCorreo(Correo);
    int valor = proveedorLogica.createProveedor(provedorEntity, personaEntity);// 1 | 2 | 3 | 4
    if(valor==1){
    JOptionPane.showMessageDialog(null, "Proveedor Creado correctamente",
    "Succesfull (: ",JOptionPane.INFORMATION_MESSAGE);
    }else{
    if(valor==3){
     JOptionPane.showMessageDialog(null, "Ya existe una Razón social con el RUC "+documento+" | o Nombre de Razón "
      + " social : "+nombres,
     "¡ADVERTENCIA! (: ",JOptionPane.WARNING_MESSAGE);   
    }else{
     if(valor==4){
      JOptionPane.showMessageDialog(null, "Ya existe un Proveedor con el Correo "+Correo,
     "¡ADVERTENCIA! (: ",JOptionPane.WARNING_MESSAGE);   
     }else{
      JOptionPane.showMessageDialog(null, "Error al Registrar al proveedor "+nombres,
     "¡ERROR! (: ",JOptionPane.ERROR_MESSAGE);
     }
    }
    }
    } 
   
   public void allProveedores(DefaultTableModel modelP,JButton botonEditar,JButton botonDelete,
     JButton botonSelect,JTable tabla){
     configs.clearTable(modelP); tabla.setDefaultRenderer(Object.class, new TablaButton());
     ArrayList<Proveedor_E> listaProvedor =  proveedorLogica.listarProveedores(provedorEntity);
     for(Proveedor_E proveedor : listaProvedor){
      Object datosP[]={proveedor.getDocumento(),
      proveedor.getNombres(),proveedor.getDireccion(),proveedor.getPaginaWeb(),
      proveedor.getCorreo(),botonEditar,botonDelete,botonSelect,proveedor.getIdProveedor(),
      proveedor.getIdPersona()};
      modelP.addRow(datosP);
     }
   }
   
   public void show(JLabel labResultado,String documento){
   if(documento.trim().length()>0 && documento.trim().length()<11){
   labResultado.setText("Buscando...");
   labResultado.setForeground(Color.orange);
   }else{
   if(documento.trim().length()==0){
   labResultado.setText("");
   }else{
   provedorEntity.setDocumento(documento);
   String Data = proveedorLogica.getProveedor(provedorEntity);
   if(Data.isEmpty()){
     labResultado.setText("¡NO EXISTE PROVEEDOR!");  
     labResultado.setForeground(Color.red);
     FR_Add_Proveedores provedorAdd = new FR_Add_Proveedores(null, true);
     FR_Add_Proveedores.txtRuc.setText(documento);
     FR_Add_Proveedores.txtRazonSocial.grabFocus();
     provedorAdd.setVisible(true);
   }else{
    labResultado.setText(Data);
    labResultado.setForeground(Color.blue);
   }  
   } 
   }
   }
   
   /**
    * mostrar la foto en Jlabel
    */
   
}
