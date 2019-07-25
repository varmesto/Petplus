package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Mascota;
import modelo.DaoClientes;
import modelo.DaoMascotas;



@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoClientes gestion=new DaoClientes();
		DaoMascotas daoM=new DaoMascotas();
		
		if(gestion.autenticarCliente(request.getParameter("usuario"),request.getParameter("password"))){
			//recuperamos el idCliente, su nombre y su lista de mascotas y lo guardamos en atributos de sesión
			int idC=gestion.obtenerIdCliente(request.getParameter("usuario"),request.getParameter("password"));
			List<Mascota> mascotasList=daoM.obtenerMascotas(idC);
			String nombre = gestion.obtenerNombreCliente(request.getParameter("usuario"), request.getParameter("password"));
			
			request.getSession().setAttribute("idCliente", idC);
			request.getSession().setAttribute("mascotas", mascotasList);
			request.getSession().setAttribute("nombreCliente", nombre);
			request.getRequestDispatcher("area-cliente.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("inicia-sesion.html").forward(request, response);			
		}
	}
}