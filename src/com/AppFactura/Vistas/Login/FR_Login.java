/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AppFactura.Vistas.Login;

import com.AppFactura.Controllers.LoginDao;
import java.awt.MouseInfo;
import java.awt.Point;

/**
 *
 * @author Adrian
 */
public class FR_Login extends javax.swing.JFrame {
   private int ejex_X,eje_Y;Point  p;
    LoginDao daoLogin = new LoginDao();
    /**
     * Creates new form FR_Login
     */
    public FR_Login() {
        initComponents();initLogin();
    }
  
    private void initLogin(){
        setResizable(false);
        setLocationRelativeTo(null);
        cboPerfil.addItem("---- Seleccione su perfíl -----");
        cboPerfil.addItem("Administrador");
        cboPerfil.addItem("Vendedor");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrinicipal = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jSeparator1 = new javax.swing.JSeparator();
        cboPerfil = new org.edisoncor.gui.comboBox.ComboBoxRound();
        txtPassword = new org.edisoncor.gui.passwordField.PasswordFieldRectBackground();
        jSeparator2 = new javax.swing.JSeparator();
        btnIngresar = new org.edisoncor.gui.button.ButtonRound();
        btnCancelar = new org.edisoncor.gui.button.ButtonRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelPrinicipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrinicipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));

        panelHeader.setBackground(new java.awt.Color(51, 51, 255));
        panelHeader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        panelHeader.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelHeaderMouseDragged(evt);
            }
        });
        panelHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelHeaderMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Logín (Acceso al sistema)");

        lblSalir.setBackground(new java.awt.Color(255, 51, 51));
        lblSalir.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lblSalir.setForeground(new java.awt.Color(255, 255, 255));
        lblSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalir.setText("X");
        lblSalir.setToolTipText("Cerrar");
        lblSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSalir.setOpaque(true);
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/AppFactura/Imagenes/usuarios.png"))); // NOI18N
        jLabel3.setText("Perfíl : ");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/AppFactura/Imagenes/provedorr.png"))); // NOI18N
        jLabel4.setText("Usuario : ");

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/AppFactura/Imagenes/contraseñaa.png"))); // NOI18N
        jLabel5.setText("Password : ");

        txtUsuario.setColorDeBorde(new java.awt.Color(255, 255, 255));
        txtUsuario.setDescripcion("Nombre de usuario (Nick)");
        txtUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        cboPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        cboPerfil.setEditable(true);
        cboPerfil.setColorDeBorde(new java.awt.Color(255, 255, 255));

        txtPassword.setColorDeBorde(new java.awt.Color(255, 255, 255));
        txtPassword.setDescripcion("Password...");
        txtPassword.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        btnIngresar.setBackground(new java.awt.Color(0, 255, 153));
        btnIngresar.setText("Ingresar");
        btnIngresar.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N

        javax.swing.GroupLayout panelPrinicipalLayout = new javax.swing.GroupLayout(panelPrinicipal);
        panelPrinicipal.setLayout(panelPrinicipalLayout);
        panelPrinicipalLayout.setHorizontalGroup(
            panelPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrinicipalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrinicipalLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrinicipalLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(panelPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelPrinicipalLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelPrinicipalLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(15, 15, 15)
                        .addGroup(panelPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelPrinicipalLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        panelPrinicipalLayout.setVerticalGroup(
            panelPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrinicipalLayout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(panelPrinicipalLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(panelPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrinicipalLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrinicipalLayout.createSequentialGroup()
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(panelPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrinicipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrinicipalLayout.createSequentialGroup()
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelPrinicipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPrinicipalLayout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrinicipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrinicipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
    System.exit(0);
    }//GEN-LAST:event_lblSalirMouseClicked

    private void panelHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHeaderMousePressed
    ejex_X = evt.getX();
    eje_Y = evt.getY();
    }//GEN-LAST:event_panelHeaderMousePressed

    private void panelHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHeaderMouseDragged
    p = MouseInfo.getPointerInfo().getLocation();
    this.setLocation(p.x-ejex_X,p.y-eje_Y);
    }//GEN-LAST:event_panelHeaderMouseDragged

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
    String NameUser = txtUsuario.getText();
    String Pasword = txtPassword.getText();
    String Perfil = cboPerfil.getSelectedItem().toString();
    if(cboPerfil.getSelectedIndex()<=0){
     cboPerfil.grabFocus();
    }else{
    if(NameUser.isEmpty()){
    txtUsuario.grabFocus();
    }else{
    if(Pasword.isEmpty()){
    txtPassword.grabFocus();
    }else{daoLogin.acceso(NameUser, Pasword, Perfil, this);}
    }
    }
    }//GEN-LAST:event_btnIngresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FR_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FR_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FR_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FR_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FR_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRound btnCancelar;
    private org.edisoncor.gui.button.ButtonRound btnIngresar;
    private org.edisoncor.gui.comboBox.ComboBoxRound cboPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelPrinicipal;
    private org.edisoncor.gui.passwordField.PasswordFieldRectBackground txtPassword;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtUsuario;
    // End of variables declaration//GEN-END:variables
}
