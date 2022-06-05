package com.unab.Views;

import com.unab.Models.ViewModels.*;
import com.unab.Controllers.*;
import com.unab.Entities.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.*;
import javax.swing.table.TableRowSorter;

public class FrmMain extends javax.swing.JFrame {

    UserController userC = new UserController();
    User user = new User();
    UserVM userVM = new UserVM();
    RolController rolC = new RolController();
    Rol rol = new Rol();
    UserStateController userSC = new UserStateController();
    UserState userState = new UserState();
    FrmLogin logIn = new FrmLogin();
    DefaultTableModel dtm;
    TableRowSorter trs;
    EmployeControler employeC = new EmployeControler();
    Employee employe = new Employee();

    // matrices para capturar id de los cbx
    int rolId[];
    int statusId[];

    // variable para capturar id y actualizar o eliminar
    int idUserI = 0;

    //variables de session del usuario
    static int idUser;
//    static String userName;
//    static String stateName;
    static String rolName;
    static String eName;
//    static String eLastName;

    public FrmMain(String emple, String rolname) {

        initComponents();

        this.eName = emple;
        this.rolName = rolname;

        RolSecurity();
        lblUserName.setText(eName);

        LoadTbl();
        LoadCbxRol();
        LoadCbxUState();
        loadEploye();
    }

    //************************************************************************************************
    //  Cargar Imagenes
    public void LoadImage() {

//        LblPagar.setIcon(new ImageIcon("src/main/resources/Images/Pagos.png"));
//        LblUsuario.setIcon(new ImageIcon("src/main/resources/Images/usuario.png"));
//        LblEmpleados.setIcon(new ImageIcon("src/main/resources/Images/empleados.png"));
//        LblReportes.setIcon(new ImageIcon("src/main/resources/Images/reportes.png"));
//        LblCerrarS.setIcon(new ImageIcon("src/main/resources/Images/out24.png"));
    }

    //**********************************************************************************************
    // Seguridad con roles
    public void RolSecurity() {

        switch (rolName) {

            case "administrador" -> {
                BtnPagar1.setEnabled(true);
                BtnReportes1.setEnabled(true);
                BtnEmpleados.setEnabled(true);
                BtnUsuarios.setEnabled(true);
            }

            case "vendedor" ->
                BtnPagar1.setEnabled(true);

            default -> {
                BtnPagar1.setEnabled(false);
                BtnReportes1.setEnabled(false);
                BtnEmpleados.setEnabled(false);
                BtnUsuarios.setEnabled(false);
            }

        }

    }

    //**********************************************************************************************
    // Cargar Tabla Usuarios
    public void LoadTbl() {

        String Title[] = {"Id", "Nombre Usuario", "Contraseña", "Estado", "Rol"};
        /*DefaultTableModel*/ dtm = new DefaultTableModel(null, Title);
        var listUser = userC.ReadUser();
        Iterator it = listUser.iterator();
        String row[] = new String[5];

        while (it.hasNext()) {
            UserVM cttl = (UserVM) it.next();
            row[0] = Integer.toString(cttl.getId_user());
            row[1] = cttl.getUser_name();
            row[2] = cttl.getPassword();
            row[3] = cttl.getUser_state_name();
            row[4] = cttl.getRol_name();

            dtm.addRow(row);
        }
        tblUser.setModel(dtm);
    }
    
     public void loadEploye(){
       
       String Title[] = {"id_employee", "user_id", "employee_name", "employee_lastname", "e_identification_document", "phone", "email_address", "user_name" };
        DefaultTableModel dtl = new DefaultTableModel(null, Title);
        var listEmploye = employeC.ReadEmploye();
        Iterator it = listEmploye.iterator();
        String row[] = new String[10]; 
        
        while (it.hasNext()){
        EmployeMV ctt1 = (EmployeMV) it.next();
        row[0] = Integer.toString(ctt1.getIdEmployee());
        row[1] = Integer.toString(ctt1.getUser_id());
        row[2] = ctt1.getEmployee_name();
        row[3] = ctt1.getEmployee_Lastname();
        row[4] = ctt1.getE_identification_document();
        row[5] = ctt1.getPhone();
        row[6] = ctt1.getEmail_adrdess();
        row[7] = ctt1.getUser_name();
        dtl.addRow(row);
            
        }
    }

    //*********************************************************************************************
    // Filtrar Usuarios
    public void FilterUser() {

//        trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtFilter.getText(), 1));
        txtFilter.addKeyListener(new KeyAdapter() {

            public void keyReleased(final KeyEvent ke) {

                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtFilter.getText(), 1));
            }
        });

        trs = new TableRowSorter(tblUser.getModel());
        tblUser.setRowSorter(trs);
    }

    //*********************************************************************************************
    // Cargar Combobox Usuarios
    public void LoadCbxRol() {

        ArrayList<Rol> ListOfRol = rolC.ReadRol();
        Iterator iterator = ListOfRol.iterator();
        DefaultComboBoxModel defaultCbx = new DefaultComboBoxModel();
        defaultCbx.removeAllElements();
        cbxUserRol.removeAll();
        rolId = new int[ListOfRol.size()];

        int j = 0;
        while (iterator.hasNext()) {
            Rol rolU;
            rolU = (Rol) iterator.next();
            rolId[j] = rolU.getId_rol();

            defaultCbx.addElement(rolU.getRol_name());
            j++;

        }
        cbxUserRol.setModel(defaultCbx);
    }

    public void LoadCbxUState() {

        ArrayList<UserState> ListOfState = userSC.ReadUserState();
        Iterator iterator = ListOfState.iterator();
        DefaultComboBoxModel defaultCbx = new DefaultComboBoxModel();
        defaultCbx.removeAllElements();
        cbxUserState.removeAll();
        statusId = new int[ListOfState.size()];

        int j = 0;
        while (iterator.hasNext()) {
            UserState stateU;
            stateU = (UserState) iterator.next();
            statusId[j] = stateU.getId_user_state();

            defaultCbx.addElement(stateU.getUser_state_name());
            j++;

        }
        cbxUserState.setModel(defaultCbx);

    }

    //**********************************************************************************************************************
    // Habilitar botones en panel usuarios
    public void EnableAddU() {

        String uN = txtUserName.getText();
        String p = String.valueOf(txtPassword.getPassword());
        if (!uN.isEmpty() && !p.isEmpty()) {

            btnAddUser.setEnabled(true);

        } else {

            btnAddUser.setEnabled(false);
        }
    }

    public void EnableUpdateU() {

        String uN = txtUserName.getText();
        String p = String.valueOf(txtPassword.getPassword());
        if (!uN.isEmpty() && p.isEmpty() && idUserI != 0) {

            btnUpdateUser.setEnabled(true);

        } else {

            btnUpdateUser.setEnabled(false);
        }
    }

    //**********************************************************************************************************************
    // Limpiar Campos en panel de usuarios
    public void Clear() {

        idUserI = 0;
        txtUserName.setText("");
        txtPassword.setText("");
        cbxUserRol.removeAllItems();
        cbxUserState.removeAllItems();
        LoadCbxRol();
        LoadCbxUState();
        EnableAddU();
        EnableUpdateU();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        LblPagar1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        LblPagar2 = new javax.swing.JLabel();
        BtnCerrarS = new javax.swing.JButton();
        BtnPagar1 = new javax.swing.JButton();
        BtnReportes1 = new javax.swing.JButton();
        BtnEmpleados = new javax.swing.JButton();
        BtnUsuarios = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        btnClear1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtNameEm = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtUser_ID = new javax.swing.JTextField();
        txtApellidoEm = new javax.swing.JTextField();
        txtDocIdentificacion = new javax.swing.JTextField();
        txtNumTel = new javax.swing.JTextField();
        txtEmailEm = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbxUserState = new javax.swing.JComboBox<>();
        cbxUserRol = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        btnUpdateUser = new javax.swing.JButton();
        btnAddUser = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(60, 141, 188));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(34, 45, 49));
        jLabel3.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SAFER PAYMENT");
        jLabel3.setOpaque(true);
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 56));

        LblPagar1.setBackground(new java.awt.Color(54, 73, 80));
        LblPagar1.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        LblPagar1.setForeground(new java.awt.Color(255, 255, 255));
        LblPagar1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblPagar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        jPanel2.add(LblPagar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 148, 38, 41));

        jLabel9.setBackground(new java.awt.Color(34, 45, 49));
        jLabel9.setFont(new java.awt.Font("Yu Gothic Light", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 255, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Online");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 93, 163, 24));

        lblUserName.setBackground(new java.awt.Color(34, 45, 49));
        lblUserName.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(255, 255, 255));
        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUserName.setText("Nombre usuario");
        jPanel2.add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 63, 163, -1));

        jTextField2.setBackground(new java.awt.Color(54, 73, 80));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 148, 220, 41));

        LblPagar2.setBackground(new java.awt.Color(34, 45, 49));
        LblPagar2.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        LblPagar2.setForeground(new java.awt.Color(255, 255, 255));
        LblPagar2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblPagar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/usuarioM.png"))); // NOI18N
        jPanel2.add(LblPagar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 73, 38, 49));

        BtnCerrarS.setBackground(new java.awt.Color(60, 147, 188));
        BtnCerrarS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/out24.png"))); // NOI18N
        BtnCerrarS.setText("Cerrar Sesión");
        BtnCerrarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarSActionPerformed(evt);
            }
        });
        jPanel2.add(BtnCerrarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 310, 60));

        BtnPagar1.setBackground(new java.awt.Color(60, 147, 188));
        BtnPagar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pagos.png"))); // NOI18N
        BtnPagar1.setText("Pagar");
        BtnPagar1.setEnabled(false);
        BtnPagar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPagar1ActionPerformed(evt);
            }
        });
        jPanel2.add(BtnPagar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 310, 60));

        BtnReportes1.setBackground(new java.awt.Color(60, 147, 188));
        BtnReportes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reportes.png"))); // NOI18N
        BtnReportes1.setText("Reportes");
        BtnReportes1.setEnabled(false);
        BtnReportes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReportes1ActionPerformed(evt);
            }
        });
        jPanel2.add(BtnReportes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 310, 60));

        BtnEmpleados.setBackground(new java.awt.Color(60, 147, 188));
        BtnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/empleados.png"))); // NOI18N
        BtnEmpleados.setText("Empleados");
        BtnEmpleados.setEnabled(false);
        BtnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEmpleadosActionPerformed(evt);
            }
        });
        jPanel2.add(BtnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 310, 60));

        BtnUsuarios.setBackground(new java.awt.Color(60, 147, 188));
        BtnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/usuario.png"))); // NOI18N
        BtnUsuarios.setText("Usuarios");
        BtnUsuarios.setEnabled(false);
        BtnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUsuariosActionPerformed(evt);
            }
        });
        jPanel2.add(BtnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 310, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 710));

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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 920, -1));

        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SaferPaymentLogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 915, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(263, 263, 263))
        );

        jTabbedPane1.addTab("Principal", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 915, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel6);

        jPanel11.setBackground(new java.awt.Color(153, 204, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        btnClear1.setText("Limpiar");
        btnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Nombre ");

        jLabel14.setText("Documento de identificacion");

        jLabel15.setText("User ID");

        jLabel16.setText("Numero de telefono");

        jLabel17.setText("Emial Personal");

        jLabel18.setText("Apellido");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160)
                .addComponent(jLabel14)
                .addGap(173, 173, 173))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(txtNumTel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEmailEm, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(txtNameEm, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(txtApellidoEm, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(txtUser_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(txtDocIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel16)
                .addGap(167, 167, 167)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNameEm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoEm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDocIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUser_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNumTel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmailEm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton3.setBackground(new java.awt.Color(0, 102, 255));
        jButton3.setText("AGREGAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 204, 0));
        jButton5.setText("EDITAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setText("BORRAR");

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado"));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(515, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(281, 281, 281)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(221, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab3", jPanel7);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 915, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel8);

        jPanel9.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClear.setText("Limpiar");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Nombre de usuario");

        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserNameKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Contraseña");

        cbxUserState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxUserRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Estado del usuario");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Rol del usuario");

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(cbxUserState, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(cbxUserRol, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel7)
                        .addGap(306, 306, 306)
                        .addComponent(jLabel11))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxUserState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxUserRol, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado"));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Buscar  usuario:");

        txtFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFilterKeyTyped(evt);
            }
        });

        btnUpdateUser.setText("Actualizar");
        btnUpdateUser.setEnabled(false);
        btnUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateUserActionPerformed(evt);
            }
        });

        btnAddUser.setText("Agregar");
        btnAddUser.setEnabled(false);
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab5", jPanel9);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 920, 650));

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

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        Clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUserActionPerformed
        // TODO add your handling code here:

        try {
            int id_Rol = rolId[cbxUserRol.getSelectedIndex()];
            int iduser_state = statusId[cbxUserState.getSelectedIndex()];

            user.setRol_id(id_Rol);
            user.setUser_state_id(iduser_state);
            user.setUser_name(txtUserName.getText());
            user.setId_user(idUserI);

            userC.UpdateUser(user);
            LoadTbl();
            Clear();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error btnUpdateActionPerformed() " + e.toString());
        }

    }//GEN-LAST:event_btnUpdateUserActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        // TODO add your handling code here:
        try {

            int id_Rol = rolId[cbxUserRol.getSelectedIndex()];
            int iduser_state = statusId[cbxUserState.getSelectedIndex()];

            user.setRol_id(id_Rol);
            user.setUser_state_id(iduser_state);
            user.setUser_name(txtUserName.getText());
            user.setPassword(String.valueOf(txtPassword.getPassword()));

            userC.CreateUser(user);
            LoadTbl();
            Clear();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error btnAddActionPerformed() " + e.toString());
        }
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        // TODO add your handling code here:

        int row = tblUser.getSelectedRow();

        String idU = tblUser.getValueAt(row, 0).toString();
        String userName = tblUser.getValueAt(row, 1).toString();
        String state = tblUser.getValueAt(row, 3).toString();
        String r = tblUser.getValueAt(row, 4).toString();

        idUserI = Integer.valueOf(idU);
        txtUserName.setText(userName);
        cbxUserState.setSelectedItem(state);
        cbxUserRol.setSelectedItem(r);
        
        EnableAddU();
        EnableUpdateU();
    }//GEN-LAST:event_tblUserMouseClicked

    private void txtFilterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterKeyTyped

        FilterUser();

        /*txtFilter.addKeyListener(new KeyAdapter() {
            
            
            public void keyReleased(final KeyEvent ke){
                
                String u = (txtFilter.getText()); 
                txtFilter.setText(u);
                FilterUser();
            }
        });
        
        trs = new TableRowSorter(tblUser.getModel());
        tblUser.setRowSorter(trs);*/
    }//GEN-LAST:event_txtFilterKeyTyped

    private void BtnPagar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPagar1ActionPerformed
        FrmPago frmP = new FrmPago();
        frmP.setVisible(true);

    }//GEN-LAST:event_BtnPagar1ActionPerformed

    private void BtnCerrarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarSActionPerformed
        logIn.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_BtnCerrarSActionPerformed

    private void BtnReportes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReportes1ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_BtnReportes1ActionPerformed

    private void BtnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEmpleadosActionPerformed
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_BtnEmpleadosActionPerformed

    private void BtnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUsuariosActionPerformed
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_BtnUsuariosActionPerformed

    private void txtUserNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyReleased

        EnableAddU();
        EnableUpdateU();
    }//GEN-LAST:event_txtUserNameKeyReleased

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased

        EnableAddU();
        EnableUpdateU();
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {

            int iduser = 1;

            employe.setUser_id(iduser);
            employe.setEmployee_name(txtNameEm.getText());
            employe.setEmployee_Lastname(txtApellidoEm.getText());
            employe.setE_identification_document(txtDocIdentificacion.getText());
            employe.setPhone(txtNumTel.getText());
            employe.setEmail_adrdess(txtEmailEm.getText());

            employeC.CreateEmploye(employe);
            LoadTbl();
            Clear();
            loadEploye();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error btnAddActionPerformed() " + e.toString());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
                new FrmMain("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCerrarS;
    private javax.swing.JButton BtnEmpleados;
    private javax.swing.JButton BtnPagar1;
    private javax.swing.JButton BtnReportes1;
    private javax.swing.JButton BtnUsuarios;
    private javax.swing.JLabel LblPagar1;
    private javax.swing.JLabel LblPagar2;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClear1;
    private javax.swing.JButton btnUpdateUser;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxUserRol;
    private javax.swing.JComboBox<String> cbxUserState;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    public javax.swing.JLabel lblUserName;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtApellidoEm;
    private javax.swing.JTextField txtDocIdentificacion;
    private javax.swing.JTextField txtEmailEm;
    private javax.swing.JTextField txtFilter;
    private javax.swing.JTextField txtNameEm;
    private javax.swing.JTextField txtNumTel;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtUser_ID;
    // End of variables declaration//GEN-END:variables
}
