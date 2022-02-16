/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Controllers;

import com.AppFactura.Modells.Entidades.Personas_E;
import com.AppFactura.Modells.Entidades.Usuarios_E;
import com.AppFactura.Modells.Logica.L_Usuarios;
import javax.swing.JOptionPane;

/**
 *
 * @author Adrian
 */
public class UsuariosDao {
    L_Usuarios usuarioLogica = new L_Usuarios();
    Usuarios_E entityUser = new Usuarios_E();
    Personas_E personaEntity = new Personas_E();
    
    public void create(String documento,String apellidos,String nombres,
    String direccion,String rol,String nick,String pasword,String Estado){
    personaEntity.setDocumento(documento);personaEntity.setApellidos(apellidos);
    personaEntity.setNombres(nombres);personaEntity.setDireccion(direccion);
    entityUser.setNameUser(nick);entityUser.setPassword(pasword);
    entityUser.setNameRol(rol);entityUser.setEstado(Estado);
    int valor = usuarioLogica.createUsuario(entityUser, personaEntity);// 1 | 2 | 3 | 4
    if(valor==1){
        JOptionPane.showMessageDialog(null, "Usuario Creado correctamente",
        "Succesfull (: ",JOptionPane.INFORMATION_MESSAGE);
    }else{
    if(valor==3){
     JOptionPane.showMessageDialog(null, "Ya existe una persona con el dni "+documento,
     "¡ADVERTENCIA! (: ",JOptionPane.WARNING_MESSAGE);   
    }else{
     if(valor==4){
      JOptionPane.showMessageDialog(null, "Ya existe un uusario con el nick "+nick,
     "¡ADVERTENCIA! (: ",JOptionPane.WARNING_MESSAGE);   
     }else{
      JOptionPane.showMessageDialog(null, "Error al crear la cuenta de usuario para la persona "
      +apellidos+" "+nombres,
     "¡ERROR! (: ",JOptionPane.ERROR_MESSAGE);
     }
    }
    }
    }
}
