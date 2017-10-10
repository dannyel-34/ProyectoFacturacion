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
   
    public void InsertarUsuario(String rol, char[] clave, 
            String usuario, String email) throws SQLException {

        String clavedef = new String(clave);

        stm = con.link.prepareStatement("INSERT INTO USUARIO (CODIGO, ROL, CLAVE, USUARIO, EMAIL) VALUES (?,?,?,?,?,)");
        stm.setString(2, rol);
        stm.setString(3, clavedef);
        stm.setString(4, usuario);
        stm.setString(5, email);
        stm.execute();
        JOptionPane.showMessageDialog(null, "Los datos fueron guardados con éxito!", "", JOptionPane.INFORMATION_MESSAGE);
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

                    if (jProgressBar1.getValue() == 100) {
                        m.dispose();
                        t.stop();
                    }
                }
            };
            t = new Timer(100, ac);
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
