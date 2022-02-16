/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Controllers;

import com.AppFactura.Modells.Entidades.Login_E;
import com.AppFactura.Modells.Logica.L_login;
import com.AppFactura.Vistas.Login.FR_Login;
import com.AppFactura.Vistas.MenuPrincipal.FR_MenuPrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Adrian
 */
public class LoginDao {
L_login logins = new L_login();
Login_E entityLogin = new Login_E();
public void acceso(String nombreUsuario,String Pasword,String Perfil,
FR_Login login){
entityLogin.setNameUser(nombreUsuario);entityLogin.setNamePerfil(Perfil);
entityLogin.setPassword(Pasword);
ArrayList<Login_E> listaDatos =logins.accesoSistema(entityLogin);
if(listaDatos.size()>0){
login.dispose();
for(Login_E loginDatos : listaDatos){
FR_MenuPrincipal  menu = new FR_MenuPrincipal();
menu.setTitle("Bienvenido al sistema de ventas --> Usuario Conectado : "
+loginDatos.getNameUser()+"( "+ loginDatos.getNamePerfil()+" ) ");
FR_MenuPrincipal.NameUsuario=loginDatos.getNameUser();
FR_MenuPrincipal.USUARIOCONECT=loginDatos.getApellidos()+" "+loginDatos.getNombres();
menu.setVisible(true);   
}
}else{
JOptionPane.showMessageDialog(null, "Error en las credenciales","Error ): ",
JOptionPane.ERROR_MESSAGE);
}
}    
}
