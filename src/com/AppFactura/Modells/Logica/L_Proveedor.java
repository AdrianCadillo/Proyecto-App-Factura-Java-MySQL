/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Modells.Logica;

import com.AppFactura.Config.Conexion;
import com.AppFactura.Config.controlador;
import com.AppFactura.Modells.Entidades.Personas_E;
import com.AppFactura.Modells.Entidades.Proveedor_E;
import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class L_Proveedor {
L_Personas personaLogica = new L_Personas();
controlador control = new controlador();
public int createProveedor(Proveedor_E proveedor,Personas_E persona){
int valor=0;String queryProveedor;boolean existePersona=false,existeProveedor=false;
Conexion conexion = new Conexion();
conexion.sql = "INSERT INTO proveedores(correo,paginaweb,id_persona)"
        + " values(?,?,(SELECT id_persona FROM personas WHERE documento=?))"; 
conexion.query ="SELECT *FROM personas WHERE documento=? or nombres=?";/// existencia de la persona por el documento
queryProveedor ="SELECT *FROM proveedores WHERE correo=?";
existePersona = control.existeDatoDosParametros(conexion.query, 
persona.getDocumento(),persona.getNombres());/// retorna true o false
existeProveedor =control.existeDato(queryProveedor,proveedor.getCorreo());/// retorna true ó false
try{
conexion.pps = conexion.getConection().prepareStatement(conexion.sql);
conexion.pps.setString(1,proveedor.getCorreo());
conexion.pps.setString(2,proveedor.getPaginaWeb());
conexion.pps.setString(3,persona.getDocumento());
if(!existePersona){
if(!existeProveedor){
if(personaLogica.addPersonas(persona)==1 && conexion.pps.executeUpdate()==1){
 valor=1; 
}else{
 valor=0;   
}
}else{valor=4;}    
}else{valor=3;}
       
}catch(Exception e){e.printStackTrace();}finally{conexion.cerrarBD();}
return valor;
}
/**
 * 
 * @param provedor
 * @return 
 */
public ArrayList<Proveedor_E> listarProveedores(Proveedor_E provedor){
Conexion conexion = new Conexion();
/// arraylist
ArrayList<Proveedor_E> provedorLista = new ArrayList<>();
conexion.sql ="SELECT *FROM v_proveedores;";
try {
conexion.pps = conexion.getConection().prepareStatement(conexion.sql);
conexion.rs = conexion.pps.executeQuery();
while(conexion.rs.next()){
provedor = new Proveedor_E();
provedor.setIdProveedor(conexion.rs.getInt(1));
provedor.setIdPersona(conexion.rs.getInt(2));
provedor.setDocumento(conexion.rs.getString(3));
provedor.setNombres(conexion.rs.getString(4));
provedor.setDireccion(conexion.rs.getString(5));
provedor.setPaginaWeb(conexion.rs.getString(6));
provedor.setCorreo(conexion.rs.getString(7));
provedorLista.add(provedor);
}
} catch (Exception e) {}finally{conexion.cerrarBD();}
return provedorLista;
}
public String getProveedor(Proveedor_E provedor){
String Query="SELECT *FROM personas WHERE documento=?";
String proveedor = control.getDato(Query, 4,provedor.getDocumento());
return proveedor;
}
}
