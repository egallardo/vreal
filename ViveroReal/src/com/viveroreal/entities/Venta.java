/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viveroreal.entities;
import java.io.Serializable;
import java.sql.Date;
/**
 *
 * @author Elmer
 */
public class Venta implements Serializable{
    private int idVenta;
    private Date fecha;
    private int idClientes;
    private int idEmpresa;
    private char tipoVenta;
    private int idEmpleado;
    private int numNotaRemision;
    private int numFactura;
    private int numCreditoFiscal;

    public Venta() {
    }

    public Venta(int idVenta, Date fecha, int idClientes, int idEmpresa, char tipoVenta, int idEmpleado, int numNotaRemision, int numFactura, int numCreditoFiscal) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.idClientes = idClientes;
        this.idEmpresa = idEmpresa;
        this.tipoVenta = tipoVenta;
        this.idEmpleado = idEmpleado;
        this.numNotaRemision = numNotaRemision;
        this.numFactura = numFactura;
        this.numCreditoFiscal = numCreditoFiscal;
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

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getNumCreditoFiscal() {
        return numCreditoFiscal;
    }

    public void setNumCreditoFiscal(int numCreditoFiscal) {
        this.numCreditoFiscal = numCreditoFiscal;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public int getNumNotaRemision() {
        return numNotaRemision;
    }

    public void setNumNotaRemision(int numNotaRemision) {
        this.numNotaRemision = numNotaRemision;
    }

    public char getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(char tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

}