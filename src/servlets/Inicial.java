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

@WebServlet("/Inicial")
public class Inicial extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		//evitar q el servidor reenvie a formulario a pesar de haber ido a bienvenida (cosas del Tomcat)
		boolean encontrada=false;
		//evitar recorrer un aray vacio (NuulPointerException)
		if(cookies!=null) {
			for(Cookie ck:cookies){
				//recorrer las cookies en busca de la cookie credenciales
				//si existe ir a bienvenida
				//si no existe a formulario
				if(ck.getName().equals("credenciales")){
					encontrada=true;
					String valor=ck.getValue();
					//recoger el valor de la cookie
					//convertirlo en un array
					//extraer nombre del usuario para formar la ficha
					String user=valor.split("[|]")[0];
					Ficha f=new Ficha(user,19,"myuser@gmail.com");
		        	request.setAttribute("laficha", f);
					//faltaría comprobar que el contenido es el adecuado
					request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
				}
			}	
		}
		//por si hay cookies y ninguna es credenciales
		if(!encontrada) {
			request.getRequestDispatcher("formulario.html").forward(request, response);
		}	
	}

}
