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

public class Personas_E{
private int IdPersona;
private String Documento;
private String Apellidos;
private String Nombres;
private String Direccion;

//// Setters And Getters

    public int getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(int IdPersona) {
        this.IdPersona = IdPersona;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

}
