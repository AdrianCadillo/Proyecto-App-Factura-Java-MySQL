/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Modells.Entidades;

/**
 *
 * @author Adrian
 */
public class DetalleFactura_E extends Facturas_E{
private Productos_E producto;
private Integer UnidadesF;
private double PrecioF;
private double ImporteF;

    public Productos_E getProducto() {
        return producto;
    }

    public void setProducto(Productos_E producto) {
        this.producto = producto;
    }

    public Integer getUnidadesF() {
        return UnidadesF;
    }

    public void setUnidadesF(Integer UnidadesF) {
        this.UnidadesF = UnidadesF;
    }

    public double getPrecioF() {
        return PrecioF;
    }

    public void setPrecioF(double PrecioF) {
        this.PrecioF = PrecioF;
    }

    public double getImporteF() {
        return ImporteF;
    }

    public void setImporteF(double ImporteF) {
        this.ImporteF = ImporteF;
    }


}
