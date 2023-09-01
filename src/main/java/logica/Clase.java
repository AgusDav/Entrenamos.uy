package logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Clase implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String nombre;
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;
    @Temporal(TemporalType.TIME)
    private LocalTime hora;
    @Basic
    private String url;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaReg;
    //pseudos
    private Profesor profe;
    private ActividadDeportiva actividad;
    private List<Registro> registros = new ArrayList<>();

    public Clase(){
        super();
    }

    public Clase(String nombre, LocalDate fecha, LocalTime hora, String url, LocalDate fechaReg, Profesor profe){
        super();
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.url = url;
        this.fechaReg = fechaReg;
        this.profe = profe;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public LocalDate getFecha(){
        return this.fecha;
    }

    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }

    public LocalTime getHora(){
        return this.hora;
    }

    public void setHora(LocalTime hora){
        this.hora = hora;
    }

    public String getUrl(){
        return this.url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public LocalDate getFechaReg(){
        return this.fechaReg;
    }

    public void setFechaReg(LocalDate fechaReg){
        this.fechaReg = fechaReg;
    }

	public Profesor getProfe() {
		return profe;
	}

	public void setProfe(Profesor profe) {
		this.profe = profe;
	}

	public ActividadDeportiva getActividad() {
		return actividad;
	}

	public void setActividad(ActividadDeportiva actividad) {
		this.actividad = actividad;
	}

}
