package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorInstitucion{
    private static ManejadorInstitucion instancia = null;
	private List<InstitucionDeportiva> ins = new ArrayList<>();
	private ManejadorInstitucion(){}
	
	public static ManejadorInstitucion getInstancia() {
		if (instancia == null)
			instancia = new ManejadorInstitucion();
		return instancia;
	}
    public InstitucionDeportiva buscarInstitucionDeportiva(String nombre) {
		InstitucionDeportiva aretornar=null;
		for(InstitucionDeportiva i: ins) {
			if (i.getNombre().equals(nombre))
				aretornar=i;
		}
		return aretornar;
	}
	
	public void addInstitucion(InstitucionDeportiva inst) {
		ins.add(inst);
	}
	
	public ArrayList<String> obtenerInstitutos(){
		ArrayList<String> aRetornar = new ArrayList<>();
		for(InstitucionDeportiva i: ins) {
			aRetornar.add(i.getNombre());
		}
		return aRetornar;
	}
}