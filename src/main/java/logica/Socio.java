package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Socio extends Usuario{
	private List<Registro> registros = new ArrayList<>();
    public Socio(){
    	super();
    }
	
	public Socio(String n, String nom, String a, String e, LocalDate f){
        super(n, nom, a, e, f);
    }
}
