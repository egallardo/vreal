/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viveroreal.controller;

import com.viveroreal.dao.DAOProveedores;
import com.viveroreal.entities.Proveedor;
import com.viveroreal.entities.Filtro;
import com.viveroreal.interfaces.IDaoProveedores;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elmer
 */
public class ControllerProveedor extends DefaultTableModel {
    private int numreg = 0;
    private String data[][];
    private IDaoProveedores daoproveedores = new DAOProveedores();
    private ArrayList listaProveedores;
    private Filtro filtro = new Filtro(false, false, "", "");

    public ControllerProveedor() {
        super();
        data=getRows();
        setDataVector(data,getCols());
    }

    public String[][] getRows() {
        ArrayList lista;
        numreg = daoproveedores.conteoProveedores();
        data=new String[numreg][9];
        Proveedor pr;
        try{
            lista = daoproveedores.listarProveedores(this.filtro);
            this.listaProveedores = lista;
            for(int fila = 0; fila<numreg; fila++){
                pr = (Proveedor)lista.get(fila);
                data[fila][0] = Integer.toString(pr.getIdProveedor());
                data[fila][1] = pr.getNombre();
                data[fila][2] = pr.getDireccion();
                data[fila][3] = pr.getRegistro();
                data[fila][4] = pr.getTelefono();
                data[fila][5] = pr.getCelular();
                data[fila][6] = pr.getEmail();
                data[fila][7] = pr.getContacto();
                data[fila][8] = Boolean.toString(pr.getActivo());
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return data;
    }

    private Object[] getCols() {
                String[] Encabezados={new String("Código"),new String("Proveedor"),new String("Dirección"),new String("Registro"),new String("Telefono"),new String("Celular"),new String("Email"),new String("Contacto"), new String("Estado")};
        return Encabezados;
    }
    
     public boolean isCellEditable(int row, int column){
        return false;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex){
        return data[rowIndex][columnIndex];
    }
    
    public void agregarProveedor(Proveedor proveedor){
        daoproveedores.insertarProveedor(proveedor);
    }
    
    public void modificarProveedor(Proveedor proveedor){
        daoproveedores.modificarProveedor(proveedor);
    }
    
    public void eliminarProveedor(Proveedor proveedor){
        daoproveedores.eliminarProveedor(proveedor);
    }
    
    /**
     * @retorna la listaClientes
     * /
     */
    
    public ArrayList getListaProveedores() {
        return listaProveedores;
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
