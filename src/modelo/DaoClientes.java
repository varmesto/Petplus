package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Cliente;

public class DaoClientes {
	String cadenaConexion="jdbc:mysql://localhost:3306/petplus";
	String user="root";
	String pwd="root";
	public DaoClientes() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean registrarCliente(String nombre, String apellidos, int telefono, String direccion, String email, String usuario, String password ) {
		boolean resultado=false;
		try(Connection cn=DriverManager.getConnection(cadenaConexion,this.user,this.pwd);) {                       
	           
            String sql="insert into clientes (nombre,apellidos,telefono,direccion,email,usuario,password) ";
            sql+="values(?,?,?,?,?,?,?)";
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
               //Sustituimos parametros por valores
               ps.setString(1, nombre);
               ps.setString(2, apellidos);
               ps.setInt(3, telefono);
               ps.setString(4, direccion);
               ps.setString(5, email);
               ps.setString(6,  usuario);
               ps.setString(7, password);
               //ejecutamos
             ps.execute();
             resultado=true;
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }  
		return resultado;
	}
	
	public int obtenerIdCliente(String usuario, String password) {
		int res=0;
		try(Connection cn=DriverManager.getConnection(cadenaConexion,this.user,this.pwd);){
			String sql="select * from clientes where usuario=? and password=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				res=rs.getInt("idCliente");
			}			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return res;
	}
	
	public List<Cliente> obtenerCliente(int idCliente) {
    	List<Cliente> listaCliente = new ArrayList<> ();
        try(Connection cn=DriverManager.getConnection(cadenaConexion,this.user,this.pwd);) { 
        	
        	String sql="select * from clientes where idCliente=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, idCliente);
            ResultSet rs=st.executeQuery();            
            if(rs.next()){
                listaCliente.add(new Cliente(rs.getInt("idCliente"),
					                         rs.getString("nombre"),
					                         rs.getString("Apellidos"),
					                         rs.getInt("telefono"),
					                         rs.getString("direccion"),
					                         rs.getString("email"),
					    					 rs.getString("usuario"),
					    					 rs.getString("password")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return listaCliente; 
    }
	
	public String obtenerNombreCliente(String usuario, String password) {
		String res="";
		try(Connection cn=DriverManager.getConnection(cadenaConexion,this.user,this.pwd);){
			String sql="select * from clientes where usuario=? and password=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				res=rs.getString("nombre");
			}			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return res;
	}
	
	
	public boolean autenticarCliente(String usuario, String password) {
		boolean res=false;
		try(Connection cn=DriverManager.getConnection(cadenaConexion,this.user,this.pwd);){
			String sql="select * from clientes where usuario=? and password=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				res=true;
			}			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return res;
	}
	
	public boolean eliminarCliente(int idCliente) {
		boolean resultado=false;
		try(Connection cn=DriverManager.getConnection(cadenaConexion,this.user,this.pwd);){
			String sql="delete from clientes where idCliente=? ";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setInt(1, idCliente);
			ps.execute();
			resultado=true; 		
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}
}
