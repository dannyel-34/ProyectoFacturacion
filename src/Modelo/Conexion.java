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
public class Conexion {

    Connection link = null;//variable de tipo connection 

    public Connection conexion() {

        try {

            // Se crea una instancia de la clase manejadora de mySQL(DriverManager)
            Class.forName("org.gjt.mm.mysql.Driver");

            // Se conecta con la base de datos
            link = DriverManager.getConnection("jdbc:mysql://localhost/dbfacturacion", "root", "");

            System.out.println("Conexión exitosa!");//si no hubo ningun problema a comunicar la bd. nos imprime mensaje de caracteres.
        } catch (Exception ex) {

            System.out.printf("Error al conectarse a la base de datos" + ex.getMessage());

        }

        return link;//Retornamos el resultado obtenido en la conexion.

    }
}
