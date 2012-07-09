/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viveroreal.entities;
import java.io.Serializable;
import java.util.Date;
        
/**
 *
 * @author Elmer
 */
public class Factura implements Serializable{
    private int idFactura;
    private Date fecha;
    private int idClientes;
    private int idVentas;

    public Factura() {
    }

    public Factura(int idFactura, Date fecha, int idClientes, int idVentas) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.idClientes = idClientes;
        this.idVentas = idVentas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }
    
    
}
