/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofacturacion.Presentacion.Usuario;

import Utilidades.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import proyectofacturacion.Presentacion.VistaMenu;

/**
 *
 * @author Usuario
 */
public final class ListaUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form ListaUsuarios
     */
    Conexion con;

    public ListaUsuarios() {
        initComponents();
        this.setLocationRelativeTo(this);
        con = new Conexion();
        mostrarDatos("");
        btnmostrar.setEnabled(false);
    }

    public void mostrarDatos(String doc) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("USUARIO");
        modelo.addColumn("EMAIL");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("ROL");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("TIPO");

        tblusuarios.setModel(modelo);

        String sql = "";

        if (doc.equals("") && cbxTipo.getModel().getSelectedItem().toString().equals("Seleccione...")) {
            sql = "select * from tblusuario";
        } else {
            sql = "select * from tblusuario where nocedula='" + doc + "' AND tipodocumento='"
                    + cbxTipo.getSelectedItem().toString() + "'";
        }

        String[] datos = new String[7];

        try {
            Statement st = con.conexion().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString(1);//CEDULA
                datos[1] = rs.getString(2);//USUARIO
                datos[2] = rs.getString(3);//EMAIL
                datos[3] = rs.getString(5);//NOMBRE
                datos[4] = rs.getString(6);//ROL
                datos[5] = rs.getString(7);//APELLIDO
                datos[6] = rs.getString(8);//TIPO
                modelo.addRow(datos);
            }
            tblusuarios.setModel(modelo);
            modelo.addTableModelListener(new TableModelListener() {
                @Override
                public void tableChanged(TableModelEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

                    if (e.getType() == TableModelEvent.UPDATE) {
                        int columna = e.getColumn();
                        int fila = e.getFirstRow();

                        /**if (columna == 1) {
                            String sql = "update tblusuario set usuario='"
                                    + tblusuarios.getValueAt(fila, columna) + "' where nocedula='"
                                    + tblusuarios.getValueAt(fila, 0) + "' ";
                            try {
                                PreparedStatement stm = con.conexion().prepareStatement(sql);
                                stm.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Usuario Actualizado");
                                mostrarDatos("");
                            } catch (SQLException ex) {
                                Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }**/
                        String sql = "";
                        switch (columna) {
                            case 1:
                                sql = "update tblusuario set usuario='"
                                        + tblusuarios.getValueAt(fila, columna) + "' where nocedula='"
                                        + tblusuarios.getValueAt(fila, 0) + "' ";
                                try {
                                    PreparedStatement stm = con.conexion().prepareStatement(sql);
                                    stm.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "Usuario Actualizado");
                                    mostrarDatos("");
                                } catch (SQLException ex) {
                                    Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case 2:
                                sql = "update tblusuario set email='"
                                        + tblusuarios.getValueAt(fila, columna) + "' where nocedula='"
                                        + tblusuarios.getValueAt(fila, 0) + "' ";
                                try {
                                    PreparedStatement stm = con.conexion().prepareStatement(sql);
                                    stm.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "Email Actualizado");
                                    mostrarDatos("");
                                } catch (SQLException ex) {
                                    Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case 3:
                                sql = "update tblusuario set nombre='"
                                        + tblusuarios.getValueAt(fila, columna) + "' where nocedula='"
                                        + tblusuarios.getValueAt(fila, 0) + "' ";
                                try {
                                    PreparedStatement stm = con.conexion().prepareStatement(sql);
                                    stm.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "Nombre Actualizado");
                                    mostrarDatos("");
                                } catch (SQLException ex) {
                                    Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case 4:
                                sql = "update tblusuario set rol='"
                                        + tblusuarios.getValueAt(fila, columna) + "' where nocedula='"
                                        + tblusuarios.getValueAt(fila, 0) + "' ";
                                try {
                                    PreparedStatement stm = con.conexion().prepareStatement(sql);
                                    stm.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "Rol Actualizado");
                                    mostrarDatos("");
                                } catch (SQLException ex) {
                                    Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case 5:
                                sql = "update tblusuario set apellido='"
                                        + tblusuarios.getValueAt(fila, columna) + "' where nocedula='"
                                        + tblusuarios.getValueAt(fila, 0) + "' ";
                                try {
                                    PreparedStatement stm = con.conexion().prepareStatement(sql);
                                    stm.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "Apellido Actualizado");
                                    mostrarDatos("");
                                } catch (SQLException ex) {
                                    Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case 6:
                                sql = "update tblusuario set tipodocumento='"
                                        + tblusuarios.getValueAt(fila, columna) + "' where nocedula='"
                                        + tblusuarios.getValueAt(fila, 0) + "' ";
                                try {
                                    PreparedStatement stm = con.conexion().prepareStatement(sql);
                                    stm.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "Tipo de Identificacion Actualizado");
                                    mostrarDatos("");
                                } catch (SQLException ex) {
                                    Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion Invalida!");
                        }
                    }
                    
                    /**if(e.getType() == TableModelEvent.DELETE){
                        int columna = e.getColumn();
                        int fila = e.getFirstRow();
                    }**/
                    
                }
            });

        } catch (SQLException ex) {
            Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblusuarios = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnmostrar = new javax.swing.JButton();
        cbxTipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flat_seo2-29-20 (1).png"))); // NOI18N
        btnBuscar.setText("BUSCAR ");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblusuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblusuarios);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/system-log-out-32.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png"))); // NOI18N
        btnActualizar.setText("ELIMINAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");

        btnmostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/show.png"))); // NOI18N
        btnmostrar.setText("MOSTRAR TODOS");
        btnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmostrarActionPerformed(evt);
            }
        });

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Seleccione...", "Cédula de Ciudadanía.", "Cédula de Extranjería.", "Registro civil de nacimiento para menores de siete (7) años", "Tarjeta de identidad para mayores de siete (7) años", "NIT para personas jurídicas." }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxTipo, 0, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
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

    private void btnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmostrarActionPerformed
        mostrarDatos("");
    }//GEN-LAST:event_btnmostrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        mostrarDatos(txtbuscar.getText());
        btnmostrar.setEnabled(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        
        
        int fila = tblusuarios.getSelectedRow();
        String ced = "";
        ced = tblusuarios.getValueAt(fila, 0).toString();
        
        try {
            PreparedStatement stmt = con.conexion().prepareStatement("delete from tblusuario where nocedula='"+ced+"'");
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fila Eliminada");
            mostrarDatos("");
        } catch (SQLException ex) {
            Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Esta seguro de cerrar", "cerar",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            VistaMenu m = new VistaMenu();
            m.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnmostrar;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblusuarios;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
