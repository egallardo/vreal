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
public class Proveedor implements Serializable {
    private int idProveedor;
    private String nombre;
    private String direccion;
    private String registro;
    private String telefono;
    private String celular;
    private String email;
    private String contacto;
    private Boolean activo;

    public Proveedor() {
    }

    public Proveedor(int idProveedor, String nombre, String direccion, String registro, String telefono, String celular, String email, String contacto, Boolean activo) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.registro = registro;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.contacto = contacto;
        this.activo = activo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    
}
