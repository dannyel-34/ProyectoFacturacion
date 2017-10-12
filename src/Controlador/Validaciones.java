/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Usuario
 */
public class Validaciones {

    public boolean validarListaRol(String rol) {
        return rol.equals("Seleccione...");
    }

    public boolean validarListaTipoDocumento(String tipo) {
        return tipo.equals("Seleccione...");
    }

    public void solotexto(char letra, java.awt.event.KeyEvent evt) {
        if ((letra < 'a' || letra > 'z') && (letra < 'A' || letra > 'Z') && letra != KeyEvent.VK_BACKSPACE && letra != ' ') {
            JOptionPane.showMessageDialog(null, "Solo se permiten letras!!!", "Error", JOptionPane.ERROR_MESSAGE);
            evt.consume();

        }

    }

    public void solonumeros(char num, java.awt.event.KeyEvent evt) {
        if ((num < '0' || num > '9') && (num != KeyEvent.VK_BACKSPACE || num == ' ')) {
            JOptionPane.showMessageDialog(null, "Solo se permiten números!!!", "Error", JOptionPane.ERROR_MESSAGE);
            evt.consume();

        }

    }

    public boolean validarEmail(String mail) {

        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(mail);

        return matcher.matches();

    }

    public void validarTelefono(char letra, java.awt.event.KeyEvent evt, int num) {
        if (num < 7) {
            solonumeros(letra, evt);
        } else if (num >= 7 && num < 10) {
            JOptionPane.showMessageDialog(null, "El telefono ingresado debe ser de 7 digitos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

}
