package datatypes;

import java.time.LocalDate;
import java.time.LocalTime;

public class DtClase {
	private String nombre;	
	private LocalDate fecha;
	private LocalTime horaInicio;
	private String url;
	private LocalDate fechaReg;
	
	public DtClase(String n, LocalDate f, LocalTime h, String u, LocalDate fR) {
		super();
		this.nombre = n;
		this.fecha = f;
		this.horaInicio = h;
		this.url = u;
		this.fechaReg = fR;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public LocalDate getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(LocalDate fechaReg) {
		this.fechaReg = fechaReg;
	}
	@Override
	public String toString() {
		return "Nombre: " + getNombre() + "\nFecha: " + getFecha() + "\nHora inicio: " + getHoraInicio() + "\nUrl: " + getUrl() + "\nFecha registro: " + getFechaReg();
	}
	
	
	
}
