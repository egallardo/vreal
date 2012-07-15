/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viveroreal.dao;
import com.viveroreal.entities.Filtro;
import com.viveroreal.entities.Producto;
import com.viveroreal.entities.TipoXProducto;
import com.viveroreal.interfaces.IDaoProductos;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Elmer
 */
public class DAOProductos implements IDaoProductos{
    private Connection cn;

    public DAOProductos() {
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
        try{
            this.cn.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insertarProducto(Producto producto) {
        PreparedStatement st;
        int x=0;
        try{
            st = this.cn.prepareStatement
                    ("Insert into Producto(nombre, descripcion, tipo, precio, costo, existencia, activo) values(?,?,?,?,?,?,?)");
            st.setString(1, producto.getNombre());
            st.setString(2, producto.getDescripcion());
            st.setInt(3, producto.getTipo());
            st.setDouble(4, producto.getPrecio());
            st.setDouble(5, producto.getCosto());
            st.setInt(6, producto.getExistencia());
            st.setBoolean(7, producto.getActivo());
            x = st.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void modificarProducto(Producto producto) {
        PreparedStatement st;
        int x = 0;
        try{
            st = this.cn.prepareStatement
                    ("Update Producto set nombre=?, descripcion=?, tipo=?, precio=?, costo=?, existencia=?, activo=? where idProducto=?");
                        st.setString(1, producto.getNombre());
            st.setString(2, producto.getDescripcion());
            st.setInt(3, producto.getTipo());
            st.setDouble(4, producto.getPrecio());
            st.setDouble(5, producto.getCosto());
            st.setInt(6, producto.getExistencia());
            st.setBoolean(7, producto.getActivo());
            st.setInt(8, producto.getIdProducto());
            x = st.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminarProducto(Producto producto) {
        PreparedStatement st;
        int x=0;
        try{
            st = this.cn.prepareStatement("Delete from Producto Where idProducto=?");
            st.setInt(1, producto.getIdProducto());
            x = st.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList listarProductos(Filtro filtro) {
        ArrayList listaProductos = new ArrayList();
        Producto prod;
        try{
            Statement st;
            ResultSet rs;
            st = this.cn.createStatement();
            String sSql="Select idProducto, nombre, descripcion, tipo, precio, costo, existencia, activo from Producto";
            String sSqlFiltro="";
            if (filtro.isBfiltro1()==true & filtro.isBfiltro2()==false ){
                sSqlFiltro=" where idProducto = '" + filtro.getValor1() + "'";
            }else if (filtro.isBfiltro1()==false & filtro.isBfiltro2()==true){
                sSqlFiltro=" where nombre = '" + filtro.getValor2() + "'";
            }else if (filtro.isBfiltro1()==true & filtro.isBfiltro2()==true){
                sSqlFiltro=" where idProducto = '" + filtro.getValor1() + "' and nombre = '" + filtro.getValor2() + "'";
            }
            sSql += sSqlFiltro;
            rs = st.executeQuery(sSql);            
            while(rs.next()){
                prod = new Producto(rs.getInt("idProducto"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("tipo"), rs.getDouble("precio"), rs.getDouble("costo"), rs.getInt("existencia"), rs.getBoolean("activo"));
                listaProductos.add(prod);
            }
            rs.close();
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaProductos;
        }

    @Override
    public int conteoProductos() {
            int x=0;
    try{
        Statement st;
        ResultSet rs;
        st = this.cn.createStatement();
        rs = st.executeQuery("Select count(*) num from producto");
        while(rs.next()){
        x = rs.getInt("num");
        }
        rs.close();
        rs = null;
    } catch (Exception e) {
    }
    return x;
    }

    @Override
    public ArrayList listarTipoProducto() {
        ArrayList listaTipoProducto = new ArrayList();
        TipoXProducto tprod;     
        try{
            Statement st;
            ResultSet rs;
            st = this.cn.createStatement();
            rs = st.executeQuery("Select idTipoXProducto, nombre from tipoxproducto");
            while(rs.next()){
                tprod = new TipoXProducto(rs.getInt("idTipoXProducto"), rs.getString("nombre"));
                listaTipoProducto.add(tprod);
            }
            rs.close();
            rs = null;
        }
        catch(Exception e) {
            System.out.println("No se pudo obtener el Tipo de Producto!");
            System.out.println(e.getMessage());
        }
        return listaTipoProducto;
    }

    @Override
    public int conteoTipoProductos() {
        int x=0;
        try{
            Statement st;
            ResultSet rs;
            st = this.cn.createStatement();
            rs = st.executeQuery("Select count(*) num from tipoxproducto");
            while(rs.next()){
            x = rs.getInt("num");
            }
            rs.close();
            rs = null;
        } catch (Exception e) {
        }
        return x;
    }
}

