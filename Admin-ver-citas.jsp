<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
        import="java.util.List,java.util.ArrayList,beans.Cita"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>PetPlus-Citas admin</title>
</head>

<body>
	<h1>P�gina de administraci�n</h1>
					<%List<Cita> citasAdmin=(ArrayList<Cita>)request.getSession().getAttribute("citasAdmin");%>
						<%if(citasAdmin.size()>0){%>
							<h1>Todas las citas de la cl�nica</h1>
								<table>
									<tr>
										<td>idMascota</td>
										<td>Fecha Cita</td>
									</tr>
									<%for(Cita c:citasAdmin){%>	
										<tr>			
											<td><%=c.getIdMascota()%></td>
											<td><%=c.getFechaCita()%></td>
										</tr>				
									<%}%>	
								</table>
						<%} %>

</body>
</html>