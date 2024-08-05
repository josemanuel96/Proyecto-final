/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

/**
 *
 * @author mirym
 */
public class Menu_Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Menu_Inicio
     */
    public Menu_Inicio() {
        initComponents();
        //Esta parte del codigo nos pondra la ventana en el medio cuando abre;
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegistrarme = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblFondo_Menu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrarme.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnRegistrarme.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/nota 64px.png"))); // NOI18N
        btnRegistrarme.setText("Registrarme");
        btnRegistrarme.setContentAreaFilled(false);
        btnRegistrarme.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarme.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/nota 64px.png"))); // NOI18N
        btnRegistrarme.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/nota 128px.png"))); // NOI18N
        btnRegistrarme.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarme.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarmeActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarme, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 160));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/iniciar-sesion 64px.png"))); // NOI18N
        jButton2.setText("Iniciar Sesión");
        jButton2.setContentAreaFilled(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/iniciar-sesion 64px.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/iniciar-sesion 128px.png"))); // NOI18N
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, -1, 180));

        lblFondo_Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Fondo Menu Inicio.jpg"))); // NOI18N
        jPanel1.add(lblFondo_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Iniciar_Sesion ventana = new Iniciar_Sesion();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnRegistrarmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarmeActionPerformed
        Registrar_Usuarios ventana = new Registrar_Usuarios();
        ventana.setVisible(true);
        this.dispose();
         
    }//GEN-LAST:event_btnRegistrarmeActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarme;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo_Menu;
    // End of variables declaration//GEN-END:variables
}