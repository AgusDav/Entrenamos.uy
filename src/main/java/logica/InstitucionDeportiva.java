package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtActividadDeportiva;

public class InstitucionDeportiva {
    private String nombre;
    private String descripcion;
    private String url;
    private List<ActividadDeportiva> actD = new ArrayList<>();
    private List<Profesor> profesores = new ArrayList<>();
    
    public InstitucionDeportiva(){
        super();
    }
    
    public InstitucionDeportiva(String nombre, String descripcion, String url){
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getUrl(){
        return this.url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void agregarActividadDeportiva(DtActividadDeportiva data){
        ActividadDeportiva i = new ActividadDeportiva(data.getNombre(),data.getDescripcion(),data.getDuracion(),data.getCosto(),data.getFecReg());
		actD.add(i);
    }
    
    public ArrayList<String> obtenerActividades(){
        ArrayList<String> aRetornar = new ArrayList<>();
        for(ActividadDeportiva i: actD) {
            aRetornar.add(i.getNombre());
        }
        return aRetornar;
    }
    
    public ArrayList<String> obtenerProfesores(){
        ArrayList<String> aRetornar = new ArrayList<>();
        for(Profesor i: profesores) {
            aRetornar.add(i.getNombre());
        }
        return aRetornar;
    }
    
    public ActividadDeportiva buscarActividad(String nombre) {
    	ActividadDeportiva aRetornar;
    	aRetornar = new ActividadDeportiva();
    	for(ActividadDeportiva i:actD) {
    		if (i.getNombre().equals(nombre))
				aRetornar=i;
    	}
    	return aRetornar;
    }
    
    public void agregarProfesor(Profesor profe){
        //Profesor i = new Profesor();
        profesores.add(profe);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}