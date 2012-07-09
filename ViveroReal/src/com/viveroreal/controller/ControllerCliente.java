/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viveroreal.controller;

import com.viveroreal.dao.DAOClientes;
import com.viveroreal.entities.Cliente;
import com.viveroreal.entities.Filtro;
import com.viveroreal.interfaces.IDaoClientes;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Elmer
 */
public class ControllerCliente extends DefaultTableModel {
    private int numreg = 0;
    private String data[][];
    private IDaoClientes daoclientes = new DAOClientes();
    private ArrayList listaClientes;
    private Filtro filtro = new Filtro(false,false,"","");

    public ControllerCliente() {
        super();
        data=getRows();
        setDataVector(data,getCols());
    }
    
    public String[][] getRows(){
        ArrayList lista;
        numreg = daoclientes.conteoClientes();
        data=new String[numreg][8];
        Cliente cl;
        try{
            lista = daoclientes.listarClientes(this.filtro);
            this.listaClientes = lista;
            for(int fila=0;fila<numreg;fila++){
                cl = (Cliente)lista.get(fila);
                data[fila][0] = Integer.toString(cl.getIdCliente());
                data[fila][1] = cl.getNombres();
                data[fila][2] = cl.getApellidos();
                data[fila][3] = cl.getDireccion();
                data[fila][4] = cl.getTelefono();
                data[fila][5] = cl.getCelular();
                data[fila][6] = cl.getEmail();
                data[fila][7] = Boolean.toString(cl.getActivo());
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return data;
    }
    
    public String[] getCols(){
        String[] Encabezados={new String("Código"),new String("Nombres"),new String("Apellidos"),new String("Dirección"),new String("Telefono"),new String("Celular"),new String("Email"), new String("Estado")};
        return Encabezados;
    }
    
    public boolean isCellEditable(int row, int column){
        return false;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex){
        return data[rowIndex][columnIndex];
    }
    
    public void agregarCliente(Cliente cliente){
        daoclientes.insertarCliente(cliente);
    }
    
    public void modificarCliente(Cliente cliente){
        daoclientes.modificarCliente(cliente);
    }
    
    public void eliminarCliente(Cliente cliente){
        daoclientes.eliminarCliente(cliente);
    }
    
    /**
     * @retorna la listaClientes
     * /
     */
    
    public ArrayList getListaClientes() {
        return listaClientes;
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
