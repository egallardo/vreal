/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viveroreal.interfaces;
import com.viveroreal.entities.Producto;
import com.viveroreal.entities.Filtro;
import java.util.ArrayList;
/**
 *
 * @author Elmer
 */
public interface IDaoProductos {
    public void conectarse();
    
    public void desconectarse();
    
    public void insertarProducto(Producto producto);
    
    public void modificarProducto(Producto producto);
    
    public void eliminarProducto(Producto producto);
    
    public ArrayList listarProductos(Filtro filtro);
    
    public int conteoProductos();
    
    public ArrayList listarTipoProducto();
    
    public int conteoTipoProductos();

}
