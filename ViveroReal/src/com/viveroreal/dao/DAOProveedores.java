/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viveroreal.dao;
import com.viveroreal.entities.Proveedor;
import com.viveroreal.entities.Filtro;
import com.viveroreal.interfaces.IDaoProveedores;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Elmer
 */
public class DAOProveedores implements IDaoProveedores {
    private Connection cn;
    
    public DAOProveedores() {
        conectarse();
    }
    
    

    @Override
    public void conectarse() {
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/viveroreal?user=root&password=root");
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void desconectarse() {
        try{
            this.cn.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insertarProveedor(Proveedor proveedor) {
        PreparedStatement st;
        int x = 0;
        try{
            st = this.cn.prepareStatement
                    ("Insert into Proveedor(nombre, direccion, registro, telefono, celular, email, contacto, activo) values (?,?,?,?,?,?,?,?)");
            
            st.setString(1, proveedor.getNombre());
            st.setString(2, proveedor.getDireccion());
            st.setString(3, proveedor.getRegistro());
            st.setString(4, proveedor.getTelefono());
            st.setString(5, proveedor.getCelular());
            st.setString(6, proveedor.getEmail());
            st.setString(7, proveedor.getContacto());
            st.setBoolean(8, proveedor.getActivo());
            x = st.executeUpdate();
          
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void modificarProveedor(Proveedor proveedor) {
                PreparedStatement st;
        int x = 0;
        try{
            st = this.cn.prepareStatement
                    ("Update Proveedor set nombre=?, direccion=?, registro=?, telefono=?, celular=?, email=?, contacto=?, activo=? where idProveedor=?");
            st.setString(1, proveedor.getNombre());
            st.setString(2, proveedor.getDireccion());
            st.setString(3, proveedor.getRegistro());
            st.setString(4, proveedor.getTelefono());
            st.setString(5, proveedor.getCelular());
            st.setString(6, proveedor.getEmail());
            st.setString(7, proveedor.getContacto());
            st.setBoolean(8, proveedor.getActivo());
            st.setString(9, Integer.toString(proveedor.getIdProveedor()));
            x = st.executeUpdate();
          
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminarProveedor(Proveedor proveedor) {
        PreparedStatement st;
        int x = 0;
        try{
            st = this.cn.prepareStatement("Delete from Proveedor where idProveedor=?");
            System.out.println(Integer.toString(proveedor.getIdProveedor()));
            st.setString(1, Integer.toString(proveedor.getIdProveedor()));
            x = st.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList listarProveedores(Filtro filtro) {
        ArrayList listaProveedores = new ArrayList();
        Proveedor pr;
        try{
            Statement st;
            ResultSet rs;
            st = this.cn.createStatement();
            String sSql="Select idProveedor, nombre, direccion, registro, telefono, celular, email, contacto, activo from proveedor";
            String sSqlFiltro="";
            if (filtro.isBfiltro1()==true & filtro.isBfiltro2()==false ){
            sSqlFiltro=" where nombre = '" + filtro.getValor1() + "'";
            }else if (filtro.isBfiltro1()==false & filtro.isBfiltro2()==true){
            sSqlFiltro=" where registro = '" + filtro.getValor2() + "'";
            }else if (filtro.isBfiltro1()==true & filtro.isBfiltro2()==true){
                sSqlFiltro=" where nombre = '" + filtro.getValor1() + "' and registro = '" + filtro.getValor2() + "'";
            }
            sSql += sSqlFiltro;
            rs = st.executeQuery(sSql);
            while(rs.next()){
                pr = new Proveedor(rs.getInt("idProveedor"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("registro"), rs.getString("telefono"), rs.getString("celular"), rs.getString("email"), rs.getString("contacto"), rs.getBoolean("activo"));
                listaProveedores.add(pr);
            }
            rs.close();
            rs = null;
        }catch (Exception e){
        System.out.println(e.getMessage());
        }
        return listaProveedores;
    }
    
    @Override
    public int conteoProveedores() {
        int x = 0;
        try{
            Statement st;
            ResultSet rs;
            st = this.cn.createStatement();
            rs = st.executeQuery("Select count(*) num from proveedor");
            while(rs.next()){
                x = rs.getInt("num");
            }
            rs.close();
            rs = null;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return x;
    }
    
}
