package datatypes;

public class DtUsuario {
	private String nickname;
	private String nombre;	
	private String apellido;
	private String email;
	private DtFecha fecNac;
	
	public DtUsuario(String n, String nom, String a, String e, DtFecha f) {
		super();
		this.nickname = n;
		this.nombre = nom;
		this.apellido = a;
		this.email = e;
		this.fecNac = f;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public DtFecha getFecNac() {
		return fecNac;
	}
	public void setFecNac(DtFecha fecNac) {
		this.fecNac = fecNac;
	}
	@Override
	public String toString() {
		return "Nickname: " + nickname + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nEmail: " + email + "\nFecha nacimiento: " + fecNac;
	}
}
	
	