package logica;

import datatypes.DtFecha;

import java.time.LocalDate;

public class ActividadDeportiva {

    private String nombre;
    private String descripcion;
    private int duracion;
    private float costo;
    private LocalDate fecReg;
    //pseudos
    private InstitucionDeportiva institucion;

    public ActividadDeportiva() {
        super();
    }

    public ActividadDeportiva(String n, String d, int dur, float c, LocalDate f) {
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
    public LocalDate getFecReg() {
        return fecReg;
    }
    public void setFecReg(LocalDate fecReg) {
        this.fecReg = fecReg;
    }

	public InstitucionDeportiva getInstitucion() {
		return institucion;
	}

	public void setInstitucion(InstitucionDeportiva institucion) {
		this.institucion = institucion;
	}
}
