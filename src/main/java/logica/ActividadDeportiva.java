package logica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class ActividadDeportiva implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="Nombre")
    private String nombre;
    @Basic
    private String descripcion;
    private int duracion;
    private float costo;
    @Temporal(TemporalType.DATE)
    private Date fecReg;

    private InstitucionDeportiva institucion;
    private List<Clase> clases = new ArrayList<>();

    public ActividadDeportiva() {
        super();
    }

    public ActividadDeportiva(String n, String d, int dur, float c, Date f) {
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
    public Date getFecReg() {
        return fecReg;
    }
    public void setFecReg(Date fecReg) {
        this.fecReg = fecReg;
    }

	public InstitucionDeportiva getInstitucion() {
		return institucion;
	}

	public void setInstitucion(InstitucionDeportiva institucion) {
		this.institucion = institucion;
	}
	
	public List<Clase> getClases() {
	    return clases;
	}
	
	public void agregarClase(DtClase data, Profesor profe){
		Date fecha = Date.from(data.getFecha().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date fechaReg = Date.from(data.getFechaReg().atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		LocalDateTime localDateTimeHora = LocalDateTime.of(LocalDate.now(), data.getHoraInicio());
		Date hora = Date.from(localDateTimeHora.atZone(ZoneId.systemDefault()).toInstant());
		Clase i = new Clase(data.getNombre(), fecha, hora, data.getUrl(), fechaReg, profe);
		clases.add(i);
	}

	public DtActividadDeportiva getDtActividadDeportiva() {
		LocalDate fecha = this.fecReg.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return new DtActividadDeportiva(this.nombre, this.descripcion, this.duracion, this.costo, fecha);
	}
}
