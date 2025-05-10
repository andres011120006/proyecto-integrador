package com.mycompany.proy_integ_4la;

import ORCLCONEXION.ConectarAOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

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
            String consulta = "SELECT * FROM usuarios WHERE correo='" + correo + "' AND contraseña='" + contraseña + "'";
            PreparedStatement stmt = conexion.prepareStatement(consulta);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                JOptionPane.showMessageDialog(this, "Bienvenido usuario.");
                new PanelUsuario().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas. Intente nuevamente.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al verificar las credenciales: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        TextoBienvenida = new javax.swing.JLabel();
        TextoCorreo = new javax.swing.JLabel();
        TextoContraseña = new javax.swing.JLabel();
        PonerCorreo = new javax.swing.JTextField();
        BotonEntrar = new javax.swing.JButton();
        PonerContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fondo.setBackground(new java.awt.Color(51, 51, 255));

        TextoBienvenida.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        TextoBienvenida.setText("SEAN BIENVENIDOS");

        TextoCorreo.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        TextoCorreo.setText("CORREO:");

        TextoContraseña.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        TextoContraseña.setText("CONTRASEÑA:");

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

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(TextoBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PonerContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonEntrar)
                    .addComponent(TextoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PonerCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(TextoBienvenida)
                .addGap(28, 28, 28)
                .addComponent(TextoCorreo)
                .addGap(16, 16, 16)
                .addComponent(PonerCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TextoContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PonerContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonEntrar)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
    private javax.swing.JPanel Fondo;
    private javax.swing.JPasswordField PonerContraseña;
    private javax.swing.JTextField PonerCorreo;
    private javax.swing.JLabel TextoBienvenida;
    private javax.swing.JLabel TextoContraseña;
    private javax.swing.JLabel TextoCorreo;
    // End of variables declaration//GEN-END:variables
}
