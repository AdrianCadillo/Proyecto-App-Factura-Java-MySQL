/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Modells.Logica;

import com.AppFactura.Config.Conexion;
import com.AppFactura.Config.controlador;
import com.AppFactura.Modells.Entidades.Clientes_E;
import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class L_Clientes {
controlador control = new controlador();
/**
 *Este método sirve para crear personas 
 * @param cliente --> contiene la data de la persona getters y Setters
 * @return entero
 */    
private int addPersonas(Clientes_E cliente){
Conexion conector = new Conexion();
 
int valor=0;
try{
conector.sql="INSERT INTO personas(documento,apellidos,nombres,direccion) "
        + " values(?,?,?,?)"; 
conector.pps=conector.getConection().prepareStatement(conector.sql);
conector.pps.setString(1, cliente.getDocumento());
conector.pps.setString(2, cliente.getApellidos());
conector.pps.setString(3, cliente.getNombres());
conector.pps.setString(4, cliente.getDireccion());
valor = conector.pps.executeUpdate();
}catch(Exception e){}finally{conector.cerrarBD();}
return valor;
}
/**
 * Este Método sirve para crear nuevos Clientes en mi base
 * de datos
 * @param persona --> sirve para usar los gettersy setters
 * @return -->retorna un booleano(si retorna true se registra
 * caso contrario no registra)
 */ 
public int registrarClientes(Clientes_E cliente){
int response=0;int valor=0;
Conexion conector = new Conexion();
try{
conector.sql="INSERT INTO clientes(correo,id_persona) "
        + " values(?,(select id_persona from personas where documento=?))"; 
conector.pps=conector.getConection().prepareStatement(conector.sql);
conector.pps.setString(1, cliente.getCorreoElectronico());
conector.pps.setString(2, cliente.getDocumento());
/// verificamos si la persona ya existe en la base de datos
String queryVerifica ="SELECT *FROM personas where documento=?";
if(!control.existeDato(queryVerifica, cliente.getDocumento())){
if(addPersonas(cliente)>0){
valor = conector.pps.executeUpdate();
if(valor>0){
response = 1;    
} 
}    
}else{response =2;}
/// verificar si la persona se a registrado correctamente
 
}catch(Exception e){}finally{conector.cerrarBD();}
return response;
}  
/**
 * Este método sirve para mostrar a los clientes
 * @param clientes
 * @return 
 */
public ArrayList<Clientes_E> viewClientes(Clientes_E clientes){
Conexion conexion = new Conexion();
/// creamos un ArrayList
ArrayList<Clientes_E> listaClientes =new ArrayList<>();
conexion.sql ="select *from v_listaclientes;";
try {
conexion.pps = conexion.getConection().prepareStatement(conexion.sql);
conexion.rs=conexion.pps.executeQuery();
while(conexion.rs.next()){
clientes = new Clientes_E();
clientes.setDocumento(conexion.rs.getString(1));
clientes.setApellidos(conexion.rs.getString(2));
clientes.setNombres(conexion.rs.getString(3));
clientes.setDireccion(conexion.rs.getString(4));
clientes.setCorreoElectronico(conexion.rs.getString(5));
listaClientes.add(clientes);
}
} catch (Exception e) {}finally{conexion.cerrarBD();}
return listaClientes;
}

/**
 *Este método sirve para crear personas 
 * @param cliente --> contiene la data de la persona getters y Setters
 * @return entero
 */    
private int editarPersonas(Clientes_E cliente,String dniModify){
Conexion conector = new Conexion();
 
int valor=0;
try{
conector.sql="UPDATE personas SET documento=?,apellidos=?,nombres=?,"
        + " direccion=? WHERE id_persona=(SELECT id_persona FROM personas "
        + " WHERE documento=?)"; 
conector.query="UPDATE personas SET apellidos=?,nombres=?,"
        + " direccion=? WHERE id_persona=(SELECT id_persona FROM personas "
        + " WHERE documento=?)"; 
String queryExistePersona ="SELECT *FROM personas where dni=?";
if(!control.existeDato(queryExistePersona, cliente.getDocumento())){
conector.pps=conector.getConection().prepareStatement(conector.sql);
conector.pps.setString(1, cliente.getDocumento());
conector.pps.setString(2, cliente.getApellidos());
conector.pps.setString(3, cliente.getNombres());
conector.pps.setString(4, cliente.getDireccion());
conector.pps.setString(5, dniModify);
}else{
conector.pps=conector.getConection().prepareStatement(conector.query);
conector.pps.setString(1, cliente.getApellidos());
conector.pps.setString(2, cliente.getNombres());
conector.pps.setString(3, cliente.getDireccion());
conector.pps.setString(4, cliente.getDocumento());
}
valor = conector.pps.executeUpdate();  
}catch(Exception e){}finally{conector.cerrarBD();}
return valor;
}
/**
 * Este Método sirve para crear nuevos Clientes en mi base
 * de datos
 * @param persona --> sirve para usar los gettersy setters
 * @return -->retorna un booleano(si retorna true se registra
 * caso contrario no registra)
 */ 
public int editarClientes(Clientes_E cliente,String dniModify){
int response=0;int valor=0;
Conexion conector = new Conexion();
try{
conector.sql="UPDATE clientes SET correo=? WHERE id_Cliente=(SELECT id_cliente"
        + " FROM clientes WHERE id_persona=(SELECT id_persona FROM personas"
        + " WHERE documento=?))"; 
conector.pps=conector.getConection().prepareStatement(conector.sql);
conector.pps.setString(1, cliente.getCorreoElectronico());
conector.pps.setString(2, cliente.getDocumento());
/// verificamos si la persona ya existe en la base de datos
if(editarPersonas(cliente, dniModify)>0){
valor = conector.pps.executeUpdate();
if(valor>0){
response = 1;    
} 
}    
/// verificar si la persona se a registrado correctament
}catch(Exception e){}finally{conector.cerrarBD();}
return response;
}  
public ArrayList<Clientes_E> BuscarPorDocumento(Clientes_E clientes){
Conexion conexion = new Conexion();
/// creamos un ArrayList
ArrayList<Clientes_E> listaClientes =new ArrayList<>();
conexion.sql ="select *from v_ListaClientesporDocumento where documento=?";
try {
conexion.pps = conexion.getConection().prepareStatement(conexion.sql);
conexion.pps.setString(1, clientes.getDocumento());
conexion.rs=conexion.pps.executeQuery();
while(conexion.rs.next()){
clientes = new Clientes_E();
clientes.setDocumento(conexion.rs.getString(1));
clientes.setApellidos(conexion.rs.getString(2));
clientes.setNombres(conexion.rs.getString(3));
clientes.setDireccion(conexion.rs.getString(4));
clientes.setCorreoElectronico(conexion.rs.getString(5));
listaClientes.add(clientes);
}
} catch (Exception e) {}finally{conexion.cerrarBD();}
return listaClientes;
}

public String getCliente(Clientes_E cliente){
String Query ="select fc_getCliente(?) as Cliente;";
String Cliente = control.getDato(Query, 1, cliente.getDocumento());
return  Cliente;
}

}
