/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppFacturaMain;
 
import com.AppFactura.Vistas.Compras.FR_Ingreso_Productos;
import com.AppFactura.Vistas.Login.FR_Login;
import com.AppFactura.Vistas.MenuPrincipal.FR_MenuPrincipal;
import com.AppFactura.Vistas.Ventas.FR_Ventas;


/**
 *
 * @author Adrian
 */
public class principal {
    public static void main(String[] args) {
//        FR_MenuPrincipal principal = new FR_MenuPrincipal();
//        principal.setVisible(true);
FR_Login login = new FR_Login();
login.setVisible(true);

// FR_Ingreso_Productos compras = new FR_Ingreso_Productos(null, true);
// compras.setVisible(true);
//
//        FR_Ventas venta = new FR_Ventas(null, true);
//        venta.setVisible(true);
    }
}
