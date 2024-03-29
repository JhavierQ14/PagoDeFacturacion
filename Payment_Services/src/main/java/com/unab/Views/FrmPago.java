/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.unab.Views;

import com.unab.Entities.Factura_Datos;
import com.unab.Entities.Invoce_Type;
import com.unab.Entities.Tbl_metodo_pago;
import com.unab.Entities.Transaccion;
import com.unab.Entities.Transacction_detail;
import com.unab.Models.DAO.FacturaDAO;
import com.unab.Models.DAO.TipoFDAO;
import com.unab.Models.DAO.TransactionDAO;
import com.unab.Models.DAO.Transaction_DetailDAO;
import com.unab.Models.DAO.payment_methodDAO;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.ToDoubleFunction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dead1
 */
public class FrmPago extends javax.swing.JFrame {

    /**
     * Creates new form FrmPago
     */
    public FrmPago() {
        initComponents();
        NIC_TPF.clear();
        Transacciond.clear();
        txtMonto.setText("0");
        limpiardatos();
        Comboboxs();
        Completardatos();
    }

    /*----------------------------------------------------------------------------*/
    int ValuememberTF[];
    int ValuememberTP[];

    public void Comboboxs() {
        TipoFDAO tfd = new TipoFDAO();
        ArrayList<Invoce_Type> listadoF = tfd.ListarTiposFactura();
        Iterator iteradorF = listadoF.iterator();
        DefaultComboBoxModel DefaultComboBoxModelF = new DefaultComboBoxModel();
        DefaultComboBoxModelF.removeAllElements();
        cbTipoFactura.removeAll();
        String filasF[] = new String[2];

        ValuememberTF = new int[listadoF.size()];

        int contadorF = 0;
        while (iteradorF.hasNext()) {
            Invoce_Type InvoiceCls;
            InvoiceCls = (Invoce_Type) iteradorF.next();
            ValuememberTF[contadorF] = InvoiceCls.getId_invoice();
            DefaultComboBoxModelF.addElement(InvoiceCls.getI_type_name());
            contadorF++;
        }
        cbTipoFactura.setModel(DefaultComboBoxModelF);

        ////////////////////////////////////////////////////////////////////////
        payment_methodDAO pd = new payment_methodDAO();
        ArrayList<Tbl_metodo_pago> listadoM = pd.ListarMetodos();
        Iterator iteradorM = listadoM.iterator();
        DefaultComboBoxModel DefaultComboBoxModelM = new DefaultComboBoxModel();
        DefaultComboBoxModelM.removeAllElements();
        cbTipoPago.removeAll();
        String filasM[] = new String[2];

        ValuememberTP = new int[listadoM.size()];

        int contadorM = 0;
        while (iteradorM.hasNext()) {
            Tbl_metodo_pago metodop;
            metodop = (Tbl_metodo_pago) iteradorM.next();
            ValuememberTP[contadorM] = metodop.getIdTbl_Metodo_pago();
            DefaultComboBoxModelM.addElement(metodop.getTipo_Pago());
            contadorM++;
        }
        cbTipoPago.setModel(DefaultComboBoxModelM);
    }

    /*----------------------------------------------------------------------------*/
    public void Completardatos() {
        DecimalFormat df = new DecimalFormat("###.##");
        double iva = 13;
        String Tpagar = df.format(Double.valueOf(txtMonto.getText()) + (Double.valueOf(txtMonto.getText()) * (iva / 100)));

        String tpagart = String.valueOf(Tpagar);
        txtIva.setText(iva + "%");
        txtTotalPagar.setText(tpagart);

        TransactionDAO TD = new TransactionDAO();
        ArrayList listaT = TD.Listartransacciones();
        Iterator iterador = listaT.iterator();

        int cod_fact = 0;
        while (iterador.hasNext()) {
            Transaccion T = (Transaccion) iterador.next();

            cod_fact = (T.getIdTransaccion()) + 1;
            break;
        }
        N_Factura.setText(String.valueOf(cod_fact));
    }

    /*----------------------------------------------------------------------------*/
    public void bs(int nic) {

        int tdf = ValuememberTF[cbTipoFactura.getSelectedIndex()];

        FacturaDAO FDAO = new FacturaDAO();
        ArrayList<Factura_Datos> listado = FDAO.BuscarF(nic, tdf);
        Iterator iterador = listado.iterator();
        if (listado.size() != 0) {
            double suma = 0;
            int canfact = 0;
            while (iterador.hasNext()) {
                Factura_Datos dts = (Factura_Datos) iterador.next();
                canfact = canfact + 1;
                suma = suma + dts.getDeuda();
                txtMonto.setText(String.valueOf(suma));
                txtPagosPendientes.setText(String.valueOf(canfact));
                Completardatos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Factura no encontrada", "ERROR", 1);
        }

    }

    /*----------------------------------------------------------------------------*/
    static int idUser;
    static Transaccion lista;

    public void InsertarTransaccion() {
//        FrmMain frm= new FrmMain();
        Transaccion tc = new Transaccion();

        tc.setAmount_transaction(Double.valueOf(txtTAPagar.getText()));
        tc.setPayment_method_id(ValuememberTP[cbTipoPago.getSelectedIndex()]);
        tc.setTransaction_cod(Integer.valueOf(N_Factura.getText()));
        tc.setTransaction_type_id(1);
        tc.setUser_id(idUser);
        tc.setCliente(txtNombre.getText());
        lista = tc;
    }

    /*----------------------------------------------------------------------------*/
    static ArrayList<Transacction_detail> Transacciond = new ArrayList<Transacction_detail>();

    public void InsertarDetallesT() {
        Factura_Datos fd = new Factura_Datos();
        Transacction_detail td = new Transacction_detail();
        td.setTransaction_id(Integer.valueOf(N_Factura.getText()));
        td.setI_invoice_type(ValuememberTF[cbTipoFactura.getSelectedIndex()]);
        String iva = txtIva.getText();
        iva = iva.replace("%", "");
        td.setIva(Double.valueOf(iva));
        td.setQuantity(Integer.valueOf(txtPagosPendientes.getText()));
        td.setUnit_price(Double.valueOf(txtMonto.getText()));
        td.setAmount(Double.valueOf(txtTotalPagar.getText()));
        td.setDescription("Se realizo un pago de la factura con NIC: " + txtNIC.getText() + ",De una deuda de " + txtMonto.getText());
        fd.setNIC(Integer.valueOf(txtNIC.getText()));
        fd.setId_Invoice(ValuememberTF[cbTipoFactura.getSelectedIndex()]);
        NIC_TPF.add(fd);
        Transacciond.add(td);

    }

    /*----------------------------------------------------------------------------*/
    public void limpiardatos() {
        double iva = 13;
        txtIva.setText(iva + "%");
        txtMonto.setText("0");
        txtNIC.setText("");
        txtNombre.setText("");
        txtPagosPendientes.setText("0");
        txtTotalPagar.setText("0");

    }

    /*----------------------------------------------------------------------------*/
    static ArrayList<Factura_Datos> NIC_TPF = new ArrayList<Factura_Datos>();

    public void eliminarf() {
        FacturaDAO fd = new FacturaDAO();
        Iterator it = NIC_TPF.iterator();
        while (it.hasNext()) {
            Factura_Datos f = (Factura_Datos) it.next();
            System.out.println(f.getId_Invoice());
            System.out.println(f.getNIC());
            fd.EliminarFacturas(f.getNIC(), f.getId_Invoice());
        }
       
    }

    /*-----------------------------------------------------------------------------*/
    public void guardardatos() {
        Iterator iterador = Transacciond.iterator();
        Transacction_detail tdl = new Transacction_detail();
        while (iterador.hasNext()) {
            Transaction_DetailDAO tdo = new Transaction_DetailDAO();
            Transacction_detail td = (Transacction_detail) iterador.next();
            tdl.setI_invoice_type(td.getI_invoice_type());
            tdl.setDescription(td.getDescription());
            tdl.setAmount(td.getAmount());
            tdl.setUnit_price(td.getUnit_price());
            tdl.setTransaction_id(td.getTransaction_id());
            tdl.setIva(td.getIva());
            tdl.setQuantity(td.getQuantity());
            tdo.InsertarTransaccionD(tdl);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        N_Factura = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPagosPendientes = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        txtIva = new javax.swing.JTextField();
        txtTotalPagar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbTipoFactura = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFacturas = new javax.swing.JTable();
        txtNIC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbTipoPago = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtTAPagar = new javax.swing.JTextField();
        txtCambio = new javax.swing.JTextField();
        txtPagaCon = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        N_Factura.setEditable(false);

        jLabel1.setText("N° Factura");

        jLabel2.setText("Nombre");

        txtPagosPendientes.setEditable(false);

        txtMonto.setEditable(false);
        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });

        txtIva.setEditable(false);

        txtTotalPagar.setEditable(false);

        jLabel5.setText("Monto");

        jLabel6.setText("Iva");

        jLabel7.setText("pagos pendientes");

        jLabel8.setText("Total a pagar");

        cbTipoFactura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTipoFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoFacturaActionPerformed(evt);
            }
        });

        tblFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CLIENTE", "NIC", "PAGO SIN IVA", "PAGO CON IVA", "FACTURA DE "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFacturas);

        txtNIC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNICKeyTyped(evt);
            }
        });

        jLabel3.setText("NIC");

        cbTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtTAPagar.setEditable(false);
        txtTAPagar.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtTAPagar.setText("0.0");

        txtCambio.setEditable(false);
        txtCambio.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtCambio.setText("0.0");

        txtPagaCon.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtPagaCon.setText("0.0");
        txtPagaCon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPagaConKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagaConKeyTyped(evt);
            }
        });

        jLabel4.setText("TOTAL");

        jLabel9.setText("PAGA CON");

        jLabel10.setText("CAMBIO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(N_Factura, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbTipoPago, 0, 156, Short.MAX_VALUE)
                            .addComponent(cbTipoFactura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(btnBuscar)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPagosPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPagaCon)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCambio)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                .addGap(151, 151, 151))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(N_Factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbTipoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(cbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel5))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPagosPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPagaCon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnPagar))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbTipoFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoFacturaActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    /*----------------------------------------------------------------------------*/
 /*----------------------------------------------------------------------------*/
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        if (txtNIC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un NIC", "ERROR", 1);
        } else {

            double iva = 13;
            txtIva.setText(iva + "%");
            txtMonto.setText("0");
            txtPagosPendientes.setText("0");
            txtTotalPagar.setText("0");
            bs(Integer.valueOf(txtNIC.getText()));
//       
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    /*----------------------------------------------------------------------------*/
    public void limpiartabla() {
        int nf=NIC_TPF.size();
        while(nf>0){
        DefaultTableModel tb = (DefaultTableModel) tblFacturas.getModel();
        tb.removeRow(0);
        nf--;
        }
    }

    /*----------------------------------------------------------------------------*/
    public boolean comprobartabla() {

//        for (int i = 0; i < tblFacturas.getRowCount(); i++) {
//            String NIC = (String) tblFacturas.getValueAt(i, 1);
//            System.out.println(txtNIC.getText());
//            String TDF = (String) tblFacturas.getValueAt(i, 4);
//            System.out.println(cbTipoFactura.getSelectedItem());
////            if (NIC == txtNIC.getText() && TDF == cbTipoFactura.getSelectedItem()) {
////                existe = true;
////                if(existe==true){
////                break;
////                }
////            }
//
//        }
        boolean existe = false;

        Iterator it = NIC_TPF.iterator();
        while (it.hasNext()) {
            Factura_Datos f = (Factura_Datos) it.next();
            if (f.getNIC() == Integer.valueOf(txtNIC.getText()) && f.getId_Invoice() == ValuememberTF[cbTipoFactura.getSelectedIndex()]) {
                existe = true;
            }

        }

        return existe;
    }

    /*----------------------------------------------------------------------------*/
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
          
        if (!txtNombre.getText().isBlank()) {
            if (Integer.valueOf(txtPagosPendientes.getText()) != 0) {
                if (comprobartabla() == false) {
                    double TotalAPagar = 0;

                    DefaultTableModel df = (DefaultTableModel) tblFacturas.getModel();
                    String fila[] = new String[5];

                    fila[0] = txtNombre.getText();
                    fila[1] = txtNIC.getText();
                    fila[2] = txtMonto.getText();
                    fila[3] = txtTotalPagar.getText();
                    fila[4] = String.valueOf(cbTipoFactura.getSelectedItem());

                    df.addRow(fila);

                    tblFacturas.setModel(df);
                   
                    for (int i = 0; i < tblFacturas.getRowCount(); i++) {
                        
                        String tapg = (String) tblFacturas.getValueAt(i, 3);
                        TotalAPagar = TotalAPagar + (Double.valueOf(tapg));

                    }
                    DecimalFormat dft = new DecimalFormat("###.##");
                    txtTAPagar.setText(dft.format(TotalAPagar));
                    InsertarTransaccion();
                    InsertarDetallesT();
                    limpiardatos();
                } else {
                    txtPagosPendientes.setText("0");
                    txtMonto.setText("0");
                    txtTotalPagar.setText("0");
                    JOptionPane.showMessageDialog(null, "Factura ya agregada", "ERROR", 1);
                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "ERROR", 1);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Es necesario un nombre para agregar", "ERROR", 1);
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    /*----------------------------------------------------------------------------*/
 /*----------------------------------------------------------------------------*/
    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // TODO add your handling code here:

        if (NIC_TPF.size() != 0) {
            if (ValuememberTP[cbTipoPago.getSelectedIndex()] == 1) {
                TransactionDAO td = new TransactionDAO();
                td.InsertarTransaccion(lista);
                guardardatos();
                eliminarf();
                Completardatos();
                limpiartabla();
                NIC_TPF.clear();
                txtTAPagar.setText("0.0");
                txtCambio.setText("0.0");
                txtPagaCon.setText("0.0");
                
            } else {
                FrmBankCard fr = new FrmBankCard();
                fr.setVisible(true);
                this.dispose();
                
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se esta facturando nada", "ERROR", 1);

//        
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void txtPagaConKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagaConKeyPressed
//         TODO add your handling code here:
        DecimalFormat df = new DecimalFormat("###.##");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String cambio = df.format(Double.valueOf(txtPagaCon.getText()) - Double.valueOf(txtTAPagar.getText()));
            txtCambio.setText(cambio);
        }
    }//GEN-LAST:event_txtPagaConKeyPressed

    private void txtNICKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNICKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!", "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }
        if (k == 241 || k == 209) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!", "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }
        if (k == 10) {
            txtNIC.transferFocus();
        }
    }//GEN-LAST:event_txtNICKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Transacciond.clear();
        limpiardatos();
        limpiartabla();
        NIC_TPF.clear();
        txtTAPagar.setText("0.0");
        txtPagaCon.setText("0.0");
        txtCambio.setText("0.0");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPagaConKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagaConKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!", "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }
        if (k == 241 || k == 209) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!", "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }
        if (k == 10) {
            txtNIC.transferFocus();
        }
    }//GEN-LAST:event_txtPagaConKeyTyped

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
            java.util.logging.Logger.getLogger(FrmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField N_Factura;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JComboBox<String> cbTipoFactura;
    private javax.swing.JComboBox<String> cbTipoPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFacturas;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNIC;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPagaCon;
    private javax.swing.JTextField txtPagosPendientes;
    private javax.swing.JTextField txtTAPagar;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
}
