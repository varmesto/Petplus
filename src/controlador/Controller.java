package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		String url="index.html";
		switch(op) {
				
			case "doEliminarCita":
				url="EliminarCitaAction"; 
				break;
				
			case "doRecuperarCita":
				url="RecuperarCitaAction";
				break;
				
			case "doRecuperarCitasAdmin":
				url="RecuperarCitasAdminAction";
				break;
				
			case "doRegistrarCliente":
				url="RegistrarClienteAction";
				break;
				
			case "doRegistrarCita":
				url="RegistrarCitaAction"; 
				break;	
				
			case "doEliminarCliente":
				url="EliminarClienteAction";
				break;
			
			case "doVerDatosCliente":
				url="RecuperarDatosClienteAction";
				break;
				
			case "doLogin":
				url="LoginAction";
				break;
				
			case "doRegistrarMascota":
				url="RegistrarMascotaAction";
				break;
			
			case "doRecuperarMascotas":
				url="RecuperarMascotasAction";
				break;
				
			case "doEliminarMascota":
				url="EliminarMascotaAction";
				break;
			
			case "toRegistrarCliente":
				url="registrar-cliente.html";
				break;
				
			case "toInicia-Sesion":
				url="inicia-sesion.html";
				break;
				
			case "toIndex":
				url="index.html";
				break;
				
			case "toRegistrarCita":
				url="registrar-cita.jsp";
				break;
			
			case "toRecuperarCita":
				url="ver-citas.jsp";
				break;
				
			case "toAreaCliente":
				url="area-cliente.jsp";
				break;
				
			case "toRegistrarMascota":
				url="registrar-mascota.html";
				break;
			
			case "toVerMascotas":
				url="ver-mascotas.jsp";
				break;
				
			case "toServiciosPetPlus":
				url="servicios.html";
				break;
			
			case "toDondeEstamos":
				url="donde-estamos.html";
				break;
				
			case "toContacto":
				url="contacto.html";
				break;
				
			case "toVerDatosCliente":
				url="ver-datos-cliente.jsp";
				break;
				
			case "toAdmin":
				url="admin-gestion.jsp";
				break;
				
			case "toAviso":
				url="aviso-legal.jsp";
				break;
				
			case "toPolitica":
				url="politica-privacidad.jsp";
				break;
			case "toCookies":
				url="cookies.jsp";
				break;
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}

