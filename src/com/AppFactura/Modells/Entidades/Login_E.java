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
public class Login_E extends Personas_E{
private String NameUser;
private String NamePerfil;
private String Password;
    public String getNameUser() {
        return NameUser;
    }

    public void setNameUser(String NameUser) {
        this.NameUser = NameUser;
    }

    public String getNamePerfil() {
        return NamePerfil;
    }

    public void setNamePerfil(String NamePerfil) {
        this.NamePerfil = NamePerfil;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }


}
