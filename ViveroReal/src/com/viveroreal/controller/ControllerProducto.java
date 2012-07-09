/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viveroreal.controller;

import com.viveroreal.dao.DAOProductos;
import com.viveroreal.entities.Producto;
import com.viveroreal.entities.Filtro;
import com.viveroreal.interfaces.IDaoProductos;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import java.lang.String;

/**
 *
 * @author Elmer
 */
public class ControllerProducto extends DefaultTableModel {
    private int numreg = 0;
    private String data[][];
    private IDaoProductos daoproductos = new DAOProductos();
    private ArrayList listaProductos;
    private ArrayList listaTipoProducto;
    private Filtro filtro = new Filtro(false,false,"","");

    public ControllerProducto() {
        super();
        data=getRows();
        setDataVector(data,getCols());
    }

    public String[][] getRows() {
        ArrayList lista;
        numreg = daoproductos.conteoProductos();
        data=new String[numreg][8];
        Producto prod;
        try{
            lista = daoproductos.listarProductos(this.filtro);
            this.listaProductos = lista;
            for(int fila=0;fila<numreg;fila++){
                prod = (Producto)lista.get(fila);
                data[fila][0] = Integer.toString(prod.getIdProducto());
                data[fila][1] = prod.getNombre();
                data[fila][2] = prod.getDescripcion();
                data[fila][3] = Integer.toString(prod.getTipo());
                data[fila][4] = Double.toString(prod.getPrecio());
                data[fila][5] = Double.toString(prod.getCosto());
                data[fila][6] = Integer.toString(prod.getExistencia());
                data[fila][7] = Boolean.toString(prod.getActivo());
            }
        }catch(Exception e){
                System.out.println(e.getMessage());
        }
        return data;
    }

    public String[] getCols() {
        String[] Encabezados={new String("Código"),new String("Nombre"),new String("Descripcion"),new String("Tipo"),new String("Precio"),new String("Costo"),new String("Existencia"), new String("Estado")};
        return Encabezados;    
    }
    
    public boolean isCellEditable(int row, int column){
        return false;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex){
        return data[rowIndex][columnIndex];
    }
    
    public void agregarProducto(Producto producto){
        daoproductos.insertarProducto(producto);
    }
    
    public void modificarProducto(Producto producto){
        daoproductos.modificarProducto(producto);
    }
    
    public void eliminarProducto(Producto producto){
        daoproductos.eliminarProducto(producto);
    }
    
    /**
     * @retorna la listaClientes
     * /
     */
    
    public ArrayList getListaProductos() {
        return listaProductos;
    }
    
    public String[] getListaTipoProductos(){
        listaTipoProducto = daoproductos.listarTipoProducto();
        String[] lista = null;

        //Iterator i = listaTipoProducto.iterator();
        
        //while(i.hasNext()){
        for(int i = 0; i < listaTipoProducto.size() ; i++){
            lista[i]= listaTipoProducto.get(i).toString();
        }
            //}
            
        return lista;
    }
    
    /**
     * @retorna el filtro
     */
    public Filtro getFiltro(){
        return filtro;
    }
    
    public void setFiltro(Filtro filtro) {
        this.filtro = filtro;
    }
}
