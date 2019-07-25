package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Mascota;
import modelo.DaoClientes;
import modelo.DaoMascotas;

/**
 * Servlet implementation class RegistrarMascotaAction
 */
@WebServlet("/RegistrarMascotaAction")
public class RegistrarMascotaAction extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoMascotas gMascotas=new DaoMascotas();
		int idC=(Integer)request.getSession().getAttribute("idCliente");
        gMascotas.registrarMascota(request.getParameter("nombreMascota"),
        					request.getParameter("especie"),
        					request.getParameter("raza"),
        					request.getParameter("genero"),
        					Double.parseDouble(request.getParameter("peso")),
							Double.parseDouble(request.getParameter("edad")),
        					idC);
        request.getRequestDispatcher("ver-mascotas.jsp").forward(request, response);     
	}
	
}
