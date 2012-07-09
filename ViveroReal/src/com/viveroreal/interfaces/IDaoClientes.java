/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viveroreal.interfaces;
import java.util.ArrayList;
import com.viveroreal.entities.Cliente;
import com.viveroreal.entities.Filtro;
/**
 *
 * @author Elmer
 */
public interface IDaoClientes {
    
    public void conectarse();
    
    public void desconectarse();
    
    public void insertarCliente(Cliente cliente);
    
    public void modificarCliente(Cliente cliente);
    
    public void eliminarCliente(Cliente cliente);
    
    public ArrayList listarClientes(Filtro filtro);
    
    public int conteoClientes();
}
