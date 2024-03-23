/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;


import BOs.IRegistroLicenciaBO;
import BOs.RegistroLicenciaBO;
import Control.ControladorFlujo;
import Encriptacion.AlgoritmoEncriptacion;
import Entidades.Persona;
import Validaciones.Validaciones;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Carlo
 */
public class TramitarLicencia extends javax.swing.JFrame {

    ControladorFlujo controlador;
    private IRegistroLicenciaBO licencia = new RegistroLicenciaBO();
    private AlgoritmoEncriptacion aes = new AlgoritmoEncriptacion();
    private String existe = "PrimeraVez";
    
    
    /**
     * Creates new form TramitarLicencia
     */
    public TramitarLicencia() {
        initComponents();
        controlador = new ControladorFlujo();

        txtRFC.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarRFC();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarRFC();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarRFC();
            }
        });
        txtNombre.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarNombre();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarNombre();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarNombre();
            }
        });

        txtApellidoPaterno.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarApellidoPaterno();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarApellidoPaterno();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarApellidoPaterno();
            }
        });
        txtApellidoMaterno.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarApellidoMaterno();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarApellidoMaterno();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarApellidoMaterno();
            }
        });

        // Agregar DocumentListener al JTextField para el teléfono
        txtTelefono.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validarTelefono();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validarTelefono();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validarTelefono();
            }

        });
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtRFC = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtFechaN = new com.toedter.calendar.JDateChooser();
        botonVerificar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        DiscapacitadoSi = new javax.swing.JCheckBox();
        DiscapacitadoNo = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        cb1 = new javax.swing.JCheckBox();
        cb2 = new javax.swing.JCheckBox();
        cb3 = new javax.swing.JCheckBox();
        btnGenerar = new javax.swing.JButton();
        txtCosto = new javax.swing.JLabel();
        p1 = new javax.swing.JLabel();
        p2 = new javax.swing.JLabel();
        p3 = new javax.swing.JLabel();
        p4 = new javax.swing.JLabel();
        p5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 0, 51));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tramitar Licencia");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        btnMenu.setBackground(new java.awt.Color(204, 0, 51));
        btnMenu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Regresar al menú");
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Ingrese los siguientes datos:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("RFC:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Apellido Paterno:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Apellido Materno:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Fecha de nacimiento:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Telefono:");

        txtApellidoPaterno.setBackground(new java.awt.Color(204, 204, 204));
        txtApellidoPaterno.setEnabled(false);
        txtApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPaternoActionPerformed(evt);
            }
        });

        txtRFC.setBackground(new java.awt.Color(204, 204, 204));
        txtRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRFCActionPerformed(evt);
            }
        });

        txtNombre.setBackground(new java.awt.Color(204, 204, 204));
        txtNombre.setEnabled(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtTelefono.setBackground(new java.awt.Color(204, 204, 204));
        txtTelefono.setEnabled(false);
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        txtApellidoMaterno.setBackground(new java.awt.Color(204, 204, 204));
        txtApellidoMaterno.setEnabled(false);
        txtApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMaternoActionPerformed(evt);
            }
        });

        txtFechaN.setBackground(new java.awt.Color(204, 204, 204));
        txtFechaN.setForeground(new java.awt.Color(255, 255, 255));
        txtFechaN.setEnabled(false);

        botonVerificar.setBackground(new java.awt.Color(51, 153, 0));
        botonVerificar.setForeground(new java.awt.Color(255, 255, 255));
        botonVerificar.setText("Verificar RFC");
        botonVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerificarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("¿Es discapacitado?");

        DiscapacitadoSi.setText("SÍ");
        DiscapacitadoSi.setEnabled(false);
        DiscapacitadoSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscapacitadoSiActionPerformed(evt);
            }
        });

        DiscapacitadoNo.setText("No");
        DiscapacitadoNo.setEnabled(false);
        DiscapacitadoNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscapacitadoNoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("Elegir duracion de licencia:");

        cb1.setText("1 Año");
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });

        cb2.setText("2 Años");
        cb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb2ActionPerformed(evt);
            }
        });

        cb3.setText("3 Años");
        cb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb3ActionPerformed(evt);
            }
        });

        btnGenerar.setBackground(new java.awt.Color(51, 153, 0));
        btnGenerar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnGenerar.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerar.setText("GENERAR");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        txtCosto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCosto.setText("El costo será: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtApellidoPaterno)
                            .addComponent(txtNombre)
                            .addComponent(txtApellidoMaterno)
                            .addComponent(txtTelefono)
                            .addComponent(txtFechaN, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 110, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCosto)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(DiscapacitadoSi)
                                            .addGap(56, 56, 56)
                                            .addComponent(DiscapacitadoNo)
                                            .addGap(176, 176, 176))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addGap(113, 113, 113)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54)
                                        .addComponent(botonVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(99, 99, 99)
                                        .addComponent(cb1)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb2)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb3))
                                    .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(btnMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DiscapacitadoSi)
                            .addComponent(DiscapacitadoNo))
                        .addGap(54, 54, 54)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb1)
                            .addComponent(cb2)
                            .addComponent(cb3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtFechaN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)))))))
                .addGap(21, 21, 21)
                .addComponent(txtCosto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:

        dispose();
        controlador.mostrarVentanaPrincipal();

    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        if (!(txtRFC.getText().equalsIgnoreCase("")) && (cb1.isSelected() || cb2.isSelected() || cb3.isSelected())) {
        licencia.agregarLicencia(duracion(), licencia.consultarRFC(txtRFC.getText(), true));
        //logica que falta para la activacion de las licencias
        dispose();
        controlador.mostrarTramiteFinalizado();
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, verifica primero para continuar.", "Verifique campos", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        

//         if (existe.equals("Espera")) {
//            JOptionPane.showMessageDialog(this, "Por favor, verifica primero para continuar.", "Verifique campos", JOptionPane.ERROR_MESSAGE);
//        }
//        if (existe.equals("PrimeraVez")) {
//            if (!txtRFC.getText().isEmpty() && !txtNombre.getText().isEmpty()
//                    && txtFechaN.getDate() != null && !txtTelefono.getText().isEmpty()
//                    && (DiscapacitadoSi.isSelected() ^ DiscapacitadoNo.isSelected())
//                    && (cb1.isSelected() ^ cb2.isSelected() ^ cb3.isSelected())) {
//
//                if (txtRFC.getText().length() == 13 && txtTelefono.getText().length() == 10) {
//                    Date fechaActual = new Date();
//                    Date fechaNacimiento = txtFechaN.getDate();
//
//                    // Calcular la diferencia de años entre la fecha de nacimiento y la fecha actual
//                    long diff = fechaActual.getTime() - fechaNacimiento.getTime();
//                    long edadMillis = Math.abs(diff);
//                    int edad = (int) (edadMillis / (24 * 60 * 60 * 1000 * 365.25));
//
//                    // La variable 'edad' ahora contiene la edad de la persona
//                    System.out.println("Edad: " + edad + " años");
//
//                    if (txtFechaN.getDate().compareTo(fechaActual) < 0 && edad >= 18) {
//                       
//                        JOptionPane.showMessageDialog(this, "Se genero con exito la licencia de la \n RFC: " + txtRFC.getText(), "Licencia Generada", JOptionPane.INFORMATION_MESSAGE);
//                        ConfirmarTraLicencia cc = new ConfirmarTraLicencia();
//                        cc.setVisible(true);
//                        this.dispose();
//                    } else {
//                        JOptionPane.showMessageDialog(this, "Alguno de tus datos es erroneo debido a\n-Fecha nacimiento mayor a la actual.\n-Es menor de edad.", "Verifique campos", JOptionPane.ERROR_MESSAGE);
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(this, "Alguno de tus datos falta de completar\n-Telefono 10 digitos.\n-RFC 13 digitos.", "Verifique campos", JOptionPane.ERROR_MESSAGE);
//                }
//            } else {                
//                JOptionPane.showMessageDialog(this, "Por favor, verifica los campos y seleccione las opciones correctas.", "Verifique campos", JOptionPane.ERROR_MESSAGE);
//            }
//        }
 
    }//GEN-LAST:event_btnGenerarActionPerformed

    
    
    
    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed
        // TODO add your handling code here:

        if (cb1.isSelected()) {
            cb2.setSelected(false); // Deselecciona rb2 si rb1 está seleccionado
            cb3.setSelected(false); // Deselecciona rb3 si rb1 está seleccionado
            actualizaprecio();
        }

    }//GEN-LAST:event_cb1ActionPerformed

    private void cb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb2ActionPerformed
        // TODO add your handling code here:

        if (cb2.isSelected()) {
            cb1.setSelected(false); // Deselecciona rb1 si rb2 está seleccionado
            cb3.setSelected(false); // Deselecciona rb3 si rb2 está seleccionado
            actualizaprecio();
        }

    }//GEN-LAST:event_cb2ActionPerformed

    private void cb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb3ActionPerformed
        // TODO add your handling code here:
        if (cb3.isSelected()) {
            cb1.setSelected(false); // Deselecciona rb1 si rb3 está seleccionado
            cb2.setSelected(false); // Deselecciona rb2 si rb3 está seleccionado
            actualizaprecio();
        }
    }//GEN-LAST:event_cb3ActionPerformed

    private void DiscapacitadoSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscapacitadoSiActionPerformed
        // TODO add your handling code here:

        if (DiscapacitadoSi.isSelected()) {
            DiscapacitadoNo.setSelected(false); // Deselecciona NO si SI está seleccionado
            actualizaprecio();
        }
    }//GEN-LAST:event_DiscapacitadoSiActionPerformed

    private void DiscapacitadoNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscapacitadoNoActionPerformed
        // TODO add your handling code here:

        if (DiscapacitadoNo.isSelected()) {
            DiscapacitadoSi.setSelected(false); // Deselecciona Si si No está seleccionado
            actualizaprecio();
        }
    }//GEN-LAST:event_DiscapacitadoNoActionPerformed

    private void txtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCActionPerformed
    private void validarRFC() {
        String rfc = txtRFC.getText();

        if (Validaciones.validarRFC(rfc)) {
            p1.setText("<html><font color='green'>✓</font></html>");
        } else {
            p1.setText("<html><font color='red'>*</font></html>");
        }
    }
    private void validarNombre() {   
        String nombre = txtNombre.getText();
        if (Validaciones.validarNombre(nombre)) {
            p2.setText("<html><font color='green'>✓</font></html>");
        } else {
            p2.setText("<html><font color='red'>*</font></html>");
        }
    }
    private void validarApellidoPaterno() {       
        String ApellidoPaterno = txtApellidoPaterno.getText();
        if (Validaciones.validarApellidoPaterno(ApellidoPaterno)) {
            p3.setText("<html><font color='green'>✓</font></html>");
        } else {
            p3.setText("<html><font color='red'>*</font></html>");
        }

    }
    private void validarApellidoMaterno() { 
        String ApellidoMaterno = txtApellidoMaterno.getText();
        if (Validaciones.validarApellidoMaterno(ApellidoMaterno)) {
            p4.setText("<html><font color='green'>✓</font></html>");
        } else {
            p4.setText("<html><font color='red'>*</font></html>");
        }

    }
    private void validarTelefono() {
        String Telefono = txtTelefono.getText();
        if (Validaciones.validarTelefono(Telefono)) {
            p5.setText("<html><font color='green'>✓</font></html>");
        } else {
            p5.setText("<html><font color='red'>*</font></html>");
        }

    }


    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPaternoActionPerformed

    private void txtApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMaternoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void botonVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerificarActionPerformed
        Persona persona = licencia.consultarRFC(txtRFC.getText(), licencia.verificarRFC(txtRFC.getText()));
        if (persona != null) {
            try{
            txtRFC.enable(false);
            txtNombre.setText(aes.decrypt(persona.getNombre()));
            txtApellidoPaterno.setText(aes.decrypt(persona.getApellidoPaterno()));
            txtApellidoMaterno.setText(aes.decrypt(persona.getApellidoMaterno()));
            txtFechaN.setCalendar(persona.getFechaNacimiento());
            txtTelefono.setText(aes.decrypt(persona.getTelefono()));
            if (persona.isDiscapacitado()) {
            DiscapacitadoSi.setSelected(true);    
            }else{
                DiscapacitadoNo.setSelected(true);
            }
            }catch(Exception e){
                
            }
            
        }
    }//GEN-LAST:event_botonVerificarActionPerformed

    //FUTUROS METODOS A UTILIZAR
    public void actualizaprecio() {
        if (DiscapacitadoSi.isSelected()) {
            if (cb1.isSelected()) {
                txtCosto.setText("El costo de la licencia sera de $200");
            }
            if (cb2.isSelected()) {
                txtCosto.setText("El costo de la licencia sera de $500");
            }
            if (cb3.isSelected()) {
                txtCosto.setText("El costo de la licencia sera de $700");
            }
        }
        if (DiscapacitadoNo.isSelected()) {
            if (cb1.isSelected()) {
                txtCosto.setText("El costo de la licencia sera de $600");
            }
            if (cb2.isSelected()) {
                txtCosto.setText("El costo de la licencia sera de $900");
            }
            if (cb3.isSelected()) {
                txtCosto.setText("El costo de la licencia sera de $1100");
            }
        }
    }
    public int duracion(){
        if (cb1.isSelected()) {
            return 1;
        }else if(cb2.isSelected()){
            return 2;     
       }else{
            return 3;
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox DiscapacitadoNo;
    private javax.swing.JCheckBox DiscapacitadoSi;
    private javax.swing.JButton botonVerificar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JCheckBox cb1;
    private javax.swing.JCheckBox cb2;
    private javax.swing.JCheckBox cb3;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel p1;
    private javax.swing.JLabel p2;
    private javax.swing.JLabel p3;
    private javax.swing.JLabel p4;
    private javax.swing.JLabel p5;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JLabel txtCosto;
    private com.toedter.calendar.JDateChooser txtFechaN;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
