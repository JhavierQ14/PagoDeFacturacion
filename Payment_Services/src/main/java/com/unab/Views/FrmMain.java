
package com.unab.Views;

import javax.swing.ImageIcon;


public class FrmMain extends javax.swing.JFrame {


    public FrmMain() {
        initComponents();
        LoadImagen();
    }

    public void  LoadImagen() {
        
         LblPagar.setIcon(new ImageIcon("src/main/resources/Images/Pagos.png"));
        LblUsuario.setIcon(new ImageIcon("src/main/resources/Images/usuario.png"));
        LblEmpleados.setIcon(new ImageIcon("src/main/resources/Images/empleados.png"));
        LblReportes.setIcon(new ImageIcon("src/main/resources/Images/reportes.png"));
        LblCerrarS.setIcon(new ImageIcon("src/main/resources/Images/cerrarsesion.png"));
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LblUsuario = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LblEmpleados = new javax.swing.JLabel();
        LblPagar = new javax.swing.JLabel();
        LblCerrarS = new javax.swing.JLabel();
        LblCerrarSesion = new javax.swing.JLabel();
        LblReportes = new javax.swing.JLabel();
        LblPagar1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        LblEmpleadoOnline = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        LblPagar2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        LblImage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(60, 141, 188));

        jLabel2.setBackground(new java.awt.Color(34, 45, 49));
        jLabel2.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Reportes");

        jLabel3.setBackground(new java.awt.Color(34, 45, 49));
        jLabel3.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SAFER PAYMENT");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(34, 45, 49));
        jLabel4.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Usuarios");

        jLabel6.setBackground(new java.awt.Color(34, 45, 49));
        jLabel6.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Empleados");

        LblUsuario.setBackground(new java.awt.Color(34, 45, 49));
        LblUsuario.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        LblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        LblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel8.setBackground(new java.awt.Color(34, 45, 49));
        jLabel8.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Pagar ");

        LblEmpleados.setBackground(new java.awt.Color(34, 45, 49));
        LblEmpleados.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        LblEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        LblEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LblPagar.setBackground(new java.awt.Color(34, 45, 49));
        LblPagar.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        LblPagar.setForeground(new java.awt.Color(255, 255, 255));
        LblPagar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LblCerrarS.setBackground(new java.awt.Color(34, 45, 49));
        LblCerrarS.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        LblCerrarS.setForeground(new java.awt.Color(255, 255, 255));
        LblCerrarS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LblCerrarSesion.setBackground(new java.awt.Color(34, 45, 49));
        LblCerrarSesion.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        LblCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        LblCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblCerrarSesion.setText("Cerrar Sesión");

        LblReportes.setBackground(new java.awt.Color(34, 45, 49));
        LblReportes.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        LblReportes.setForeground(new java.awt.Color(255, 255, 255));
        LblReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LblPagar1.setBackground(new java.awt.Color(54, 73, 80));
        LblPagar1.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        LblPagar1.setForeground(new java.awt.Color(255, 255, 255));
        LblPagar1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblPagar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N

        jLabel9.setBackground(new java.awt.Color(34, 45, 49));
        jLabel9.setFont(new java.awt.Font("Yu Gothic Light", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 204, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Online");

        LblEmpleadoOnline.setBackground(new java.awt.Color(34, 45, 49));
        LblEmpleadoOnline.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        LblEmpleadoOnline.setForeground(new java.awt.Color(255, 255, 255));
        LblEmpleadoOnline.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblEmpleadoOnline.setText("Inicio de sesión en");

        jTextField2.setBackground(new java.awt.Color(54, 73, 80));

        LblPagar2.setBackground(new java.awt.Color(34, 45, 49));
        LblPagar2.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        LblPagar2.setForeground(new java.awt.Color(255, 255, 255));
        LblPagar2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblPagar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/usuarioM.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblEmpleadoOnline, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(LblPagar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LblReportes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                    .addComponent(LblUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LblEmpleados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LblPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblCerrarS, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LblCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(LblPagar2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(259, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LblEmpleadoOnline)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblPagar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LblEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LblCerrarS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addComponent(LblPagar2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(574, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(34, 45, 49));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        LblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SaferPaymentLogo.png"))); // NOI18N
        LblImage.setText("}");

        jLabel1.setFont(new java.awt.Font("Yu Gothic Light", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenidos/a ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(LblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(LblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblCerrarS;
    private javax.swing.JLabel LblCerrarSesion;
    private javax.swing.JLabel LblEmpleadoOnline;
    private javax.swing.JLabel LblEmpleados;
    private javax.swing.JLabel LblImage;
    private javax.swing.JLabel LblPagar;
    private javax.swing.JLabel LblPagar1;
    private javax.swing.JLabel LblPagar2;
    private javax.swing.JLabel LblReportes;
    private javax.swing.JLabel LblUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}