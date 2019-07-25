package beans;

import java.time.LocalDateTime;

public class Cita {
	private int idCita;
	private LocalDateTime fechaCita;
	private int idMascota;
	
	public Cita(int idCita, LocalDateTime fechaCita, int idMascota) {
		super();
		this.idCita = idCita;
		this.fechaCita = fechaCita;
		this.idMascota = idMascota;
	}

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public int getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

}
