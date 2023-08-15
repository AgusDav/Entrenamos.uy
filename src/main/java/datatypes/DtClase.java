package datatypes;

public class DtClase {
	private String nombre;	
	private DtFecha fecha;
	private DtHora horaInicio;
	private String url;
	private DtFecha fechaReg;
	
	public DtClase(String n, DtFecha f, DtHora h, String u, DtFecha fR) {
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
	public DtFecha getFecha() {
		return fecha;
	}
	public void setFecha(DtFecha fecha) {
		this.fecha = fecha;
	}
	public DtHora getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(DtHora horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public DtFecha getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(DtFecha fechaReg) {
		this.fechaReg = fechaReg;
	}
	@Override
	public String toString() {
		return "Nombre: " + getNombre() + "\nFecha: " + getFecha() + "\nHora inicio: " + getHoraInicio() + "\nUrl: " + getUrl() + "\nFecha registro: " + getFechaReg();
	}
	
	
	
}
