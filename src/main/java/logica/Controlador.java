package logica;

import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.UsuarioRepetidoException;
import excepciones.ActividadDeportivaRepetidaException;
import interfaces.IControlador;
import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtUsuario;
import datatypes.DtProfesor;
import datatypes.DtSocio;

//import interfaces.UsuarioRepetidoExcepcion;

public class Controlador implements IControlador{
	public Controlador() {
		super();
	}
	
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

	@Override
	public void agregarUsuario(DtUsuario user) throws UsuarioRepetidoException{
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario nuevoUser = mU.buscarUsuario(user.getNickname());
		if (nuevoUser != null)
			throw new UsuarioRepetidoException("El usuario de nick "+ nuevoUser.getNickname() + " ya existe en el Sistema");
		if (user instanceof DtProfesor)
			nuevoUser = new Profesor(nuevoUser.getNickname(),nuevoUser.getNombre(),nuevoUser.getApellido(),nuevoUser.getEmail(),nuevoUser.getFecNac(),((DtProfesor) user).getDescripcion(),((DtProfesor) user).getBiografia(),((DtProfesor) user).getSitioWeb()); 
		if (user instanceof DtSocio)
			nuevoUser = new Socio(nuevoUser.getNickname(),nuevoUser.getNombre(),nuevoUser.getApellido(),nuevoUser.getEmail(),nuevoUser.getFecNac());
		mU.addUser(nuevoUser);
	}
}
