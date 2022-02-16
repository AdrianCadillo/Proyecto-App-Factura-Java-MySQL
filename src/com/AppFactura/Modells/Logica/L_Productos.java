/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Modells.Logica;

import com.AppFactura.Config.Conexion;
import com.AppFactura.Config.controlador;
import com.AppFactura.Modells.Entidades.DetalleCompra_E;
import com.AppFactura.Modells.Entidades.Productos_E;
import com.mysql.cj.jdbc.Blob;
import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class L_Productos {
controlador ct = new controlador();
/**
 * Este método sirve para crear nuevos prosuctos
 * @param productos--->
 * @return 
 */
public int addProductos(Productos_E productos){
int valor=0;
Conexion conexion = new Conexion();
conexion.sql = "INSERT INTO productos(codigoprod,descripcion,precio,stock,foto,"
+ " id_categoria) values(?,?,?,?,?,(select id_categoria from categorias "
+ "WHERE nombcategoria=?))";
conexion.query = " select *from productos where codigoprod=? or descripcion=?;";
boolean existe=ct.existeDatoDosParametros(conexion.query, productos.getCodigoProducto(), 
                                          productos.getDescripcionProducto());
try {
conexion.pps = conexion.getConection().prepareStatement(conexion.sql);
conexion.pps.setString(1, productos.getCodigoProducto());
conexion.pps.setString(2, productos.getDescripcionProducto());
conexion.pps.setDouble(3, productos.getPrecioProducto());
conexion.pps.setInt(4, productos.getStockProducto());
conexion.pps.setBlob(5, productos.getRutaFoto());
conexion.pps.setString(6, productos.getNombreCategoria());
if(!existe){
valor = conexion.pps.executeUpdate();// 0 y 1
}else{
valor =2;  
}
} catch (Exception e) {}finally{conexion.cerrarBD();}
return valor;
} 

public String getQueryCategorias(){
 String Query ="SELECT *FROM categorias";
 return Query;
}
/**
 * Mostrar los productos
 * @param productos
 * @param catalogo
 * @return 
 */
public ArrayList<DetalleCompra_E> viewCatalogo(DetalleCompra_E productos,Productos_E catalogo){
ArrayList<DetalleCompra_E> productosLista = new ArrayList<>();
Conexion conexion = new Conexion();
conexion.sql = "select *from v_lista_catalago;";
try {
conexion.pps = conexion.getConection().prepareStatement(conexion.sql);
conexion.rs = conexion.pps.executeQuery();
while(conexion.rs.next()){
catalogo = new Productos_E();
catalogo.setIdProducto(conexion.rs.getInt(1));
catalogo.setCodigoProducto(conexion.rs.getString(2));
catalogo.setDescripcionProducto(conexion.rs.getString(3));
catalogo.setPrecioProducto(conexion.rs.getDouble(4));
catalogo.setStockProducto(conexion.rs.getInt(6));
catalogo.setFotoProducto((Blob) conexion.rs.getBlob(7));
catalogo.setNombreCategoria(conexion.rs.getString(8));
productos = new DetalleCompra_E();
productos.setCatalogo(catalogo);
productos.setPrecioCompra(conexion.rs.getDouble(5));

productosLista.add(productos);
}
} catch (Exception e) {e.printStackTrace();}finally{conexion.cerrarBD();}
return productosLista;
}
public Blob getFoto(Productos_E producto){
Conexion conexion = new Conexion();Blob foto=null;
conexion.sql ="SELECT foto FROM productos WHERE id_producto=?";
try{
foto = ct.getImagen(conexion.sql, 1, producto.getIdProducto());
}catch(Exception e){}finally{conexion.cerrarBD();}
return foto;
}

public String getPrecio(Productos_E producto){
Conexion conexion = new Conexion();String precio="";
conexion.sql ="SELECT *FROM productos WHERE descripcion=?";
try{
precio=ct.getDato(conexion.sql, 4, producto.getDescripcionProducto());
}catch(Exception e){}finally{conexion.cerrarBD();}
return precio;
}



}
