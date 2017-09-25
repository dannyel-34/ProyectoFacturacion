/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Operaciones {

    VistaLogin login = new VistaLogin();

    public void Ingresar(String usu, char clave[]) {

        String clavedef = new String(clave);

        if (usu.equals("Administrador") && clavedef.equals("123")) {
            this.login.dispose();
            JOptionPane.showMessageDialog(null, "Bienvenido\n"
                    + "Has ingresado satisfactoriamente al sistema", "Mensaje de bienvenida",
                    JOptionPane.INFORMATION_MESSAGE);
            VistaMenu menu = new VistaMenu();
            menu.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                    + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

}
