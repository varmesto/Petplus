package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.DaoClientes;


@WebServlet("/RegistrarClienteAction")
public class RegistrarClienteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoClientes gestion=new DaoClientes();
        gestion.registrarCliente(request.getParameter("nombre"),
        		request.getParameter("apellidos"),
        		 Integer.parseInt(request.getParameter("telefono")),
        		 request.getParameter("direccion"),
                request.getParameter("email"),
                request.getParameter("usuario"),
                request.getParameter("password"));

        	
              
        request.getRequestDispatcher("inicia-sesion.html").forward(request, response);
	}

}
