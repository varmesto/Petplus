package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.DaoCitas;
import modelo.DaoMascotas;

/**
 * Servlet implementation class AltaCitaAction
 */
@WebServlet("/RegistrarCitaAction")
public class RegistrarCitaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoCitas daoC=new DaoCitas();
		
		LocalDate fecha=LocalDate.parse(request.getParameter("fechaCita"));
		LocalTime hora=LocalTime.parse(request.getParameter("horaCita"));
		LocalDateTime fechaCita=hora.atDate(fecha);
		//String nombreM=request.getParameter("nombreMascota");
		int idM=Integer.parseInt(request.getParameter("idMascota"));
		//int idC= (int) request.getSession().getAttribute("idCliente");
		
		//comprobar si la cita está reservada. Si es true-->pedir otra hora
		if(daoC.buscarCita(fechaCita)) {
			request.getRequestDispatcher("altaCita.jsp").forward(request, response);
		}else {
			daoC.altaCita(fechaCita, idM);
		}
	
        request.getRequestDispatcher("area-cliente.jsp").forward(request, response);	
	}

}
