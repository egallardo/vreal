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
public class Venta implements Serializable{
    private int idVenta;
    private int idFactura;
    private int idEmpleado;
    private char tipoVenta;
    private int idCreditoFiscal;

    public Venta() {
    }

    public Venta(int idVenta, int idFactura, int idEmpleado, char tipoVenta, int idCreditoFiscal) {
        this.idVenta = idVenta;
        this.idFactura = idFactura;
        this.idEmpleado = idEmpleado;
        this.tipoVenta = tipoVenta;
        this.idCreditoFiscal = idCreditoFiscal;
    }

    public int getIdCreditoFiscal() {
        return idCreditoFiscal;
    }

    public void setIdCreditoFiscal(int idCreditoFiscal) {
        this.idCreditoFiscal = idCreditoFiscal;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public char getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(char tipoVenta) {
        this.tipoVenta = tipoVenta;
    }
    
    
}
