package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorClase{
    private static ManejadorClase instancia = null;
	private List<Clase> clase = new ArrayList<>();
	private ManejadorClase(){}
	
	public static ManejadorClase getInstancia() {
		if (instancia == null)
			instancia = new ManejadorClase();
		return instancia;
	}
	
	public Clase buscarClase(String nombre) {
		Clase aretornar=null;
		for(Clase i: clase) {
			if (i.getNombre().equals(nombre))
				aretornar=i;
		}
		return aretornar;
	}
	
	public void addClase(Clase clas) {
		clase.add(clas);
	}
	
	public ArrayList<String> obtenerClase(){
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Clase i: clase) {
			aRetornar.add(i.getNombre());
		}
		return aRetornar;
	}
	
}
	

	