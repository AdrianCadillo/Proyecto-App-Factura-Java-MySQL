/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Controllers;

import com.AppFactura.Config.controlador;
import com.AppFactura.Modells.Entidades.DetalleCompra_E;
import com.AppFactura.Modells.Entidades.Productos_E;
import com.AppFactura.Modells.Logica.L_Productos;
import com.AppFactura.Personalizaciones.Ajustes;
import com.AppFactura.Personalizaciones.TablaButton;
import com.mysql.cj.jdbc.Blob;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adrian
 */
public class ProductosDao {

Productos_E productos = new Productos_E();
DetalleCompra_E detalleCompra = new DetalleCompra_E();
L_Productos prodLogica = new L_Productos();
Ajustes ajs = new Ajustes();
controlador ct = new controlador();
public void create(String codigo,String descripcion,double precio,
int stock,String Categoria,String RutaFoto){
InputStream streamFoto;int valor=0;
try{
if(RutaFoto!=null){
streamFoto= new FileInputStream(new File(String.valueOf(RutaFoto)));   
}else{
streamFoto=null;
}
productos.setCodigoProducto(codigo);productos.setDescripcionProducto(descripcion);
productos.setPrecioProducto(precio);productos.setStockProducto(stock);
productos.setNombreCategoria(Categoria);productos.setRutaFoto(streamFoto);
valor = prodLogica.addProductos(productos);
if(valor==1){
JOptionPane.showMessageDialog(null, "Producto Registrado");
}else{
if(valor==2){
JOptionPane.showMessageDialog(null, "Ya existe un producto con el código "+codigo+" ó quizas la descripción "+
descripcion+" ya existe ","¡ADVERTENCIA!",JOptionPane.WARNING_MESSAGE);
}else{
JOptionPane.showMessageDialog(null, "Error al registrar producto","ERROR ):",JOptionPane.ERROR_MESSAGE);
}
}
}catch(Exception e){e.printStackTrace();}       
}    

public void Categorias_En_Combo(DefaultComboBoxModel modelCombo){
ajs.clearItemsCombo(modelCombo);
ct.DataCombo(prodLogica.getQueryCategorias(), modelCombo,2);
}

public void mostrarCatalogo(DefaultTableModel mdt,JTable tabla,JButton botonEditar,JButton botonDelete){
byte dataBytes[]=null;BufferedImage Imag=null;Image img=null;   
Blob foto =null;int item=0;
ajs.clearTable(mdt);tabla.setDefaultRenderer(Object.class, new TablaButton());
ArrayList<DetalleCompra_E> listaCatalogo =prodLogica.viewCatalogo(detalleCompra, productos);
try{
for(DetalleCompra_E productos:listaCatalogo){item+=1;
foto = productos.getCatalogo().getFotoProducto();
if(foto!=null){
dataBytes = foto.getBytes(1, (int)foto.length());
Imag = ImageIO.read(new ByteArrayInputStream(dataBytes));
img=Imag;
img=img.getScaledInstance(50, 35, 50);
ImageIcon fotos = new ImageIcon(img);
Object datosCatalogo[]={item,productos.getCatalogo().getIdProducto(),productos.getCatalogo().getNombreCategoria(),
productos.getCatalogo().getDescripcionProducto(),productos.getCatalogo().getPrecioProducto(),
productos.getPrecioCompra(),productos.getCatalogo().getStockProducto(),
new JLabel(fotos),botonEditar,botonDelete};
mdt.addRow(datosCatalogo);
}else{
 Object datosCatalogo[]={item,productos.getCatalogo().getIdProducto(),productos.getCatalogo().getNombreCategoria(),
productos.getCatalogo().getDescripcionProducto(),productos.getCatalogo().getPrecioProducto(),
productos.getPrecioCompra(),productos.getCatalogo().getStockProducto(),
new JLabel("Sin Imagen ):"),botonEditar,botonDelete};
mdt.addRow(datosCatalogo);
}

}    
}catch(Exception e){e.printStackTrace();}

}

public void ViewProductos(DefaultTableModel mdt,JTable tabla,JButton botonListar){
ajs.clearTable(mdt);tabla.setDefaultRenderer(Object.class, new TablaButton());int item=0;
ArrayList<DetalleCompra_E> listaCatalogo =prodLogica.viewCatalogo(detalleCompra, productos);
try{
for(DetalleCompra_E productos:listaCatalogo){item+=1;
Object datosCatalogo[]={item,productos.getCatalogo().getIdProducto(),productos.getCatalogo().getNombreCategoria(),
productos.getCatalogo().getDescripcionProducto(),botonListar};
mdt.addRow(datosCatalogo);
}    
}catch(Exception e){e.printStackTrace();}
}
 public void showData(JLabel labelImagen,JLabel labelPrecio,int ID,String descripcion){
   Blob  foto =null;byte fotoBytes[]=null;BufferedImage img=null;
   Image imagen=null;
   productos.setIdProducto(ID);
   productos.setDescripcionProducto(descripcion);
   foto= prodLogica.getFoto(productos);
   try{
   if(foto!=null){labelImagen.setText("");
   fotoBytes = foto.getBytes(1, (int)foto.length());
   img = ImageIO.read(new ByteArrayInputStream(fotoBytes));
   imagen=img;
   imagen=imagen.getScaledInstance(labelImagen.getWidth(), labelImagen.getHeight(), Image.SCALE_DEFAULT);
   ImageIcon icono = new ImageIcon(imagen);
   labelImagen.setIcon(icono);
   }else{
    labelImagen.setIcon(null);
    ajs.DefectPreviewFoto(labelImagen, 50, 50);
   }  
   labelPrecio.setText(prodLogica.getPrecio(productos));
   }catch(Exception e){}
 }
}
