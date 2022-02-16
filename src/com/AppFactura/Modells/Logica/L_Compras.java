/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Modells.Logica;

import com.AppFactura.Config.Conexion;
import com.AppFactura.Modells.Entidades.DetalleCompra_E;

/**
 *
 * @author Adrian
 */
public class L_Compras {

    /**
     * Método para insertar datos en la compra
     * @param compras
     * @return 
     */
public int addCompra(DetalleCompra_E compras){
Conexion conexion = new Conexion();int valor=0;
try{
conexion.sql ="call insertarCompra(?,?,?)";   
conexion.pps = conexion.getConection().prepareStatement(conexion.sql);
conexion.pps.setString(1,compras.getSerieCompra());
conexion.pps.setString(2,compras.getNameUser());
conexion.pps.setString(3, compras.getProveedor().getDocumento());
valor = conexion.pps.executeUpdate();
}catch(Exception e){e.printStackTrace();}finally{conexion.cerrarBD();}
return valor;
}

public int addDetalleCompra(DetalleCompra_E compras){
Conexion conexion = new Conexion();int valor=0;
try{
conexion.sql ="call insertarDetalleCompra(?,?,?,?,?);";   
conexion.pps = conexion.getConection().prepareStatement(conexion.sql);
conexion.pps.setString(1,compras.getSerieCompra());
conexion.pps.setInt(2,compras.getCatalogo().getIdProducto());
conexion.pps.setInt(3, compras.getCantidadCompra());
conexion.pps.setDouble(4, compras.getPrecioCompra());
conexion.pps.setDouble(5, compras.getImporteCompra());
valor = conexion.pps.executeUpdate();
}catch(Exception e){e.printStackTrace();}finally{conexion.cerrarBD();}
return valor;
}
 
    
}
