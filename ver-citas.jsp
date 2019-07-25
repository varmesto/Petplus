<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>PetPlus-Ver citas</title>
	<link href="asset/css/bootstrap.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="asset/css/style.css">
    <script src="asset/js/jquery-3.4.1.min.js"></script>
	
</head>

<body>


	<!-- ================ NAVBAR ============================================================== --> 

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
                        <li class="active"><a href="Controller?op=toAreaCliente" class="">�rea cliente</a></li>
                        <li class=" dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Mascotas <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class=" dropdown"><a href="Controller?op=toRegistrarMascota">Registrar mascota</a>                                </li>
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
			<c:choose>
					<c:when test="${!empty sessionScope.mascotas}">
						<h2>Escoja una mascota para ver las citas reservadas en nuestra cl�nica</h2>
							<c:forEach var="m" items="${sessionScope.mascotas}">
								<p></p>
					    		<h3><a href="#" onclick="mostrar(${m.idMascota});">${m.nombreMascota}</a></h3>	
							</c:forEach>				
					</c:when>	
					<c:otherwise>
						<h1>No tiene citas reservadas</h1>
					</c:otherwise>	
			</c:choose>  
			
			<!-- Donde se pintan las citas con Ajax-->	
			<div id="citasTabla">
			
		
		<br><br><br>
			</div>  
			<br><br><br>    
		</div>
		
	</div>		
<!-- ==============================Footer====================================== -->
	<footer>
		<div class="footer  col-lg-12 col-md-12"> 
			<div class="container">
				<div class="col-lg-6 col-md-6">
					<h5>Informaci�n</h5>
					<ul>
						<li><a href="Controller?op=toContacto">Contacto</a></li>
						<li><a href="Controller?op=toAdmin">Administraci�n</a></li>
					</ul>
				</div>
				<div class="col-lg-6 col-md-6">
					<h5>Condiciones</h5>
					<ul>
						<li><a href="Controller?op=toAviso">Aviso legal</a></li>
						<li><a href="Controller?op=toPolitica">Pol�tica de privacidad</a></li>
						<li><a href="Controller?op=toCookies">Cookies</a></li>
					</ul>
				</div>
				<div class="col-lg-12 col-md-12"> 
					<p>Copyright 
						<script>
							document.write(new Date().getFullYear());
						</script>
					* All rights reserved * This page is made by G�nesis Roa and Vanessa Armesto Hern�ndez</p>
				</div>
			</div>		
		</div>
	</footer>	
<!-- ==============================Fin footer====================================== -->						

</body>
    <script src="asset/js/bootstrap.js"></script>
    <script src="asset/js/popper.js"></script>
    <script src="asset/js/funciones.js"></script>
    
    <script type="text/javascript">
		function mostrar(idMascota){
			let url="Controller?op=doRecuperarCita&idMascota="+idMascota;
			$.get(url,procesarRespuesta);
		}
		
		function eliminarCita(idCita){
			let url="Controller?op=doEliminarCita&idCita="+idCita;
			$.get(url,procesarRespuesta);
		}
		
		function procesarRespuesta(respuestaJson){
			let json=JSON.parse(respuestaJson);
			let tabla;
			if(json.length>0){
					tabla="<h3>Citas que tiene en nuestra cl�nica </h3>";
					tabla+="<table class='table table-hover table-striped table-bordered'>";
				for(let i=0;i<json.length;i++){
					tabla+="<tr><td>"+json[i].fechaCita+"</td>";
					tabla+="<td><a href='#' onclick='eliminarCita("+json[i].idCita+");'>Eliminar cita</a></td></tr>";
				}
				tabla+="</table>";				
			}else{
				tabla="<table><th>No tiene citas </th></table>";
			}
			$("#citasTabla").html(tabla);
		}
	</script>
	

</html>