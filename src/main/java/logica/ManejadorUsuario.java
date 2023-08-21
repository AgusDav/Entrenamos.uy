package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	private List<Usuario> users = new ArrayList<>();

	private ManejadorUsuario(){}
	
	public static ManejadorUsuario getInstancia() {
		if (instancia == null)
			instancia = new ManejadorUsuario();
		return instancia;
	}
	
	public void addUser(Usuario user) {
		users.add(user);
	}

	public Usuario buscarUsuario(String nick){
		Usuario ret = null;
		for(Usuario u: users){
			if(u.getNickname().equals(nick)){
				ret = u;
			}
		}
		return ret;
	}
	
}
