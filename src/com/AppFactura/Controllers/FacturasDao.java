/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Controllers;

import com.AppFactura.Modells.Entidades.DetalleCompra_E;
import com.AppFactura.Modells.Entidades.DetalleFactura_E;
import com.AppFactura.Modells.Entidades.Facturas_E;
import com.AppFactura.Modells.Entidades.Productos_E;
import com.AppFactura.Modells.Logica.L_Facturas;
import com.AppFactura.Modells.Logica.L_Productos;
import com.AppFactura.Personalizaciones.Ajustes;
import com.AppFactura.Personalizaciones.TablaButton;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.edisoncor.gui.button.ButtonRound;

/**
 *
 * @author Adrian
 */
public class FacturasDao {
    L_Facturas lfactura = new L_Facturas();
    L_Productos productoL = new L_Productos();
    Facturas_E entityFactura = new Facturas_E();
    DetalleCompra_E dc = new DetalleCompra_E();
    Productos_E productoE = new Productos_E();
    DetalleFactura_E detfac = new DetalleFactura_E();
    Ajustes ajs = new Ajustes();
    public void findSerie(JLabel labelSerie){
     entityFactura.setComprobante("FACTURA");
     labelSerie.setText(lfactura.SerieComprobante(entityFactura));
    }
    
public void ViewProductos(DefaultTableModel mdt,JTable tabla,JButton botonListar){
ajs.clearTable(mdt);tabla.setDefaultRenderer(Object.class, new TablaButton());int item=0;
ArrayList<DetalleCompra_E> listaCatalogo =productoL.viewCatalogo(dc,productoE);
try{
for(DetalleCompra_E productos:listaCatalogo){item+=1;
Object datosCatalogo[]={productos.getCatalogo().getIdProducto(),
productos.getCatalogo().getDescripcionProducto(),productos.getCatalogo().getPrecioProducto(),
productos.getCatalogo().getStockProducto(),botonListar};
mdt.addRow(datosCatalogo);
}    
}catch(Exception e){e.printStackTrace();}
}
    
public void reducirStockVenta(int IDP,int unidad){
productoE.setIdProducto(IDP);detfac.setUnidadesF(unidad);
detfac.setProducto(productoE);
lfactura.reducirStock(detfac);
}

public void ListarProductos_DetalleVenta(int ID,int cantida,String desc,double precio,
DefaultTableModel modelDetalle,JTable tablaDv,ButtonRound botonQuitar,ButtonRound botonEditar){
tablaDv.setDefaultRenderer(Object.class, new TablaButton());
if(!ajs.existeDatoTable(tablaDv,2,desc)){
double Importe = precio* cantida;
Object datosDV[]={ID,cantida,desc,precio,Importe,botonQuitar,botonEditar};
modelDetalle.addRow(datosDV);   
}else{
int cantidadCelda =Integer.parseInt(tablaDv.getValueAt(Ajustes.filaExiste, 1).toString());
int nuevaCantidad=cantidadCelda+cantida;
double Importe =nuevaCantidad*precio;
tablaDv.setValueAt(nuevaCantidad, Ajustes.filaExiste, 1);
tablaDv.setValueAt(Importe, Ajustes.filaExiste,4);
}

    reducirStockVenta(ID, cantida);
}


public void ModificarCeldas(int cantidadN,int ctnuevocelda,JTable tabla,double precio,
        int ID){
double Importe =ctnuevocelda*precio;
tabla.setValueAt(ctnuevocelda, tabla.getSelectedRow(),1);
tabla.setValueAt(Importe, tabla.getSelectedRow(),4);
reducirStockVenta(ID, cantidadN);
}

}
