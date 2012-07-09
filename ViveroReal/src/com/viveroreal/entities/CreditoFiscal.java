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
public class CreditoFiscal implements Serializable {
    private int idCreditoFiscal;
    private Date fecha;
    private int idEmpresa;
    private int idVentas;

    public CreditoFiscal() {
    }

    public CreditoFiscal(int idCreditoFiscal, Date fecha, int idEmpresa, int idVentas) {
        this.idCreditoFiscal = idCreditoFiscal;
        this.fecha = fecha;
        this.idEmpresa = idEmpresa;
        this.idVentas = idVentas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdCreditoFiscal() {
        return idCreditoFiscal;
    }

    public void setIdCreditoFiscal(int idCreditoFiscal) {
        this.idCreditoFiscal = idCreditoFiscal;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }
    
    
}
