 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viveroreal.dao;
import com.viveroreal.entities.Cliente;
import com.viveroreal.entities.Filtro;
import com.viveroreal.interfaces.IDaoClientes;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Elmer
 */
public class DAOClientes implements IDaoClientes {
    private Connection cn;

    public DAOClientes() {
        conectarse();
    }
    
    
    @Override
    public void conectarse() {
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/viveroreal?user=root&password=root");
        } catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void desconectarse() {
        try{
            this.cn.close();
        } catch(Exception e){
        }
    }

    @Override
    public void insertarCliente(Cliente cliente) {
        PreparedStatement st;
        
        int x = 0;
        try{
            st = this.cn.prepareStatement
("Insert into Cliente(nombres, apellidos, direccion, telefono, celular, email, activo) values (?,?,?,?,?,?,?)");
            //st.setString(1, Integer.toString(cliente.getIdCliente()));
            st.setString(1, cliente.getNombres());
            st.setString(2, cliente.getApellidos());
            st.setString(3, cliente.getDireccion());
            st.setString(4, cliente.getTelefono());
            st.setString(5, cliente.getCelular());
            st.setString(6, cliente.getEmail());
            st.setBoolean(7, cliente.getActivo());
            x = st.executeUpdate();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void modificarCliente(Cliente cliente) {
        PreparedStatement st;
        
        int x = 0;
        try{
            st = this.cn.prepareStatement
("Update Cliente set nombres=?, apellidos=?, direccion=?, telefono=?, celular=?, email=?, activo=? where idCliente=?");
            st.setString(1, cliente.getNombres());
            st.setString(2, cliente.getApellidos());
            st.setString(3, cliente.getDireccion());
            st.setString(4, cliente.getTelefono());
            st.setString(5, cliente.getCelular());
            st.setString(6, cliente.getEmail());
            st.setBoolean(7, cliente.getActivo());
            st.setString(8, Integer.toString(cliente.getIdCliente()));
            x = st.executeUpdate();
    }catch (Exception e) {
        System.out.println(e.getMessage());
    }
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        PreparedStatement st;
        int x=0;
        try{
            st = this.cn.prepareStatement("Delete from Cliente where idCliente=?");
            st.setString(1, Integer.toString(cliente.getIdCliente()));
            x = st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList listarClientes(Filtro filtro) {
        ArrayList listaClientes = new ArrayList();
        Cliente cl;
        try{
            Statement st;
            ResultSet rs;
            st = this.cn.createStatement();
            String sSql="Select idCliente, nombres, apellidos, direccion, telefono, celular, email, activo from cliente";
            String sSqlFiltro="";
            if (filtro.isBfiltro1()==true & filtro.isBfiltro2()==false ){
                sSqlFiltro=" where nombres = '" + filtro.getValor1() + "'";
            }else if (filtro.isBfiltro1()==false & filtro.isBfiltro2()==true){
                sSqlFiltro=" where apellidos = '" + filtro.getValor2() + "'";
            }else if (filtro.isBfiltro1()==true & filtro.isBfiltro2()==true){
                sSqlFiltro=" where nombres = '" + filtro.getValor1() + "' and apellidos = '" + filtro.getValor2() + "'";
            }
            sSql += sSqlFiltro;
            rs = st.executeQuery(sSql);            
            while(rs.next()){
                cl = new Cliente(rs.getInt("idCliente"), rs.getString("nombres"), rs.getString("apellidos"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("celular"), rs.getString("email"), rs.getBoolean("activo"));
                listaClientes.add(cl);
            }
            rs.close();
            rs = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaClientes;
    }

    @Override
    public int conteoClientes() {
        int x=0;
        try{
            Statement st;
            ResultSet rs;
            st = this.cn.createStatement();
            rs = st.executeQuery("Select count(*) num from cliente");
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
