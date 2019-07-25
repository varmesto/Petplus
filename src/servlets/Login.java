package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Ficha;

//Formulario acceso que autentique con root y root
@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try{
	        String usuario=request.getParameter("user");
	        String pwd=request.getParameter("pwd");
	        
	        if(usuario.equals("root") && pwd.equals("root")){
	        	//crear la cookie
	        	//Hacerlo en un método aparte para no llenar mucho el service
	        	crearCookie(usuario, pwd,response);
	        	
	        	Ficha f=new Ficha(usuario,19,"myuser@gmail.com");
	        	request.setAttribute("laficha", f);
	        	//Trasnferir petición al jsp de bienvenida
	     		RequestDispatcher dispatch=request.getRequestDispatcher("bienvenida.jsp");
	     		dispatch.forward(request, response);
			}else {
				//Trasnferir petición al jsp de error
				RequestDispatcher dispatch=request.getRequestDispatcher("error.jsp");
	     		dispatch.forward(request, response);
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
       
	}
	private void crearCookie(String dato1, String dato2, HttpServletResponse resp) {
		Cookie ck=new Cookie("credenciales", dato1+"|"+dato2);
		//importar clase cookie
		ck.setMaxAge(20000);
		resp.addCookie(ck);
	}
}