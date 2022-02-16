/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Modells.Entidades;

import com.mysql.cj.jdbc.Blob;
import java.io.File;
import java.io.InputStream;

/**
 *
 * @author Adrian
 */
public class Productos_E extends Categorias_E{
private int IdProducto;
private String CodigoProducto;
private String DescripcionProducto;
private double PrecioProducto;
private int StockProducto;
private Blob FotoProducto;
private InputStream rutaFoto;

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public String getDescripcionProducto() {
        return DescripcionProducto;
    }

    public void setDescripcionProducto(String DescripcionProducto) {
        this.DescripcionProducto = DescripcionProducto;
    }

    public double getPrecioProducto() {
        return PrecioProducto;
    }

    public void setPrecioProducto(double PrecioProducto) {
        this.PrecioProducto = PrecioProducto;
    }

    public int getStockProducto() {
        return StockProducto;
    }

    public void setStockProducto(int StockProducto) {
        this.StockProducto = StockProducto;
    }

    public Blob getFotoProducto() {
        return FotoProducto;
    }

    public void setFotoProducto(Blob FotoProducto) {
        this.FotoProducto = FotoProducto;
    }

    public InputStream getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(InputStream rutaFoto) {
        this.rutaFoto = rutaFoto;
    }
    

}
