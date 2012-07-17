/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viveroreal.dao;


import com.viveroreal.entities.Filtro;
import com.viveroreal.entities.Venta;
import com.viveroreal.interfaces.IDaoVentas;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elmer
 */
public class DAOVentas implements IDaoVentas{
    private Connection cn;

    public DAOVentas() {
        conectarse();
    }
    
    @Override
    public void conectarse() {
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/viveroreal?user=root&password=root");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void desconectarse() {
        try {
            this.cn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public ArrayList listarVentas(Filtro filtro) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int conteoVentas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void insertarVenta(Venta venta) {
        PreparedStatement st;
        int x=0;
        try{
            st = this.cn.prepareStatement
                    ("insert into venta(fecha, idcliente, idempresa, tipoventa, idempleado, numnotaremision, numfactura, numcreditofiscal) values(?,?,?,?,?,?,?,?)");
            st.setDate(1, venta.getFecha());
            st.setInt(2, venta.getIdClientes());
            st.setInt(3, venta.getIdEmpresa());
            st.setString(4, Character.toString(venta.getTipoVenta()));
            st.setInt(5, venta.getIdEmpleado());
            st.setInt(6, venta.getNumNotaRemision());
            st.setInt(7, venta.getNumFactura());
            st.setInt(8, venta.getNumCreditoFiscal());
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void modificarVenta(Venta venta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int correlativoFactura() {
        int numFactura=0;
        Venta venta;
        try{
            Statement st;
            ResultSet rs;
            st = this.cn.createStatement();
            rs = st.executeQuery("select numfactura from venta order by numfactura desc limit 1");
            while(rs.next()){
                numFactura = rs.getInt("numfactura");
            }
            rs.close();
            rs = null;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return numFactura;
    }

    @Override
    public int correlativoCreditoFiscal() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int correlativoNotaRemision() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
