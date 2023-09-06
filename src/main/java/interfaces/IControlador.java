package interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtInstitucionDeportiva;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import logica.Clase;
import logica.InstitucionDeportiva;
import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.ActividadDeportivaRepetidaException;
import excepciones.DictadoRepetidoException;
import excepciones.UsuarioRepetidoException;
import excepciones.RegistroAClaseRepetidoException;

//import excepciones.SocioRepetidoExcepcion;

public interface IControlador {
	//public void agregarUsuario(String nickname, String nombre, String apellido, String email, LocalDate fecNac) throws UsuarioRepetidoExcepcion;
	public void altaInstitucion(String nombre,String descripcion, String url) throws InstitucionDeportivaRepetidaException;
	public void altaActividadDeportiva(String nombreIns,DtActividadDeportiva data) throws ActividadDeportivaRepetidaException;
	public void agregarUsuario(DtUsuario user, String inst) throws UsuarioRepetidoException;
	public void altaDictadoClase(DtClase clase, String nomIns, String nomAct, String profe) throws DictadoRepetidoException;
	public void registroADictadoClase(String nick,String clase,Date fechaReg) throws RegistroAClaseRepetidoException;

	
	public String[] listarInstitutos();
	public String[] listarActividadesDeportivas(String nombre);
	public String[] listarProfesores(String nombre);
	public String[] listarSocios(String nombre);
	public String[] listarUsuarios();
	public DtUsuario obtenerUsuario(String nick);
	public DtActividadDeportiva obtenerActividad(String instituto, String actividad);
	public List<Clase> obtenerClases(String instituto, String actividad);
	public String[] listarClases(String instituto, String actividad);
	public String[] listarClases2();	// lista la coleccion de clases sin importar instituto ni actDep
	public DtClase obtenerClase(String nombreClase);
	
}
