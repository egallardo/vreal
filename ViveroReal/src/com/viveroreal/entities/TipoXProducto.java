/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viveroreal.entities;

/**
 *
 * @author Elmer
 */
public class TipoXProducto {
    int idProducto;
    String nombre;

    public TipoXProducto() {
    }

    public TipoXProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public TipoXProducto(int idProducto, String nombre) {
        this.idProducto = idProducto;
        this.nombre = nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
