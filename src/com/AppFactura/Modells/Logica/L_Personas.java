/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Modells.Logica;

import com.AppFactura.Config.Conexion;
import com.AppFactura.Modells.Entidades.Personas_E;

/**
 *
 * @author Adrian
 */
public class L_Personas {

public int addPersonas(Personas_E personas){
Conexion conector = new Conexion();
 
int valor=0;
try{
conector.sql="INSERT INTO personas(documento,apellidos,nombres,direccion) "
        + " values(?,?,?,?)"; 
conector.pps=conector.getConection().prepareStatement(conector.sql);
conector.pps.setString(1, personas.getDocumento());
conector.pps.setString(2, personas.getApellidos());
conector.pps.setString(3, personas.getNombres());
conector.pps.setString(4, personas.getDireccion());
valor = conector.pps.executeUpdate();
}catch(Exception e){}finally{conector.cerrarBD();}
return valor;
}    
}
