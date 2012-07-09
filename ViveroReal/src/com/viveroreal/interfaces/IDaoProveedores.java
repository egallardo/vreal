/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viveroreal.interfaces;
import java.util.ArrayList;
import com.viveroreal.entities.Proveedor;
import com.viveroreal.entities.Filtro;
/**
 *
 * @author Elmer
 */
public interface IDaoProveedores {
    
    public void conectarse();
    
    public void desconectarse();
    
    public void insertarProveedor(Proveedor proveedor);
    
    public void modificarProveedor(Proveedor proveedor);
    
    public void eliminarProveedor(Proveedor proveedor);
    
    public ArrayList listarProveedores(Filtro filtro);
    
    public int conteoProveedores();
}
