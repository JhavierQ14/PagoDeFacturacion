/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.unab.Views;

import com.unab.Entities.Tbl_metodo_pago;
import com.unab.Entities.Transaccion;
import com.unab.Entities.Transacction_detail;
import com.unab.Models.DAO.TransactionDAO;
import com.unab.Models.DAO.Transaction_DetailDAO;
import static com.unab.Views.FrmPago.NIC_TPF;
import static com.unab.Views.FrmPago.Transacciond;
import static com.unab.Views.FrmPago.lista;
import java.util.Iterator;

/**
 *
 * @author dead1
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        iniciado=0;
    }
static int iniciado;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jButton1)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jButton1)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          TransactionDAO td = new TransactionDAO();
          td.InsertarTransaccion(lista);
          Guardardetalles();
//          FrmPago frmp = new FrmPago();
//          frmp.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public void Guardardetalles(){
    FrmPago frm = new FrmPago();
    frm.guardardatos();
    frm.eliminarf();
    NIC_TPF.clear();
    Transacciond.clear();
//    Iterator iterador = Transacciond.iterator();
//    Transacction_detail tdl = new Transacction_detail();
//    while (iterador.hasNext()) {
//            Transaction_DetailDAO tdo = new Transaction_DetailDAO();
//            Transacction_detail td = (Transacction_detail) iterador.next();
//            tdl.setI_invoice_type(td.getI_invoice_type());
//            tdl.setDescription(td.getDescription());
//            tdl.setAmount(td.getAmount());
//            tdl.setUnit_price(td.getUnit_price());
//            tdl.setTransaction_id(td.getTransaction_id());
//            tdl.setIva(td.getIva());
//            tdl.setQuantity(td.getQuantity());
//            tdo.InsertarTransaccionD(tdl);
//        }
//    
    }
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
