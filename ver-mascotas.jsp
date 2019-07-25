<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>PetPlus-Ver mascotas</title>


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
<br>
<br>
<br>
<br>
<br>
	<div class="container">
		 <div class="cuadro_grande">
			<div id="mascotasTabla">
								
			</div>	
		</div>

	
		<br><br><br>
	</div>
<!-- ==============================Footer====================================== -->
	<footer>
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
    
    <script type="text/javascript">
    	$(document).ready(
    	   function mostrarMascotas(){		
    			let url="Controller?op=doRecuperarMascotas";
    			$.get(url,procesarRespuesta);
    		}
    	); 
		
		function eliminarMascota(idMascota){
			let url="Controller?op=doEliminarMascota&idMascota="+ idMascota;
			$.get(url, procesarRespuesta);
		}
		
		function procesarRespuesta(respuestaJsonMascotas){
			let json=JSON.parse(respuestaJsonMascotas);
			let tabla;
			if(json.length>0){
					tabla="<h2>Estas son las mascotas que tiene resgistradas con nostros</h2>";
					tabla+="<table class='table table-hover table-striped table-bordered'>";
					tabla+="<tr><th>Nombre mascota</th><th>Especie</th><th>Raza</th><th>Género</th><th>Peso</th><th>Edad</th></tr>";
				for(let i=0;i<json.length;i++){
					tabla+="<tr><td>"+json[i].nombreMascota+"</td><td>"+json[i].especie+"</td>";
					tabla+="<td>"+json[i].raza+"</td><td>"+json[i].genero+"</td><td>"+json[i].peso+"</td>";
					tabla+="<td>"+json[i].edad+"</td>";
					tabla+="<td><a href='#' onclick='eliminarMascota("+json[i].idMascota+");'>Eliminar mascota</a></td></tr>";
				}
				tabla+="</table>";				
			}else{
				tabla="<table><th>No tiene mascotas </th></table>";
			}
			$("#mascotasTabla").html(tabla);
		}

    </script>
    				
    
</html>