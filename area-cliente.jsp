<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>PetPlus-Area Cliente</title>

    <link href="asset/css/bootstrap.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="asset/css/style.css">
    
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
	                    <a class="navbar-brand" href="Controller?op=toIndex">
	                            <img class="logo" src="asset/img/logo.png" >
	                    </a>
	                </div>
	                <div id="navbar" class="navbar-collapse collapse">
	                    <ul class="nav navbar-nav">
	                        <li class="active"><a href="Controller?op=toAreaCliente" class="">Área cliente</a></li>
	                        <li class=" dropdown">
	                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Mascotas <span class="caret"></span></a>
	                            <ul class="dropdown-menu">
	                                <li class=" dropdown"><a href="Controller?op=toRegistrarMascota">Registrar mascota</a></li>
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
			<h1>Bienvenido ${sessionScope.nombreCliente}</h1>
			<c:choose>
				<c:when test="${!empty sessionScope.mascotas}">
					<h2>Un gusto en atenderte a tí y a:</h2>
							<c:forEach var="pet" items="${sessionScope.mascotas}" >
								<h3>${pet.nombreMascota}</h3>
							</c:forEach>				
				</c:when>	
				<c:otherwise>
					<h1>No tiene mascotas registradas con nosotros</h1>
				</c:otherwise>	
			</c:choose>
		</div>
	</div>
    <br>

	<div class= "row">
			<div class="col-md-4 col-md-offset-1">
	   			<img class="foto_grande" src="asset/img/img_g2.jpg">
	   		</div>   
	        <div class="cuadro_grande col-md-5 col-md-offset-1 ">
	   			<div>
	   				<p>
	   				 <h3>Bienvenidos al área del cliente, aquí, podrás registrar a tus mascotas y gestionar sus citas para las próximas
	   				 fechas breves</h3>
	   				
	   				<br><br>
	   				
	   				 Si aún no has registrado a tus mascotas, anímate. Petplus tiene como prioridad principal la medicina preventiva y curativa
	   			para tus mascotas, nos importa su salud.
	   			
	   				<br>
	   				<br>
	   				<br>
	   				<i>"El amor por las criaturas vivientes es el atributo mas noble del hombre" - Charles Darwin</i>
	   				<br>
	   				<br>
	   				<img class="imagen_redonda" src="asset/img/imagen_redonda.jpg">
	   				</p>
	   			</div>
	   		</div>    
   		</div>
	<br><br><br><br>
<!-- ==============================Footer====================================== -->
	<footer>
		<br><br>
		<div class="footer col-lg-12 col-md-12"> 
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