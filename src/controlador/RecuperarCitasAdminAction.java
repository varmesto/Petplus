package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cita;
import modelo.DaoCitas;

/**
 * Servlet implementation class RecuperarCitasAdminAction
 */
@WebServlet("/RecuperarCitasAdminAction")
public class RecuperarCitasAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoCitas gestion=new DaoCitas();
        List<Cita> citas=gestion.recuperarCita();
		request.getSession().setAttribute("citasAdmin", citas);
		
		request.getRequestDispatcher("Admin-ver-citas.jsp").forward(request, response);
	}

}
