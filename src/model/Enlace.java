package model;

public class Enlace {

	private String entrenadorID;
	private String deportistaID;
	
	public String getEntrenadorID() {
		return entrenadorID;
	}
	public void setEntrenadorID(String entrenadorID) {
		this.entrenadorID = entrenadorID;
	}
	public String getDeportistaID() {
		return deportistaID;
	}
	public void setDeportistaID(String deportistaID) {
		this.deportistaID = deportistaID;
	}
	public Enlace(String entrenadorID, String deportistaID) {
		this.entrenadorID = entrenadorID;
		this.deportistaID = deportistaID;
	}
	
}
