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
public class Facturas_E extends Usuarios_E{
private int IdFactura;
private String Comprobante;
private String SerieFactura;
private Clientes_E cliente;

    public int getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(int IdFactura) {
        this.IdFactura = IdFactura;
    }

    public String getSerieFactura() {
        return SerieFactura;
    }

    public void setSerieFactura(String SerieFactura) {
        this.SerieFactura = SerieFactura;
    }

    public Clientes_E getCliente() {
        return cliente;
    }

    public void setCliente(Clientes_E cliente) {
        this.cliente = cliente;
    }

    public String getComprobante() {
        return Comprobante;
    }

    public void setComprobante(String Comprobante) {
        this.Comprobante = Comprobante;
    }


}
