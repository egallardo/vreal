/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viveroreal.controller;

import com.viveroreal.dao.DAOVentas;
import com.viveroreal.entities.Filtro;
import com.viveroreal.entities.Venta;
import com.viveroreal.interfaces.IDaoVentas;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elmer
 */
public class ControllerVenta extends DefaultTableModel {
    private String data[][];
    private IDaoVentas daoventas = new DAOVentas();
    private ArrayList listaVentas;
    private Filtro filtro = new Filtro(false,false,"","");
    
    public ControllerVenta() {
    super();
    data=getRows();
    setDataVector(data,getCols());   
    }
    
    public String[][] getRows(){
         ArrayList lista;
        int numreg = 1;
        data=new String[numreg][5];
        
        try{
            for(int fila=0;fila<=numreg;fila++){
                data[fila][0] = "Hola";
                data[fila][1] = "esta";
                data[fila][2] = "es";
                data[fila][3] = "una";
                data[fila][4] = "prueba";
                
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return data;
    }
    
    public String[] getCols(){
        String[] Encabezados={new String("Código"), new String("Producto"), new String("Cantidad"), new String("Precio"), new String("Total")};
        return Encabezados;
    }
    
    public boolean isCellEditable(int row, int column){
        return true;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
    
    
    public void insertarVenta(Venta venta){
       daoventas.insertarVenta(venta);
    }
    public void modificarVenta(Venta venta){
        
    }

    public ArrayList getListaVentas() {
        this.listaVentas = daoventas.listarVentas(this.filtro);
        return listaVentas;
    }
    
    public int correlativoFactura(){
        int numFac = daoventas.correlativoFactura();
        return numFac;
    }

    public Filtro getFiltro() {
        return filtro;
    }

    public void setFiltro(Filtro filtro) {
        this.filtro = filtro;
    }
    
}
    
    
    
