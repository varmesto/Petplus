package beans;

public class Mascota {
	private int idMascota;
	private String nombreMascota;
	private String especie;
	private String raza;
	private String genero;
	private double peso;
	private double edad;
	private int idCliente;
	
	public Mascota(int idMascota, String nombreMascota, String especie, String raza, String genero, double peso,
			double edad, int idCliente) {
		super();
		this.idMascota = idMascota;
		this.nombreMascota = nombreMascota;
		this.especie = especie;
		this.raza = raza;
		this.genero = genero;
		this.peso = peso;
		this.edad = edad;
		this.idCliente = idCliente;
	}

	public int getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getEdad() {
		return edad;
	}

	public void setEdad(double edad) {
		this.edad = edad;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	
}
