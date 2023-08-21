package datatypes;

import java.time.LocalDate;

public class DtProfesor extends DtUsuario{
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	
	public DtProfesor(String n, String nom, String a, String e, LocalDate f, String d, String b, String w) {
		super(n, nom, a, e, f);
		this.biografia = b;
		this.descripcion = d;
		this.sitioWeb = w;	
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public String getSitioWeb() {
		return sitioWeb;
	}
	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}
	@Override
	public String toString() {
		return super.toString() + "\nDescripcion: " + descripcion + "\nBiografia: " + biografia + "\nSitio web: " + sitioWeb;
	}

}
