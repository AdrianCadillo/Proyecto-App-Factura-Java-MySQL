/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Config;

import com.mysql.cj.jdbc.Blob;
import javax.swing.DefaultComboBoxModel;


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

public boolean existeDatoDosParametros(String sql,String dato,String dato2){
boolean existe = false;
Conexion conector = new Conexion();
try{
conector.pps = conector.getConection().prepareStatement(sql);
conector.pps.setString(1, dato);
conector.pps.setString(2, dato2);
conector.rs = conector.pps.executeQuery();
if(conector.rs.next()){existe=true;}
}catch(Exception e){}finally{conector.cerrarBD();}
return existe;
}

public void DataCombo(String sql,DefaultComboBoxModel modelCombo,int pos){
Conexion conector = new Conexion();
modelCombo.addElement("---- Seleccione una Categoría ----");
try{
conector.pps = conector.getConection().prepareStatement(sql);
conector.rs=conector.pps.executeQuery();
while(conector.rs.next()){
modelCombo.addElement(conector.rs.getString(pos));
}
}catch(Exception e){e.printStackTrace();}finally{conector.cerrarBD();}  
}

public String getDato(String sql,int pos,String datos){
Conexion conexion = new Conexion();String dato="";
try {
conexion.pps = conexion.getConection().prepareStatement(sql);
conexion.pps.setString(1, datos);
conexion.rs= conexion.pps.executeQuery();
if(conexion.rs.next()){
 dato = conexion.rs.getString(pos);
}
} catch (Exception e) {}finally{conexion.cerrarBD();}
return dato;
}

public Blob getImagen(String sql,int pos,int ID){
Conexion conexion = new Conexion();Blob foto=null;
try {
conexion.pps = conexion.getConection().prepareStatement(sql);
conexion.pps.setInt(1,ID);
conexion.rs= conexion.pps.executeQuery();
if(conexion.rs.next()){
 foto = (Blob) conexion.rs.getBlob(pos);
}
} catch (Exception e) {}finally{conexion.cerrarBD();}
return foto;
}
/***
 * Método General para realizar CRUD
 */
public int Alta_Baja_Cambio(String sql,Object datos[]){
Conexion conector = new Conexion();
int valor=0;
try{
conector.pps = conector.getConection().prepareStatement(sql);
for(int i=0;i<datos.length;i++){
conector.pps.setObject((i+1),datos[i]);
}
valor = conector.pps.executeUpdate();
}catch(Exception e){e.printStackTrace();}finally{conector.cerrarBD();}
return valor;
}

}
