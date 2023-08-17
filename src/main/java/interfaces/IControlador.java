package interfaces;

import java.time.LocalDate;

import excepciones.SocioRepetidoExcepcion;

public interface IControlador {
	public void agregarUsuario(String nickname, String nombre, String apellido, String email, LocalDate fecNac) throws UsuarioRepetidoExcepcion;
}
