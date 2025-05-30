package com.mycompany.proy_integ_4la;

import ORCLCONEXION.ConectarAOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import utiles.SesionUsuario;

public class Login extends javax.swing.JFrame {

    private final ConectarAOracle gestor = new ConectarAOracle();
    private final Connection conexion = gestor.abrir();

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Ingreso al sistema");
        
    }   
private void validarCredenciales() {
    String correo = PonerCorreo.getText();
    String contraseña = new String(PonerContraseña.getPassword());

    if (correo.trim().isEmpty() || contraseña.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.");
        return;
    }

    if (correo.equals("admin@example.com") && contraseña.equals("123")) {
        JOptionPane.showMessageDialog(this, "Bienvenido administrador.");
        new PanelAdministrador().setVisible(true);
        this.dispose();
        return;
    }

    try {
        String sql = "SELECT ID_Usuario FROM usuarios WHERE correo = ? AND contraseña = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, correo);
        ps.setString(2, contraseña);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            // Guardar el ID del usuario en la sesión
            SesionUsuario.idUsuario = rs.getInt("ID_Usuario");

            JOptionPane.showMessageDialog(this, "Bienvenido usuario.  " );
            new PanelUsuario().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas. Intente nuevamente.");
        }

        rs.close();
        ps.close();

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al verificar las credenciales: " + ex.getMessage());
        ex.printStackTrace();
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        TextoBienvenida = new javax.swing.JLabel();
        TextoCorreo = new javax.swing.JLabel();
        PonerCorreo = new javax.swing.JTextField();
        TextoContraseña = new javax.swing.JLabel();
        PonerContraseña = new javax.swing.JPasswordField();
        BotonEntrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextoBienvenida.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        TextoBienvenida.setText("SEAN BIENVENIDOS");
        jLayeredPane1.add(TextoBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        TextoCorreo.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        TextoCorreo.setText("CORREO:");
        jLayeredPane1.add(TextoCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));
        jLayeredPane1.add(PonerCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 250, 40));

        TextoContraseña.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        TextoContraseña.setText("CONTRASEÑA:");
        jLayeredPane1.add(TextoContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));
        jLayeredPane1.add(PonerContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 250, 40));

        BotonEntrar.setText("ENTRAR");
        BotonEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonEntrarMouseClicked(evt);
            }
        });
        BotonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEntrarActionPerformed(evt);
            }
        });
        jLayeredPane1.add(BotonEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 293, 120, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/login_final.png"))); // NOI18N
        jLayeredPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -4, 710, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEntrarMouseClicked
        validarCredenciales();
    }//GEN-LAST:event_BotonEntrarMouseClicked

    private void BotonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEntrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonEntrarActionPerformed
   
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEntrar;
    private javax.swing.JPasswordField PonerContraseña;
    private javax.swing.JTextField PonerCorreo;
    private javax.swing.JLabel TextoBienvenida;
    private javax.swing.JLabel TextoContraseña;
    private javax.swing.JLabel TextoCorreo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
