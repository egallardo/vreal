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
public class Filtro implements Serializable{
    private boolean bfiltro1;
    private boolean bfiltro2;

    private String valor1;
    private String valor2;

    
    public Filtro() {
    }

    public Filtro(boolean bfiltro1, boolean bfiltro2, String valor1, String valor2) {
        this.bfiltro1 = bfiltro1;
        this.bfiltro2 = bfiltro2;

        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public boolean isBfiltro1() {
        return bfiltro1;
    }

    public void setBfiltro1(boolean bfiltro1) {
        this.bfiltro1 = bfiltro1;
    }

    public boolean isBfiltro2() {
        return bfiltro2;
    }

    public void setBfiltro2(boolean bfiltro2) {
        this.bfiltro2 = bfiltro2;
    }

    public String getValor1() {
        return valor1;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    public String getValor2() {
        return valor2;
    }

    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }
    
}
