/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Modells.Logica;

import com.AppFactura.Config.Conexion;
import com.AppFactura.Config.controlador;
import com.AppFactura.Modells.Entidades.Personas_E;
import com.AppFactura.Modells.Entidades.Usuarios_E;

/**
 *
 * @author Adrian
 */
public class L_Usuarios {

L_Personas personaLogica = new L_Personas();
controlador control = new controlador();
public int createUsuario(Usuarios_E usuario,Personas_E persona){
int valor=0;String queryUser;boolean existePersona=false,existeUser=false;
Conexion conexion = new Conexion();
conexion.sql = "INSERT INTO usuarios(nick,pasword,rol,estado,id_persona) "
+ " values(?,md5(?),?,?,(select id_persona from personas where documento=?))"; 
conexion.query ="SELECT *FROM personas WHERE documento=?";/// existencia de la persona por el documento
queryUser ="SELECT *FROM usuarios WHERE nick=?";
existePersona = control.existeDato(conexion.query, persona.getDocumento());/// retorna true o false
existeUser = control.existeDato(queryUser, usuario.getNameUser());/// retorna true ó false
try{
conexion.pps = conexion.getConection().prepareStatement(conexion.sql);
conexion.pps.setString(1,usuario.getNameUser());
conexion.pps.setString(2, usuario.getPassword());
conexion.pps.setString(3, usuario.getNameRol());
conexion.pps.setString(4, usuario.getEstado());
conexion.pps.setString(5, persona.getDocumento());
if(!existePersona){
if(!existeUser){
/// madamos a llamar a la persona
if(personaLogica.addPersonas(persona)==1){
valor =conexion.pps.executeUpdate();/// 1 
}else{
 valor =2;
}
}else{valor=4;}    
}else{valor=3;}
       
}catch(Exception e){e.printStackTrace();}finally{conexion.cerrarBD();}
return valor;
}
}
