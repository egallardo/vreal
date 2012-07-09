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
public class FacturaDetalle implements Serializable{
    private int idFacturaDetalle;
    private int idFactura;
    private int idProducto;

    public FacturaDetalle() {
    }

    public FacturaDetalle(int idFacturaDetalle, int idFactura, int idProducto) {
        this.idFacturaDetalle = idFacturaDetalle;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdFacturaDetalle() {
        return idFacturaDetalle;
    }

    public void setIdFacturaDetalle(int idFacturaDetalle) {
        this.idFacturaDetalle = idFacturaDetalle;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    
}
