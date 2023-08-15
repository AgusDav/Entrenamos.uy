package datatypes;

public class DtFecha {
	private int dia;
	private int mes;
	private int anio;
	
	public DtFecha(int d, int m, int a) {
		super();
		this.dia = d;
		this.mes = m;
		this.anio = a;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	@Override
	public String toString() {
		return  dia + "/" + mes + "/ " + anio;
	}
}
