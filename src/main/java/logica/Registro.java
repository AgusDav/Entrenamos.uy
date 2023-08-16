package logica;

import java.time.LocalDate;

public class Registro {
	private Socio socio;
	private Clase clase;
	private LocalDate fechaReg;
	
	public Registro(){
		super();
	}
	public Registro(Socio socio, Clase clase, LocalDate fechaReg){
		super();
		this.socio=socio;
		this.clase=clase;
		this.setFechaReg(fechaReg);
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	public LocalDate getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(LocalDate fechaReg) {
		this.fechaReg = fechaReg;
	}

}
