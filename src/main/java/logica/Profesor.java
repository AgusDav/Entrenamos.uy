package logica;

import java.time.LocalDate;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;

public class Profesor extends Usuario{
    private  String descripcion;
    private String biografia;
    private String sitioWeb;
    //pseudos
    private InstitucionDeportiva institucion;

    public Profesor(){
    	super();
    }

    public Profesor(String nickname, String nombre, String apellido, String email, LocalDate fechaNac, String descripcion, String biografia, String sitioWeb, InstitucionDeportiva institucion){
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
}
