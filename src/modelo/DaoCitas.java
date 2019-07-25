package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import beans.Cita;

public class DaoCitas {
	String cadenaConexion="jdbc:mysql://localhost:3306/petplus";
	String user="root";
	String pwd="root";
	
	public DaoCitas() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean buscarCita(LocalDateTime fechaCita) {
		boolean resultado=false;
		try(Connection cn=DriverManager.getConnection(cadenaConexion,this.user,this.pwd);) { 					
			String sql="select * from citas where fechaCita=?";
		    PreparedStatement ps=cn.prepareStatement(sql);
		    //transformar  el objeto java.time.LocalDateTime en un java.sql.Date 
		    java.sql.Timestamp fechaSql=java.sql.Timestamp.valueOf(fechaCita); 
		   	ps.setTimestamp(1, fechaSql);
		   	ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				resultado=true;
			}	
		    }catch (SQLException ex) {
    		    ex.printStackTrace();
		   }  
		   return resultado;
		}
	
	
	public boolean altaCita(LocalDateTime fechaCita, int idMascota) {
		boolean resultado=false;
		try(Connection cn=DriverManager.getConnection(cadenaConexion,this.user,this.pwd);) { 
			
            String sql="insert into citas (fechaCita, idMascota) ";
            sql+="values(?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
           	//transformar  el objeto java.time.LocalDateTime en un java.sql.Date 
           	java.sql.Timestamp fechaSql=java.sql.Timestamp.valueOf(fechaCita); 
			ps.setTimestamp(1, fechaSql);
			ps.setInt(2, idMascota);
			ps.execute();
			resultado=true;           
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }  
		return resultado;
	}
	
	public boolean eliminarCita(int idCita) {
		boolean resultado=false;
		try(Connection cn=DriverManager.getConnection(cadenaConexion,this.user,this.pwd);) {                       	           
            String sql="delete from citas where idCita=? ";
            PreparedStatement ps=cn.prepareStatement(sql);
			ps.setInt(1, idCita);
  			ps.execute();
  			resultado=true;         
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }  
		return resultado;
	}
	
	
	public boolean eliminarCita(LocalDateTime fechaCita) {
		boolean resultado=false;
		try(Connection cn=DriverManager.getConnection(cadenaConexion,this.user,this.pwd);) {                       	           
            String sql="delete from citas where fechaCita=? ";
            PreparedStatement ps=cn.prepareStatement(sql);
            System.out.println(fechaCita);
            java.sql.Timestamp fechaSql=java.sql.Timestamp.valueOf(fechaCita); 
            System.out.println(fechaSql);
			ps.setTimestamp(1, fechaSql);
  			ps.execute();
  			resultado=true;         
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }  
		return resultado;
	}
	
	//Método eliminarCita por idMascota para borrar las citas que tiene un usuario cuando da de baja su perfil
	public boolean eliminarCitaBaja(int idMascota) {
		boolean resultado=false;
		try(Connection cn=DriverManager.getConnection(cadenaConexion,this.user,this.pwd);) {                       	           
            String sql="delete from citas where idMascota=? ";
            PreparedStatement ps=cn.prepareStatement(sql);
			ps.setInt(1, idMascota);
  			ps.execute();
  			resultado=true;         
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }  
		return resultado;
	}
	
	public List<Cita> recuperarCita(int idMascota){
    	List<Cita> lista=new ArrayList<> ();
        try(Connection cn=DriverManager.getConnection(cadenaConexion,this.user,this.pwd);) {                       
        	String sql="select * from citas where idMascota=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, idMascota);
            ResultSet rs=st.executeQuery();            
            while(rs.next()){
            	java.sql.Timestamp fechaCitaSql=rs.getTimestamp("fechaCita");
            	LocalDateTime fechaC=fechaCitaSql.toLocalDateTime();
                lista.add(new Cita(rs.getInt("idCita"),
                					fechaC,
                					rs.getInt("idMascota")));            
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return lista; 
    }
	
	public List<Cita> recuperarCita(){
    	List<Cita> lista=new ArrayList<> ();
        try(Connection cn=DriverManager.getConnection(cadenaConexion,this.user,this.pwd);) {                       
        	String sql="select * from citas ";
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();            
            while(rs.next()){
            	java.sql.Timestamp fechaCitaSql=rs.getTimestamp("fechaCita");
            	LocalDateTime fechaC=fechaCitaSql.toLocalDateTime();
                lista.add(new Cita(rs.getInt("idCita"),
                					fechaC,
                					rs.getInt("idMascota")));            
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return lista; 
    }	
	
}
