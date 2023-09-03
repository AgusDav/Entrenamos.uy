package logica;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtSocio;
import datatypes.DtUsuario;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("S")
public class Socio extends Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="socio",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Registro> registros = new ArrayList<>();
    
	public Socio(){
    	super();
    }
	
	public Socio(String n, String nom, String a, String e, Date f){
        super(n, nom, a, e, f);
    }
	
	@Override
	public DtUsuario getDtUsuario() {
		//LocalDate fecha = this.fecNac.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return new DtSocio(this.nickname,this.nombre,this.apellido,this.email,this.fecNac);
	}

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public void añadirRegistro(Registro reg){
        registros.add(reg);
    }
}
