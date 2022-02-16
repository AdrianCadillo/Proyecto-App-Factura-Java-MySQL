/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Modells.Logica;

import com.AppFactura.Config.Conexion;
import com.AppFactura.Config.controlador;
import com.AppFactura.Modells.Entidades.DetalleFactura_E;
import com.AppFactura.Modells.Entidades.Facturas_E;

/**
 *
 * @author Adrian
 */
public class L_Facturas {
    controlador control = new controlador();
    
    public String SerieComprobante(Facturas_E factura){
    String Query = "select Fc_serieComprobante(?) as Serie;";
    String serie = control.getDato(Query, 1,factura.getComprobante());
    return serie;
    }
    
    public int reducirStock(DetalleFactura_E dv){
     String QueryCambio="call reducir_stock(?,?)";
     Object datos[]={dv.getUnidadesF(),dv.getProducto().getIdProducto()};
     return control.Alta_Baja_Cambio(QueryCambio, datos);
    }
    
}
