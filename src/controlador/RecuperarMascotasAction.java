package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Mascota;
import modelo.DaoMascotas;
import utilities.UtilidadesMascotas;


/**
 * Servlet implementation class MostrarMascotaAction
 */
@WebServlet("/RecuperarMascotasAction")
public class RecuperarMascotasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idCliente=(Integer)request.getSession().getAttribute("idCliente");
		DaoMascotas daoM=new DaoMascotas();
		List<Mascota> mascotas=daoM.obtenerMascotas(idCliente);
		request.setAttribute("mascotas", mascotas );
		
		String respuestaJsonMascotas=UtilidadesMascotas.transformarJsonMascotas(mascotas);
		PrintWriter out=response.getWriter();
		response.setContentType("text/plain");
		out.println(respuestaJsonMascotas);			
	}

}
