package logica;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("P")
public class Profesor extends Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
	private  String descripcion;
    private String biografia;
    private String sitioWeb;
    //pseudos
    @ManyToOne
    private InstitucionDeportiva institucion;

    public Profesor(){
    	super();
    }

    public Profesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String descripcion, String biografia, String sitioWeb, InstitucionDeportiva institucion){
        super(nickname, nombre, apellido, email, fechaNac);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
        this.institucion = institucion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }
    
    @Override
	public DtUsuario getDtUsuario() {
		return new DtProfesor(this.nickname,this.nombre,this.apellido,this.email,this.fecNac,this.descripcion, this.biografia, this.sitioWeb);
	}

	@Override
	public void añadirRegistro(Registro reg) {
		//Ta pelao
	}
}
