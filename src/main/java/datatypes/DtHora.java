package datatypes;

public class DtHora {
	private int hora;
	private int minuto;
	
	public DtHora(int h, int m) {
		super();
		this.hora = h;
		this.minuto = m;
	}
	public int getMinuto() {
		return minuto;
	}
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	@Override
	public String toString() {
		return  hora + ":" + minuto;
	}
}
