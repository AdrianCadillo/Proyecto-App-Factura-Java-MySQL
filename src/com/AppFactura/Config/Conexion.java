/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Config;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
/**
 *
 * @author Adrian
 */
public class Conexion {
//// atributos
private String Driver="Driver_Class";
private String Usuario="Usuario_BD";
private String Password="Password_BD";
private String URL="URL_CONNECTION";
public String sql;public ResultSet rs=null;public Statement st=null;
public String query;
public PreparedStatement pps=null;private Connection conector=null;
Properties propiedadConector = new Properties();
public Conexion(){
try {
 propiedadConector.load(new FileInputStream("src/Conexion.properties"));
 Class.forName(propiedadConector.getProperty(Driver)); 
 conector=DriverManager.getConnection(propiedadConector.getProperty(URL),
 propiedadConector.getProperty(Usuario),propiedadConector.getProperty(Password));
} catch (Exception e) {e.printStackTrace();} 
}
/// método tipo Connection que devuleve la conexion a mi base de datos
public Connection getConection(){
 return this.conector;   
}
/// Cerramos la conexión a la base de datos
public void cerrarBD(){
try {
if(st!=null){
st.close();
} 
if(rs!=null){
  rs.close();
}
if(pps!=null){
 pps.close();
}
if(conector!=null){
conector.close();
}
} catch (Exception e) {}
}
}
