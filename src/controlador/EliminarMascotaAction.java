package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Mascota;
import modelo.DaoMascotas;
import utilities.Utilidades;

/**
 * Servlet implementation class EliminarAction
 */
@WebServlet("/EliminarMascotaAction")
public class EliminarMascotaAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoMascotas gestionMascotas = new DaoMascotas();
		
		gestionMascotas.eliminarMascota(Integer.parseInt(request.getParameter("idMascota")));
	
        request.getRequestDispatcher("MostrarMascotaAction").forward(request, response);		
	}

}
