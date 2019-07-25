package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.DaoCitas;

/**
 * Servlet implementation class EliminarCitaAction
 */
@WebServlet("/EliminarCitaAction")
public class EliminarCitaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoCitas daoCitas=new DaoCitas();
		
		//String fechaCita=request.getParameter("fechaCita");
		//System.out.println(fechaCita);
		//Convertir el String fecha en LocalDateTime
		//DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		//LocalDateTime fechaCitaLDT = LocalDateTime.parse(fechaCita, formatter);
		//System.out.println(fechaCitaLDT);
		//daoCitas.eliminarCita(fechaCitaLDT);
		
		//eliminamos citas por idCitay no por fecha para evitar problemas con Json con los formatos fecha
		daoCitas.eliminarCita(Integer.parseInt(request.getParameter("idCita")));
	
        request.getRequestDispatcher("ver-citas.jsp").forward(request, response);	
	}

}
