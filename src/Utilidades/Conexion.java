/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Conexion {

    public Connection conexion = null;
    public PreparedStatement stm;
    public Statement stm2;

    public Connection conexion() {
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/facturacion", "root", "");
            //conexion = DriverManager.getConnection("jdbc:sqlserver://DANIELLE:1433;databaseName=FACTURACION", "sa", "123");
            System.out.println("Conexión exitosa!");//si no hubo ningun problema a comunicar la bd. nos imprime mensaje de caracteres.
        } catch (Exception ex) {
            System.out.printf("Error al conectarse a la base de datos" + ex.getMessage());
        }
        return conexion;
    }

    
    public void finalizar() throws SQLException {
        conexion.close();
    }
}
