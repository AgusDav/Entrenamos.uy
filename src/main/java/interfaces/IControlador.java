package interfaces;

import java.time.LocalDate;

import logica.InstitucionDeportiva;
import excepciones.InstitucionDeportivaRepetidaException;

//import excepciones.SocioRepetidoExcepcion;

public interface IControlador {
	//public void agregarUsuario(String nickname, String nombre, String apellido, String email, LocalDate fecNac) throws UsuarioRepetidoExcepcion;
	public void altaInstitucion(String nombre,String descripcion, String url) throws InstitucionDeportivaRepetidaException;
}
