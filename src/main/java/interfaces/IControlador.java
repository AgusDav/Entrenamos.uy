package interfaces;

import java.time.LocalDate;
import java.util.ArrayList;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtInstitucionDeportiva;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import logica.InstitucionDeportiva;
import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.ActividadDeportivaRepetidaException;
import excepciones.UsuarioRepetidoException;

//import excepciones.SocioRepetidoExcepcion;

public interface IControlador {
	//public void agregarUsuario(String nickname, String nombre, String apellido, String email, LocalDate fecNac) throws UsuarioRepetidoExcepcion;
	public void altaInstitucion(String nombre,String descripcion, String url) throws InstitucionDeportivaRepetidaException;
	public void altaActividadDeportiva(String nombreIns,DtActividadDeportiva data) throws ActividadDeportivaRepetidaException;
	public void agregarUsuario(DtUsuario user) throws UsuarioRepetidoException;
	
	
	public String[] listarInstitutos();
	public String[] listarActividadesDeportivas(String nombre);
	public String[] listarProfesores(String nombre);
}
