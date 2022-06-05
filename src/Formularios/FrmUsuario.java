/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.ConnectionClass;
import Clases.PDFClass;
import Clases.Reloj;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.TextField;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Samuel David Ortiz
 */
public class FrmUsuario extends javax.swing.JFrame {

    /**
     * Creates new form FrmUsuario
     */
    private boolean validador;
    private String mensaje;
    Reloj reloj = new Reloj();
    File archivo;
    private ImageIcon Img;
    private Icon icono;

    public FrmUsuario() {
        initComponents();

        reloj.setLblReloj(lblReloj);
        reloj.start();

        getContentPane().setBackground(new Color(174, 217, 224));
        pnlTitulo.setBackground(new Color(184, 242, 230));
        pnlUsuario.setBackground(new Color(174, 217, 224));
        pnlDatos.setBackground(new Color(174, 217, 224));
        pnlDatos1.setBackground(new Color(174, 217, 224));
        pnlBotones.setBackground(new Color(174, 217, 224));

        btnCrear.setBackground(new Color(250, 243, 221));
        btnCancelar.setBackground(new Color(250, 243, 221));

        btnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrear.setBackground(new Color(94, 100, 114));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrear.setBackground(new Color(250, 243, 221));
            }
        });

        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelar.setBackground(new Color(94, 100, 114));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelar.setBackground(new Color(250, 243, 221));
            }
        });

        //DatePicker dp = new DatePicker();
        this.txtCodigo.setText(generarCodigo());
        this.txtContra2.setVisible(false);
        this.lblContra2.setVisible(false);
    }

    private String generarCodigo() {
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyyMMddHHmmss");

        return DateFor.format(date);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlUsuario = new javax.swing.JPanel();
        pnlDatos = new javax.swing.JPanel();
        pnlDatos1 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblEspacio1 = new javax.swing.JLabel();
        lblEspacio2 = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        lblNombre2 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JTextField();
        lblApellido1 = new javax.swing.JLabel();
        txtApellido1 = new javax.swing.JTextField();
        lblApellido2 = new javax.swing.JLabel();
        txtApellido2 = new javax.swing.JTextField();
        lblNac = new javax.swing.JLabel();
        txtNac = new javax.swing.JTextField();
        lblTel = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        lblMail = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblContra1 = new javax.swing.JLabel();
        txtContra1 = new javax.swing.JPasswordField();
        lblContra2 = new javax.swing.JLabel();
        txtContra2 = new javax.swing.JPasswordField();
        lblImagen = new javax.swing.JLabel();
        chkUsuario = new javax.swing.JCheckBox();
        pnlBotones = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlTitulo = new javax.swing.JPanel();
        lblUMG = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblReloj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlDatos1.setLayout(new java.awt.GridLayout(6, 4, 10, 15));

        lblCodigo.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        lblCodigo.setText("Código");
        pnlDatos1.add(lblCodigo);

        txtCodigo.setEditable(false);
        pnlDatos1.add(txtCodigo);
        pnlDatos1.add(lblEspacio1);
        pnlDatos1.add(lblEspacio2);

        lblNombre1.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        lblNombre1.setText("Primer Nombre");
        pnlDatos1.add(lblNombre1);
        pnlDatos1.add(txtNombre1);

        lblNombre2.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        lblNombre2.setText("Segundo Nombre");
        pnlDatos1.add(lblNombre2);

        txtNombre2.setPreferredSize(new java.awt.Dimension(85, 29));
        pnlDatos1.add(txtNombre2);

        lblApellido1.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        lblApellido1.setText("Primer Apellido");
        pnlDatos1.add(lblApellido1);
        pnlDatos1.add(txtApellido1);

        lblApellido2.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        lblApellido2.setText("Segundo Apellido");
        pnlDatos1.add(lblApellido2);
        pnlDatos1.add(txtApellido2);

        lblNac.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        lblNac.setText("Fecha de Nacimiento");
        pnlDatos1.add(lblNac);
        pnlDatos1.add(txtNac);

        lblTel.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        lblTel.setText("Telefono");
        pnlDatos1.add(lblTel);
        pnlDatos1.add(txtTel);

        lblMail.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        lblMail.setText("Email");
        pnlDatos1.add(lblMail);
        pnlDatos1.add(txtMail);

        lblUsuario.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        lblUsuario.setText("Usuario");
        pnlDatos1.add(lblUsuario);
        pnlDatos1.add(txtUsuario);

        lblContra1.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        lblContra1.setText("Contraseña");
        pnlDatos1.add(lblContra1);

        txtContra1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContra1KeyReleased(evt);
            }
        });
        pnlDatos1.add(txtContra1);

        lblContra2.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        lblContra2.setText("Confirmar Contraseña");
        pnlDatos1.add(lblContra2);
        pnlDatos1.add(txtContra2);

        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pinwi.png"))); // NOI18N
        lblImagen.setToolTipText("Hacer click aquí para cargar la imagen de usuario");
        lblImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagenMouseClicked(evt);
            }
        });

        chkUsuario.setToolTipText("Selecciona para sugerir usuario");
        chkUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblImagen)
                .addGap(18, 18, 18)
                .addComponent(pnlDatos1, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                    .addGap(0, 1148, Short.MAX_VALUE)
                    .addComponent(chkUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(lblImagen))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlDatos1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDatosLayout.createSequentialGroup()
                    .addGap(247, 247, 247)
                    .addComponent(chkUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(78, Short.MAX_VALUE)))
        );

        pnlBotones.setLayout(new java.awt.GridBagLayout());

        btnCrear.setFont(new java.awt.Font("Dubai Medium", 1, 36)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.setPreferredSize(new java.awt.Dimension(200, 60));
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        pnlBotones.add(btnCrear, gridBagConstraints);

        btnCancelar.setFont(new java.awt.Font("Dubai Medium", 1, 36)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(200, 60));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 15);
        pnlBotones.add(btnCancelar, gridBagConstraints);

        javax.swing.GroupLayout pnlUsuarioLayout = new javax.swing.GroupLayout(pnlUsuario);
        pnlUsuario.setLayout(pnlUsuarioLayout);
        pnlUsuarioLayout.setHorizontalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioLayout.createSequentialGroup()
                .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlUsuarioLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlUsuarioLayout.setVerticalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUsuarioLayout.createSequentialGroup()
                .addContainerGap(386, Short.MAX_VALUE)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUsuarioLayout.createSequentialGroup()
                    .addContainerGap(12, Short.MAX_VALUE)
                    .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(145, 145, 145)))
        );

        pnlTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblUMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/umg.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Dubai Medium", 1, 48)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("CREAR NUEVO USUARIO");

        lblReloj.setBackground(new java.awt.Color(184, 242, 230));
        lblReloj.setFont(new java.awt.Font("Dubai Medium", 1, 36)); // NOI18N
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("00:00:00");
        lblReloj.setOpaque(true);

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUMG)
                .addGap(18, 18, 18)
                .addGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlTituloLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlTituloLayout.setVerticalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTituloLayout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblUMG, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(pnlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        new FrmLogin().setVisible(true);

        //borrarTextos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

        System.out.println("Hola");

        String pass = null;
        //ackgroundImage1 back = new BackgroundImage1();

        validarCampos();

        if (isValidador()) {
            if (String.valueOf(txtContra1.getPassword()).equals(String.valueOf(txtContra2.getPassword()))) {
                pass = String.valueOf(txtContra1.getPassword());

                try {
                    ConnectionClass cn = new ConnectionClass();
                    cn.conexion("proyectofinal", "develop", "abc123**");

                    String query = "INSERT INTO `proyectofinal`.`usuarios` (`codigo`, `nombre1`,`nombre2`,`apellido1`,`apellido2`,`fecha_nacimiento`,`usuario`,"
                            + " `contraseña`,`telefono`,`email`, url) VALUES("
                            + "'" + txtCodigo.getText() + "',"
                            + "'" + txtNombre1.getText() + "',"
                            + "'" + txtNombre2.getText() + "',"
                            + "'" + txtApellido1.getText() + "',"
                            + "'" + txtApellido2.getText() + "',"
                            + "'" + txtNac.getText() + "',"
                            + "'" + txtUsuario.getText() + "',"
                            + "'" + pass + "',"
                            + "'" + txtTel.getText() + "',"
                            + "'" + txtMail.getText() + "',"
                            + "'./src/Images/Fotos/U " + txtCodigo.getText() + ".jpg'"
                            + ");";

                    cn.insert(query);
                    int dialogButton = JOptionPane.YES_NO_OPTION;

                    JOptionPane.showConfirmDialog(null, "Usuario creado exitosamente\nDesea ver el codigo QR", "Usuario creado", dialogButton);

                    codigoQR("id:" + txtCodigo.getText() + ",usuario:" + txtUsuario.getText() + ",contraseña:" + pass);

                    FrmQR frmQr = new FrmQR(this.txtCodigo.getText());
                    if (dialogButton == 1) {
                        System.out.println("Mostar codigo QR");
                        //paintimages();

                        frmQr.setVisible(true);
                        //new FrmQR(this.txtCodigo.getText()).setVisible(true);
                    } else {
                        frmQr.setVisible(false);
                        frmQr.dispose();

                        borrarTextos();

                        System.out.println("No mostrar QR");
                    }

                    String nombre = this.txtNombre1.getText() + " " + this.txtNombre1.getText() + " " + this.txtApellido1.getText() + " "
                            + this.txtApellido2.getText();

                    PDFClass pdf = new PDFClass(this.txtCodigo.getText(), nombre, this.txtNac.getText());
                    pdf.crearPDF();

                    cn.close();

                } catch (Exception e) {

                }

            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden\nIntente de nuevo", "Adverventcia",
                        JOptionPane.WARNING_MESSAGE);

                this.txtContra1.requestFocus();
            }
        }

    }//GEN-LAST:event_btnCrearActionPerformed

    public static void resetTextFields(Container c) {
        Component[] components = c.getComponents();
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof Container) {
                resetTextFields((Container) components[i]);
            } else if (components[i] instanceof TextField) {
                ((TextField) components[i]).setText("");
            }
        }
    }

    public void codigoQR(String textoCodigo) {
        try {

            QRCodeWriter qrCode = new QRCodeWriter();
            BitMatrix bqr = qrCode.encode(textoCodigo, BarcodeFormat.QR_CODE.QR_CODE, 200, 200);
            Path pQr = FileSystems.getDefault().getPath("./src/Images/QR/" + txtCodigo.getText() + ".png");
            MatrixToImageWriter.writeToPath(bqr, "PNG", pQr);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }

    public void borrarTextos() {
        JTextField temp = null;
        JPasswordField temp2 = null;

        for (Component c : pnlDatos1.getComponents()) {
            if (c.getClass().toString().contains("javax.swing.JTextField")) {
                temp = (JTextField) c;
                temp.setText("");
            }
        }

        for (Component c : pnlDatos1.getComponents()) {
            if (c.getClass().toString().contains("javax.swing.JPasswordField")) {
                temp2 = (JPasswordField) c;
                temp2.setText("");
            }
        }

        this.txtCodigo.setText(generarCodigo());
        this.chkUsuario.setSelected(false);

        String rutaImagen = "./src/Images/pinwi.png";

        Img = new ImageIcon(rutaImagen);
        icono = new ImageIcon(Img.getImage().getScaledInstance(154, 178,
                Image.SCALE_DEFAULT));
        lblImagen.setIcon(icono);

    }

    private void txtContra1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContra1KeyReleased
        this.txtContra2.setVisible(true);
        this.lblContra2.setVisible(true);
    }//GEN-LAST:event_txtContra1KeyReleased

    private void chkUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkUsuarioActionPerformed
        String msgError = "";

        if (this.chkUsuario.isSelected()) {

            if (this.txtNombre1.getText().equals("")) {
                msgError = "El nombre esta en blanco";
            }

            if (this.txtApellido1.getText().equals("")) {
                msgError = "El apellido esta en blanco";
            }

            if (!msgError.equals("")) {
                JOptionPane.showMessageDialog(null, msgError, "Sugerir usuario", JOptionPane.ERROR_MESSAGE);
            } else {
                int largo = this.txtCodigo.getText().length();
                System.out.println("largo = " + largo);
                String sugerencia = this.txtCodigo.getText().substring(12);
                sugerencia = this.txtNombre1.getText().substring(0, 2) + this.txtApellido1.getText().substring(0, 2)
                        + sugerencia;
                sugerencia = sugerencia.toLowerCase();
                this.txtUsuario.setText(sugerencia);
            }

        } else {
            this.txtUsuario.setText("");
        }
    }//GEN-LAST:event_chkUsuarioActionPerformed

    private void lblImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenMouseClicked
        int input = JOptionPane.showConfirmDialog(null, "Desea tomar una foto desde la camara web?");

        if (input == 0) {
            new FrmCamara(this.txtCodigo.getText(), this.lblImagen).setVisible(true);
        } else {
            int resultado;

            FrmImagen buscador = new FrmImagen();
            FileNameExtensionFilter formato = new FileNameExtensionFilter("Archivos de imagen", "jpg", "png", "gif");

            buscador.jFileChooser1.setFileFilter(formato);
            resultado = buscador.jFileChooser1.showOpenDialog(null);

            if (JFileChooser.APPROVE_OPTION == resultado) {
                this.archivo = buscador.jFileChooser1.getSelectedFile();

                try {
                    ImageIcon Img = new ImageIcon(this.archivo.toString());

                    Icon icono = new ImageIcon(Img.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(),
                            Image.SCALE_DEFAULT));
                    lblImagen.setIcon(icono);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al abrir " + ex);
                }
            }
        }


    }//GEN-LAST:event_lblImagenMouseClicked

    public void validarCampos() {
        setMensaje("");
        setValidador(false);

        if (txtCodigo.getText().equals("")) {
            mensaje += "El campo " + lblCodigo.getText() + " no puede estar vacio.\n";
        }
        if (txtNombre1.getText().equals("")) {
            mensaje += "El campo " + lblNombre1.getText() + " no puede estar vacio.\n";
        }
        /*if (txtNombre2.getText().equals("")) {
            mensaje += "El campo " + lblNombre2.getText() + " no puede estar vacio.\n";
        }*/
        if (txtApellido1.getText().equals("")) {
            mensaje += "El campo " + lblApellido1.getText() + " no puede estar vacio.\n";
        }
        /*if (txtApellido2.getText().equals("")) {
            mensaje += "El campo " + lblApellido2.getText() + " no puede estar vacio.\n";
        }*/
        if (txtNac.getText().equals("")) {
            mensaje += "El campo " + lblNac.getText() + " no puede estar vacio.\n";
        }
        if (txtTel.getText().equals("")) {
            mensaje += "El campo " + lblTel.getText() + " no puede estar vacio.\n";
        }
        if (txtMail.getText().equals("")) {
            mensaje += "El campo " + lblMail.getText() + " no puede estar vacio.\n";
        }
        if (txtUsuario.getText().equals("")) {
            mensaje += "El campo " + lblUsuario.getText() + " no puede estar vacio.\n";
        }
        if (String.valueOf(txtContra1.getPassword()).equals("")) {
            mensaje += "El campo " + lblContra1.getText() + " no puede estar vacio.\n";
        }

        if (!mensaje.equals("")) {
            JOptionPane.showMessageDialog(null, "Error\n\n" + this.mensaje);
        } else {
            setValidador(true);
        }

    }

    public boolean isValidador() {
        return validador;
    }

    public void setValidador(boolean validador) {
        this.validador = validador;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JCheckBox chkUsuario;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblApellido2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblContra1;
    private javax.swing.JLabel lblContra2;
    private javax.swing.JLabel lblEspacio1;
    private javax.swing.JLabel lblEspacio2;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblNac;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblReloj;
    private javax.swing.JLabel lblTel;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUMG;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlDatos1;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JPanel pnlUsuario;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JPasswordField txtContra1;
    private javax.swing.JPasswordField txtContra2;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNac;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
