/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;


/**
 *
 * @author Usuario
 */
public class Conexiondb {
    Connection link = null;

    public Connection Conectar() {

        try {

            //Cargamos el Driver de MySQL
            Class.forName("org.gjt.mm.mysql.Driver");
            //Localhost: es la ubicacion de la base de datos,
            //db es el nombre de la base de datos en la cual hacemos conexion
            link = DriverManager.getConnection("jdbc:mysql://localhost/db_facturacion", "root", "");
            //JOptionPane.showMessageDialog(null, "Conexion Exitosa!");
            System.out.println("Conexión exitosa!");
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "No se puedo conectar ala base de datos", "Error"+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            System.out.printf("No se pudo conectar ala base de datos" +ex.getMessage());
        }

        return link;

    }
}
