package datatypes;

public class DtActividadDeportiva {
	private String nombre;
	private String descripcion;
	private int duracion;
	private float costo;
	private DtFecha fecReg;
	
	public DtActividadDeportiva(String n, String d, int dur, float c, DtFecha f) {
		super();
		this.nombre = n;
		this.descripcion = d;
		this.duracion = dur;
		this.costo  = c;
		this.fecReg = f;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public DtFecha getFecReg() {
		return fecReg;
	}
	public void setFecReg(DtFecha fecReg) {
		this.fecReg = fecReg;
	}
	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nDescripcion: " + descripcion + "\nDuracion: " + duracion
				+ "\nCosto: " + costo + "\nFecha registro: " + fecReg;
	}
}
