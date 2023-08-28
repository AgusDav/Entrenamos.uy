package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datatypes.DtSocio;
import datatypes.DtUsuario;

public class Socio extends Usuario{
	private List<Registro> registros = new ArrayList<>();
    public Socio(){
    	super();
    }
	
	public Socio(String n, String nom, String a, String e, LocalDate f){
        super(n, nom, a, e, f);
    }
	
	@Override
	public DtUsuario getDtUsuario() {
		return new DtSocio(this.nickname,this.nombre,this.apellido,this.email,this.fecNac);
	}
}
