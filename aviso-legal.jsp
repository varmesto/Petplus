
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>PetPlus</title>


    <link href="asset/css/bootstrap.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="asset/css/style.css">
    
</head>
<body>

<!-- ----------------------------INICIO NAVBAR-------------------------------------------------------------- -->

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
                            <li class=" down"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Sobre nosotros<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="Controller?op=toServiciosPetPlus">Servicios</a></li>
                            </ul>
                        </li>

                        <li class=" dropdown"><a href="Controller?op=toDondeEstamos" class="dropdown-toggle active" >Dónde estamos</a>
                        </li>
                        
                        <li class=" down"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Contáctanos<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="Controller?op=toContacto">Contacto</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <li class=""><a href="Controller?op=toRegistrarCliente">Regístrate</a></li>
                        <li class=""><a href="Controller?op=toInicia-Sesion">Iniciar sesión</a></li>                     
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>


<!------------------------------------------------------FIN NAVABAR------------------------------------------------>
<br>
<br>
<br>
<br>
<br>
	<div class="container">
		<h1>AVISO LEGAL</h1>

        <p> 
        	En cumplimiento de la Ley 34/2002, de 11 de julio, de Servicios de la Sociedad de la Información y del Comercio Electrónico (LSSI), le informamos que PetPlus a la que usted ha accedido es propiedad de Génesis Roa y Vanessa Armesto Hernández
        </p><br>


        <p>
        	El acceso a este sitio web supone la aceptación expresa del usuario a las presentes condiciones generales de uso, que podrán ser modificadas o sustituidas por su titular en cualquier momento y sin previo aviso.
            PetPlus, advierte que, tanto los contenidos y servicios de esta página web como las propias condiciones de utilización, pueden ser modificados sin notificación previa.
        </p><br>


        <h2>Contactos consulta:
	        <p>Correo electrónico: varmesto@hotmail.com</p>
	     	<p>Correo electrónico: genesisroa95@gmail.com</p>
	    </h2>	
            
        <h3>PROPIEDAD INTELECTUAL E INDUSTRIAL</h3>
        <p>
            Los contenidos, imagen corporativa, documentación, imágenes, gráficos y diseño que forman esta web son propiedad de xxx, y se encuentran debidamente protegidos de conformidad con la normativa española e internacional sobre Propiedad Intelectual e Industrial.
        </p>

        <p>
       	 El dueño autoriza al usuario para visualizar la información que se contiene en este portal, así como para efectuar reproducciones privadas (simple actividad de descarga y almacenamiento en sus sistemas informáticos), siempre y cuando los elementos sean destinados únicamente al uso personal.
        </p>

        <p>
            El usuario no está autorizado para proceder a la distribución, modificación, cesión o comunicación pública de la información contenida en esta web fuera de las finalidades establecidas expresamente en el párrafo anterior. En este sentido, el Estudio de nuestros guías se reserva el ejercicio de las acciones legales oportunas en defensa de sus derechos.
        </p>	
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
</html>