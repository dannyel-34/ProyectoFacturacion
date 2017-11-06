/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class GeneradorCodigos {
    
    Conexion con = new Conexion();

    ResultSet rs = null;
    Statement stm = null;
    
    public String generadorCodigoProducto(String nomtabla) {

        String codigo = "";

        try {
            String sql = "select nombretabla, numero from tblgenerador where nombretabla='" + nomtabla + "'";
            stm = con.conexion().createStatement();
            rs = stm.executeQuery(sql);

            if (rs.next()) {
                System.out.print(rs.getString(1));
                int indice = rs.getInt(2);

                if (indice > 0 && indice < 10) {
                    codigo = "PROD0000" + String.valueOf(indice);

                } else if (indice > 9 && indice < 100) {
                    codigo = "PR00" + String.valueOf(indice);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
        return codigo;
    }
    
    public boolean ActualizarCodigoProducto(String nomtabla){
        
        boolean ban = false;
        
        try{
            String sql = "update tblgenerador set numero=numero+1 where nombretabla='"+nomtabla+"'";
            stm = con.conexion().createStatement();
            int z = stm.executeUpdate(sql);
            
            if(z>0){
                ban=true;
            }
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
        return ban;
    }
}
