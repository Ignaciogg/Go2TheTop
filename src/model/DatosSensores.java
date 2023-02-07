package model;

public class DatosSensores {

	private int id_Dato;
	private int id_Sesion;
	private String sensor;
    private String fecha;
    private String valor;

	public DatosSensores(int id_Dato, int id_Sesion, String sensor, String fecha, String valor) {
		this.id_Dato = id_Dato;
		this.id_Sesion = id_Sesion;
		this.sensor = sensor;
		this.fecha = fecha;
		this.valor = valor;
	}


	public int getId_Dato() {
		return id_Dato;
	}
	public void setId_Dato(int id_Dato) {
		this.id_Dato = id_Dato;
	}
	public int getId_Sesion() {
		return id_Sesion;
	}
	public void setId_Sesion(int id_Sesion) {
		this.id_Sesion = id_Sesion;
	}
	public String getSensor() {
		return sensor;
	}
	public void setSensor(String sensor) {
		this.sensor = sensor;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "DatosSensores [id_Dato=" + id_Dato + ", id_Sesion=" + id_Sesion + ", sensor=" + sensor + ", fecha="
				+ fecha + ", valor=" + valor + "]";
	}

}