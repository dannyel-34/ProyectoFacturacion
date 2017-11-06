/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Usuario
 */
public class Empleado {
    
    private String cedula, nombre, apellido, fchnacim, direccion;

    public Empleado() {
    }

    public Empleado(String cedula, String nombre, String apellido, String fchnacim, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fchnacim = fchnacim;
        this.direccion = direccion;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
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
     * @return the fchnacim
     */
    public String getFchnacim() {
        return fchnacim;
    }

    /**
     * @param fchnacim the fchnacim to set
     */
    public void setFchnacim(String fchnacim) {
        this.fchnacim = fchnacim;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
    
    
}
