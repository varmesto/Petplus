<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Alta Cita</title>
	
	<link href="asset/css/bootstrap.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="asset/css/style.css">
	
</head>
<body>

<!------ Navbar ---------->

<div class="navbar-wrapper">
    <div class="container-fluid">
        <nav class="navbar navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="Controller?op=toAreaCliente">
                            <img class="logo" src="asset/img/logo.png" >
                    </a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="Controller?op=toAreaCliente" class="">Área cliente</a></li>
                        <li class=" dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Mascotas <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class=" dropdown">
                                    <a href="Controller?op=toRegistrarMascota">Registrar mascota</a>
                                </li>
                                <li><a href="Controller?op=toVerMascotas">Ver Mascotas</a></li>
                            </ul>
                        </li>
                                          
                        <li class=" dropdown"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Citas <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="Controller?op=toRegistrarCita">Pedir cita</a></li>
                                <li><a href="Controller?op=toRecuperarCita">Ver citas</a></li>
                            </ul>
                        </li>
                        
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <li class=" dropdown"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Mi perfil<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="Controller?op=doVerDatosCliente">Ver datos</a></li>
                                <li class=""><a href="Controller?op=toIndex">Desconectar</a></li>
                      
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
<!-- ================ FIN NAVBAR ============================================================== --> 
<br>
<br>
<br>
<br>

	<div class="container">
	    <div class="cuadro_grande">
	            <form action="Controller?op=doRegistrarCita" method="POST" role="form">
		                        <div class="form-group">
		                        	<c:choose>
										<c:when test="${!empty sessionScope.mascotas}">
		                        			<h1>¿Para qué mascota quiere pedir cita?</h1>
												<select class="form-control" name="idMascota" id="idMascota">
													<c:forEach var="pet" items="${sessionScope.mascotas}">
														<option></option>
														<option value="${pet.getIdMascota()}">${pet.getNombreMascota()}</option>
													</c:forEach>
												</select> 
										</c:when>
										<c:otherwise>
											<h1>No tiene mascotas registradas</h1>
										</c:otherwise>	
									</c:choose>  
		              			</div>

		                        <div class="form-group">
		                        	<h2>Escoja un día</h2>
		                           	<input class="form-control" type="date" name="fechaCita" id="fechaCita" min="2019-07-02T00:00"  step="1">
		                        	<h2>Escoja una hora. Nuestro horario es de 9:00 a 19:30</h2>
		                        	<h3>Las citas son de 30 minutos</h3>
		                        	<input class="form-control" type="time" name="horaCita" id="horaCita" min="09:00"  max="19:00" step="1800">
		                        </div>
		              <input type="submit" class="btn btn-lg btn-success btn-block" value="Pedir cita">
				</form>
		</div>
	</div>  	
<!-- ==============================Footer====================================== -->
	<footer>
		<div class="footer estatico col-lg-12 col-md-12"> 
			<div class="container">
				<div class="col-lg-6 col-md-6">
					<h5>Información</h5>
					<ul>
						<li><a href="Controller?op=toContacto">Contacto</a></li>
						<li><a href="Controller?op=toAdmin">Administración</a></li>
					</ul>
				</div>
				<div class="col-lg-6 col-md-6">
					<h5>Condiciones</h5>
					<ul>
						<li><a href="Controller?op=toAviso">Aviso legal</a></li>
						<li><a href="Controller?op=toPolitica">Política de privacidad</a></li>
						<li><a href="Controller?op=toCookies">Cookies</a></li>
					</ul>
				</div>
				<div class="col-lg-12 col-md-12"> 
					<p>Copyright 
						<script>
							document.write(new Date().getFullYear());
						</script>
					* All rights reserved * This page is made by Génesis Roa and Vanessa Armesto Hernández</p>
				</div>
			</div>		
		</div>
	</footer>	
<!-- ==============================Fin footer====================================== -->		

</body>

	<script src="asset/js/jquery-3.4.1.min.js"></script>
    <script src="asset/js/bootstrap.js"></script>
    <script src="asset/js/popper.js"></script>
    <script src="asset/js/funciones.js"></script>


</html>