/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Config;

/**
 *
 * @author Adrian
 */
public class controlador {

/// srive para validar la existencia de datos
public boolean existeDato(String sql,String dato){
boolean existe = false;
Conexion conector = new Conexion();
try{
conector.pps = conector.getConection().prepareStatement(sql);
conector.pps.setString(1, dato);
conector.rs = conector.pps.executeQuery();
if(conector.rs.next()){existe=true;}
}catch(Exception e){}finally{conector.cerrarBD();}
return existe;
}
}
