package com.unab.Views;

import com.unab.Entities.User;
import com.unab.Controllers.UserController;
import javax.swing.JOptionPane;

public class FrmUpdatePassword extends javax.swing.JFrame {
    
    User user = new User();
    UserController userC = new UserController();
    FrmMain frmMain;
    
    //variable para captura de id del usuario
    int idU = 0;
    
    public FrmUpdatePassword(int idUser, String UserName) {
        
        initComponents();
        
        this.idU = idUser;
        lblUserName.setText(UserName);
    }
    
    public void EnableBtnPass(){
        
        String p = String.valueOf(txtNewPassU.getPassword());
        String p1 = String.valueOf(txtComparePassU.getPassword());
        if (idU != 0 && !p.isEmpty() && !p1.isEmpty() && p.equals(p1)) {

            btnUpdatePasswordU.setEnabled(true);

        } else {

            btnUpdatePasswordU.setEnabled(false);
        }
    }
    
    public void ConfirmPass(){
        
        String p = String.valueOf(txtNewPassU.getPassword());
        String p1 = String.valueOf(txtComparePassU.getPassword());
        if (p.equals(p1)) {

            lblConfirmPass.setText("Su contraseña coincide");

        } else {

            lblConfirmPass.setText("");
        }
    }
    
    public void ClearDataPass(){
        
        idU = 0;
        txtNewPassU.setText("");
        txtComparePassU.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNewPassU = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        txtComparePassU = new javax.swing.JPasswordField();
        btnUpdatePasswordU = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblConfirmPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Ingrese su nueva contraseña");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        txtNewPassU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNewPassUKeyReleased(evt);
            }
        });
        jPanel1.add(txtNewPassU, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 250, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Comprueba su nueva contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        txtComparePassU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtComparePassUKeyReleased(evt);
            }
        });
        jPanel1.add(txtComparePassU, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 250, -1));

        btnUpdatePasswordU.setText("Modificar");
        btnUpdatePasswordU.setEnabled(false);
        btnUpdatePasswordU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePasswordUActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdatePasswordU, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Usuario :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        lblUserName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(0, 0, 0));
        lblUserName.setText("jLabel4");
        jPanel1.add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        lblConfirmPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblConfirmPass.setForeground(new java.awt.Color(0, 204, 51));
        lblConfirmPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 240, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNewPassUKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNewPassUKeyReleased
        
         EnableBtnPass();
    }//GEN-LAST:event_txtNewPassUKeyReleased

    private void txtComparePassUKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComparePassUKeyReleased
        
         EnableBtnPass();
         ConfirmPass();
    }//GEN-LAST:event_txtComparePassUKeyReleased

    private void btnUpdatePasswordUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePasswordUActionPerformed
        
        try {

            user.setPassword(String.valueOf(txtComparePassU.getPassword()));
            user.setId_user(idU);

            userC.ChangePasswordU(user);
//            frmMain.LoadTblUser();
            ClearDataPass();
            this.dispose();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error btnUpdateActionPerformed() " + e.toString());
        }
    }//GEN-LAST:event_btnUpdatePasswordUActionPerformed

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
            java.util.logging.Logger.getLogger(FrmUpdatePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUpdatePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUpdatePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUpdatePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUpdatePassword(0,"").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdatePasswordU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblConfirmPass;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPasswordField txtComparePassU;
    private javax.swing.JPasswordField txtNewPassU;
    // End of variables declaration//GEN-END:variables
}
