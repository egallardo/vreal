/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viveroreal.entities;
import java.io.Serializable;
/**
 *
 * @author Elmer
 */
public class Empresa implements Serializable {
    private int idEmpresa;
    private String nombre;
    private String registro;
    private String nit;

    public Empresa() {
    }

    public Empresa(int idEmpresa, String nombre, String registro, String nit) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.registro = registro;
        this.nit = nit;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
    
    
}
