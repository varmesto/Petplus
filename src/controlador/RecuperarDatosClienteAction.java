package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cliente;
import modelo.DaoClientes;

/**
 * Servlet implementation class ObtenerDatosCliente
 */
@WebServlet("/RecuperarDatosClienteAction")
public class RecuperarDatosClienteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int idCliente=(Integer)request.getSession().getAttribute("idCliente");
		DaoClientes dClientes = new DaoClientes();
		request.setAttribute("idCliente", dClientes.obtenerCliente(idCliente));

		request.getRequestDispatcher("ver-datos-cliente.jsp").forward(request, response);	

	}
}
