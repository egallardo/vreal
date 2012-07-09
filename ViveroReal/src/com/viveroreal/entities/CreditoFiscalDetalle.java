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
public class CreditoFiscalDetalle implements Serializable {
    private int idCreditoFiscalDetalle;
    private int idCreditoFiscal;
    private int idProducto;

    public CreditoFiscalDetalle() {
    }

    public CreditoFiscalDetalle(int idCreditoFiscalDetalle, int idCreditoFiscal, int idProducto) {
        this.idCreditoFiscalDetalle = idCreditoFiscalDetalle;
        this.idCreditoFiscal = idCreditoFiscal;
        this.idProducto = idProducto;
    }

    public int getIdCreditoFiscal() {
        return idCreditoFiscal;
    }

    public void setIdCreditoFiscal(int idCreditoFiscal) {
        this.idCreditoFiscal = idCreditoFiscal;
    }

    public int getIdCreditoFiscalDetalle() {
        return idCreditoFiscalDetalle;
    }

    public void setIdCreditoFiscalDetalle(int idCreditoFiscalDetalle) {
        this.idCreditoFiscalDetalle = idCreditoFiscalDetalle;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    
}
