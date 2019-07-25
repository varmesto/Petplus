package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Mascota;


public class DaoMascotas {
	String cadenaConexion="jdbc:mysql://localhost:3306/petplus";
	String user="root";
	String pwd="root";
	public DaoMascotas() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean registrarMascota(String nombreMascota, String especie, String raza, String genero, double peso, double edad,
			int idCliente) {
		boolean resultado=false;
		try(Connection cn=DriverManager.getConnection(cadenaConexion,this.user,this.pwd);) {                       
	           
            String sql="insert into mascotas (nombreMascota,especie, raza, genero, peso, edad, idCliente) ";
            sql+="values(?,?,?,?,?,?,?)";
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
               //Sustituimos parámetros por valores
               ps.setString(1, nombreMascota);
               ps.setString(2, especie);
               ps.setString(3, raza);
               ps.setString(4, genero);
               ps.setDouble(5, peso);
               ps.setDouble(6, edad);
               ps.setInt(7, idCliente);    
               
               //ejecutamos
             ps.executeUpdate();
             ResultSet res=ps.getGeneratedKeys();
             if(res.next()) {
            	 System.out.println("clave "+res.getInt(1));
             }
            
             resultado=true;
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }  
		return resultado;
	}
	
	public List<Mascota> obtenerMascotas(int idCliente){
		List<Mascota> lista=new ArrayList<> ();
		try(Connection cn=DriverManager.getConnection(cadenaConexion,this.user,this.pwd);) {                       
	           
            String sql="select * from mascotas where idCliente=? ";
            PreparedStatement ps=cn.prepareStatement(sql);
               ps.setInt(1, idCliente);
               ResultSet rs=ps.executeQuery();
               while(rs.next()){
  	                lista.add(new Mascota(rs.getInt("idMascota"),
  	                					rs.getString("nombreMascota"),
  	                					rs.getString("especie"),
  	                					rs.getString("raza"),
  	                					rs.getString("genero"),
  	                					rs.getDouble("peso"),
  	                					rs.getDouble("edad"), 
  	                					rs.getInt("idCliente")));            
  	            } 
		}  catch (SQLException ex) {
			ex.printStackTrace();
		}  
		return lista;
	}
	
	public int obtenerIdMascota(String nombreMascota, int idCliente) {
		int res=0;
		try(Connection cn=DriverManager.getConnection(cadenaConexion,this.user,this.pwd);){
			String sql="select * from mascotas where nombreMascota=? and idCliente=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, nombreMascota);
			ps.setInt(2, idCliente);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				res=rs.getInt("idMascota");
			}			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return res;
	}
	
	public boolean eliminarMascota(int idMascota) {
		boolean resultado=false;
		try(Connection cn=DriverManager.getConnection(cadenaConexion,this.user,this.pwd);){
			String sql="delete from mascotas where idMascota=? ";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setInt(1, idMascota);
			ps.execute();
			resultado=true; 		
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}	
	
}

