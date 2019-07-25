package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Mascota;
import modelo.DaoCitas;
import modelo.DaoClientes;
import modelo.DaoMascotas;

/**
 * Servlet implementation class EliminarClienteAction
 */
@WebServlet("/EliminarClienteAction")
public class EliminarClienteAction extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoClientes daoClientes=new DaoClientes();
		DaoMascotas daoMascotas=new DaoMascotas();
		DaoCitas daoCitas=new DaoCitas();
	
		//Recuperar los datos
		List<Mascota> mascotas=(List<Mascota>) request.getSession().getAttribute("mascotas");
		int idCliente=(Integer)(request.getSession().getAttribute("idCliente"));
		
		System.out.println(mascotas);
		System.out.println(idCliente);
		
		//Eliminar las mascotas y las citas asociadas al Cliente
		if (mascotas!=null) {
			for(Mascota pet:mascotas) {
				int idMascota=pet.getIdMascota();
				daoCitas.eliminarCitaBaja(idMascota);
				daoMascotas.eliminarMascota(idMascota);
			}
		}
		
		//Eliminar el cliente de la tabla cliente
		daoClientes.eliminarCliente(idCliente);
		
		request.getRequestDispatcher("index.html").forward(request, response);
	}

}
