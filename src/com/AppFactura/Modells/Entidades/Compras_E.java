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
public class Compras_E extends Usuarios_E{
private int IdCompra;
private String serieCompra;
private Proveedor_E proveedor;

    public int getIdCompra() {
        return IdCompra;
    }

    public void setIdCompra(int IdCompra) {
        this.IdCompra = IdCompra;
    }

    public String getSerieCompra() {
        return serieCompra;
    }

    public void setSerieCompra(String serieCompra) {
        this.serieCompra = serieCompra;
    }

    public Proveedor_E getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor_E proveedor) {
        this.proveedor = proveedor;
    }




}
