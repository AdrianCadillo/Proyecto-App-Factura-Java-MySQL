/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Modells.Logica;

import com.AppFactura.Config.Conexion;
import com.AppFactura.Modells.Entidades.Login_E;
import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class L_login {

public ArrayList<Login_E> accesoSistema(Login_E login){
ArrayList<Login_E> accesoLista = new ArrayList(); 
Conexion conexion = new Conexion();
conexion.sql ="call p_login(?,?,?);";
try{
conexion.pps = conexion.getConection().prepareStatement(conexion.sql);
conexion.pps.setString(1,login.getNameUser());
conexion.pps.setString(2, login.getNamePerfil());
conexion.pps.setString(3, login.getPassword());
conexion.rs = conexion.pps.executeQuery();
while(conexion.rs.next()){
login = new Login_E();
login.setNameUser(conexion.rs.getString(1));
login.setApellidos(conexion.rs.getString(2));
login.setNombres(conexion.rs.getString(3));
login.setNamePerfil(conexion.rs.getString(4));
accesoLista.add(login);
}
}catch(Exception e){e.printStackTrace();}finally{conexion.cerrarBD();}

return accesoLista;
}
}
