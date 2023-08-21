package logica;

import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.ActividadDeportivaRepetidaException;
import interfaces.IControlador;
import datatypes.DtActividadDeportiva;

//import interfaces.UsuarioRepetidoExcepcion;

public class Controlador implements IControlador{
	public Controlador() {
		super();
	}
	//@Override
	//public void agregarUsuario(String nickname, String nombre, String apellido, String email, LocalDate fecNac) throws UsuarioRepetidoExcepcion {
	
	@Override
	public void altaInstitucion(String nombre, String descripcion, String url) throws InstitucionDeportivaRepetidaException{
		ManejadorInstitucion mI= ManejadorInstitucion.getInstancia(); 
		InstitucionDeportiva i=mI.buscarInstitucionDeportiva(nombre); 
		if(i!=null)
			throw new InstitucionDeportivaRepetidaException("El Instituto " + nombre + " ya existe");
		else {
			i=new InstitucionDeportiva(nombre,descripcion,url);
			mI.addInstitucion(i);
		}
	}

	@Override
	public void altaActividadDeportiva(String nombreIns,DtActividadDeportiva data) throws ActividadDeportivaRepetidaException{
		ManejadorInstitucion mI= ManejadorInstitucion.getInstancia(); 
		InstitucionDeportiva i=mI.buscarInstitucionDeportiva(nombreIns);
		i.agregarActividadDeportiva(data);
	}
}
