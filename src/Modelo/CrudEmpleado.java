/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class CrudEmpleado {

    public Conexion con = new Conexion();
    public PreparedStatement stm;
    public Statement stm2;

    public void Insertar(String doc, String nombre, String apellido, String tel, String celular,
            String fecha_nacim, String sexo, String tipoDoc, String dir) throws SQLException {

        stm = con.conexion.prepareStatement("insert into tblempleado(nocedula, nombre, apellido, telefono, celular, fechanacimiento, genero, tipodoc, direccion) values(?,?,?,?,?,?,?,?,?)");
        stm.setString(1, doc);
        stm.setString(2, nombre);
        stm.setString(3, apellido);
        stm.setString(4, tel);
        stm.setString(5, celular);
        stm.setString(6, fecha_nacim);
        stm.setString(7, sexo);
        stm.setString(8, tipoDoc);
        stm.setString(9, dir);
        stm.execute();
        JOptionPane.showMessageDialog(null, "Los datos fueron guardados con éxito!", "OK",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
