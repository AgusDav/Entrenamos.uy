package logica;

import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.UsuarioRepetidoException;
import excepciones.ActividadDeportivaRepetidaException;
import excepciones.DictadoRepetidoException;
import excepciones.RegistroAClaseRepetidoException;
import interfaces.IControlador;
import persistencia.Conexion;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

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
		
		if(i.buscarActividad2(data.getNombre())) {
			throw new ActividadDeportivaRepetidaException("La actividad deportiva " + data.getNombre() + " ya existe");
		}
		else {
			i.agregarActividadDeportiva(data);
			Conexion conexion = Conexion.getInstancia();
			EntityManager em = conexion.getEntityManager();
			em.getTransaction().begin();
			em.persist(i);
			em.getTransaction().commit();
		}
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
			//Date fecha = Date.from(user.getFecNac().atStartOfDay(ZoneId.systemDefault()).toInstant());
			nuevoUser = new Profesor(user.getNickname(),user.getNombre(),user.getApellido(),user.getEmail(),user.getFecNac(),((DtProfesor) user).getDescripcion(),((DtProfesor) user).getBiografia(),((DtProfesor) user).getSitioWeb(), inst); 
			inst.agregarProfesor((Profesor) nuevoUser);
		}
		if (user instanceof DtSocio) {
			//Date fecha = Date.from(user.getFecNac().atStartOfDay(ZoneId.systemDefault()).toInstant());
			nuevoUser = new Socio(user.getNickname(),user.getNombre(),user.getApellido(),user.getEmail(),user.getFecNac());
		}
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
		ManejadorClase mC = ManejadorClase.getInstancia();
		Clase cl = (Clase) mC.buscarClase(clase.getNombre());
		
		if(cl!=null) {
			throw new DictadoRepetidoException("La clase " + clase.getNombre() + " ya existe");
		}
		else {
			actD.agregarClase(clase, profesor);
			mC.addClase(actD.obtenerClase(clase.getNombre()));
		}
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
	public String[] listarUsuarios() {
		ArrayList<String> users;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		users = mU.obtenerUsuariosNick();
		String[] ret = new String[users.size()];
		int i = 0;
		for(String ins:users) {
			ret[i] = ins;
			i++;
		}
		return ret;
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

	@Override
    public String[] listarSocios(String nombre) {
        String[] soc;
        ManejadorUsuario mU = ManejadorUsuario.getInstancia();
       	soc = mU.obtenerSocios();
        return soc;
    }
	
	@Override
	public DtUsuario obtenerUsuario(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.buscarUsuario(nick);
		DtUsuario dtU = u.getDtUsuario();
		return dtU;
	}
	
	@Override
	public DtActividadDeportiva obtenerActividad(String instituto, String actividad) {
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva I = mI.buscarInstitucionDeportiva(instituto);
		ActividadDeportiva a = I.buscarActividad(actividad);
		DtActividadDeportiva dtA = a.getDtActividadDeportiva();
		return dtA;
	}
	
	@Override
	public List<Clase> obtenerClases(String instituto, String actividad) {
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva I = mI.buscarInstitucionDeportiva(instituto);
		ActividadDeportiva a = I.buscarActividad(actividad);
		return a.getClases();
	}
	
	@Override
	public String[] listarClases(String instituto, String actividad) {
		ManejadorInstitucion mI = ManejadorInstitucion.getInstancia();
		InstitucionDeportiva I = mI.buscarInstitucionDeportiva(instituto);
		ActividadDeportiva a = I.buscarActividad(actividad);
		List<Clase> c = a.getClases();
		String[] ret = new String[c.size()];
        int i=0;
        for(Clase aux:c) {
            ret[i]=aux.getNombre();
            i++;
        }
        return ret;
	}
	
	@Override
	public void registroADictadoClase(String nick,String clase,Date fechaReg)throws RegistroAClaseRepetidoException{
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario us = mU.buscarUsuario(nick);
		ManejadorClase mC = ManejadorClase.getInstancia();
		Clase clas = mC.buscarClase(clase);
		if(clas.obtenerRegistro(nick)){
			throw new RegistroAClaseRepetidoException("El registro del socio " + nick + " ya existe");
		}
		else{
			Registro reg = new Registro ((Socio)us,clas,fechaReg);
			clas.añadirRegistro(reg);
			us.añadirRegistro(reg);
			Conexion conexion = Conexion.getInstancia();
			EntityManager em = conexion.getEntityManager();
			em.getTransaction().begin();
			em.persist(clas);
			em.getTransaction().commit();
		}
	}
	
	@Override
	public DtClase obtenerClase(String nombreClase){
		ManejadorClase mC = ManejadorClase.getInstancia();
		Clase c = mC.buscarClase(nombreClase);
		DtClase dtC = c.getDtClase();
		return dtC;
	}
}
