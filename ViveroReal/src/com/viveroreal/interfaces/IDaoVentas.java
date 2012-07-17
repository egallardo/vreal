/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viveroreal.interfaces;

import com.viveroreal.entities.Filtro;
import com.viveroreal.entities.Venta;
import java.util.ArrayList;

/**
 *
 * @author Elmer
 */
public interface IDaoVentas {
    public void conectarse();
    
    public void desconectarse();
    
    public void insertarVenta(Venta venta);
    
    public void modificarVenta(Venta venta);
    
    public ArrayList listarVentas(Filtro filtro);
    
    public int conteoVentas();
    
    public int correlativoFactura();
    
    public int correlativoCreditoFiscal();
    
    public int correlativoNotaRemision();
}
