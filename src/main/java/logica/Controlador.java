package logica;

import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.UsuarioRepetidoException;
import excepciones.ActividadDeportivaRepetidaException;
import excepciones.DictadoRepetidoException;
import interfaces.IControlador;

import java.util.ArrayList;

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
	public void agregarUsuario(DtUsuario user, String ins) throws UsuarioRepetidoException{
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario nuevoUser = mU.buscarUsuario(user.getNickname());
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva inst = mI.buscarInstitucionDeportiva(ins);
		if (nuevoUser != null)
			throw new UsuarioRepetidoException("El usuario de nick "+ nuevoUser.getNickname() + " ya existe en el Sistema");
		if (user instanceof DtProfesor) {
			nuevoUser = new Profesor(user.getNickname(),user.getNombre(),user.getApellido(),user.getEmail(),user.getFecNac(),((DtProfesor) user).getDescripcion(),((DtProfesor) user).getBiografia(),((DtProfesor) user).getSitioWeb(), inst); 
			inst.agregarProfesor((Profesor) nuevoUser);
		}
		if (user instanceof DtSocio)
		nuevoUser = new Socio(user.getNickname(),user.getNombre(),user.getApellido(),user.getEmail(),user.getFecNac());
		mU.addUser(nuevoUser);
	}
	
	@Override
	public void altaDictadoClase(DtClase clase, String nomIns, String nomAct, String profe) throws DictadoRepetidoException{
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva aux;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Profesor profesor = (Profesor) mU.buscarUsuario(profe);
		aux = mI.buscarInstitucionDeportiva(nomIns);
		ActividadDeportiva actD = aux.buscarActividad(nomAct);
		actD.agregarClase(clase, profesor);
	}
	
	@Override
	public String[] listarInstitutos() {
		ArrayList<String> instituto;
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		instituto = mI.obtenerInstitutos();
		String[] institutos_ret = new String[instituto.size()];
        int i=0;
        for(String ins:instituto) {
        	institutos_ret[i]=ins;
        	i++;
        }
        return institutos_ret;
	}
	
	@Override
    public String[] listarActividadesDeportivas(String nombre) {
        ArrayList<String> insActD;
        ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
        insActD = mI.buscarInstitucionDeportiva(nombre).obtenerActividades();
        String[] actIns_ret = new String[insActD.size()];
        int i=0;
        for(String ins:insActD) {
            actIns_ret[i]=ins;
            i++;
        }
        return actIns_ret;
    }
	
	@Override
    public String[] listarProfesores(String nombre) {
        ArrayList<String> insActD;
        ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
        insActD = mI.buscarInstitucionDeportiva(nombre).obtenerProfesores();
        String[] actIns_ret = new String[insActD.size()];
        int i=0;
        for(String ins:insActD) {
            actIns_ret[i]=ins;
            i++;
        }
        return actIns_ret;
    }
	
	
}
