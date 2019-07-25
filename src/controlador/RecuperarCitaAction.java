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
import utilities.Utilidades;

/**
 * Servlet implementation class RecuperarCitaAction
 */
@WebServlet("/RecuperarCitaAction")
public class RecuperarCitaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoCitas gestion=new DaoCitas();

        List<Cita> citas=gestion.recuperarCita(Integer.parseInt(request.getParameter("idMascota")));
        //lo estamos guardando como sesiòn pero no es sesión. Guardarlo como petiión??
		request.getSession().setAttribute("citas", citas);
		
		String respuestaJson=Utilidades.transformarJson(citas);
		PrintWriter out=response.getWriter();
		response.setContentType("text/plain");
		out.println(respuestaJson);

	}
	
}