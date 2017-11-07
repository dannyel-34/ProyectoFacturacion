/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

/**
 *
 * @author Usuario
 */
public class GenerarCodigo {

    private int dato, cont = 1;
    private String numero = "";

    public void generar_codigo(int codigoProducto) {
        this.dato = codigoProducto;

        if ((this.dato >= 1000) || (this.dato < 10000)) {
            int can = cont + this.dato;
            numero = "CP" + can;
        }
        if ((this.dato >= 100) || (this.dato < 1000)) {
            int can = cont + this.dato;
            numero = "CP0" + can;
        }
        if ((this.dato >= 9) && (this.dato < 100)) {
            int can = cont + this.dato;
            numero = "CP00" + can;
        }
        if ((this.dato >= 1) && (this.dato < 9)) {
            int can = cont + this.dato;
            numero = "CP000" + can;
        }
        if (this.dato == 0) {
            int can = cont + this.dato;
            numero = "CP000" + can;
        }

    }
    
    public String serie(){
        return this.numero;
    }

}
