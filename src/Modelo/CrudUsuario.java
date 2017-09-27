/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Vista.VistaLogin.jProgressBar1;
import Vista.VistaMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Usuario
 */
public class CrudUsuario {

    public Conexion con = new Conexion();
    public PreparedStatement stm;
    public Statement stm2;
    private Timer t;
    private ActionListener ac;
    int x = 0;
    private int codigo;
    private String nombre, apellido, email, clave, clave_confirm;

    /**
     * @return the con
     */
    public Conexion getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Conexion con) {
        this.con = con;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the clave_confirm
     */
    public String getClave_confirm() {
        return clave_confirm;
    }

    /**
     * @param clave_confirm the clave_confirm to set
     */
    public void setClave_confirm(String clave_confirm) {
        this.clave_confirm = clave_confirm;
    }

    public void InsertarUsuario(String rol, char[] clave1, char[] clave2,
            String nombre, String apellido, String email, String usu) throws SQLException {

        clave = new String(clave1);
        clave_confirm = new String(clave2);

        stm = con.link.prepareStatement("INSERT INTO USUARIO (CODIGO, NOMBRE, APELLIDO, EMAIL, USUARIO, CLAVE, CONFIRM_CLAVE) VALUES (?,?,?,?,?,?,?,?)");
        stm.setInt(1, codigo);
        stm.setString(2, nombre);
        stm.setString(3, apellido);
        stm.setString(4, email);
        stm.setString(5, usu);
        stm.setString(5, clave);
        stm.setString(6, clave_confirm);
        stm.execute();
        JOptionPane.showMessageDialog(null, "Los datos fueron guardados con éxito!");
    }

    /**
     * El Metodo Ingresar usuario recibe dos parametros, primer parametro un
     * String con el usuario y segundo parametro, un array de tipo char que
     * almacena el contenido de nuestra txtPassword( la clave), y luego lo
     * convertimos el array en un String
     */
    public void IngresarUsuario(String usuario, char clave[]) {

        String clavedef = new String(clave);

        if (usuario.equals("Admin") && clavedef.equals("123")) {
            VistaMenu m = new VistaMenu();
            m.dispose();
            ac = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    x++;
                    jProgressBar1.setValue(x);

                    if (jProgressBar1.getValue() == 200) {
                        m.dispose();
                        t.stop();
                    }
                }
            };
            t = new Timer(150, ac);
            t.start();
            m.dispose();
            JOptionPane.showMessageDialog(null, "Bienvenido\n"
                    + "Has ingresado satisfactoriamente al sistema", "Mensaje de bienvenida",
                    JOptionPane.INFORMATION_MESSAGE);

            m.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                    + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
