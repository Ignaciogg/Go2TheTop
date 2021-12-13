package model;
import model.*;

public class ChatDeportista {

	private String entrenadorID;
	private String deportistaID;
    private String textoDeportista;

    /*public ChatDeportista() {
    	this.textoDeportista = null;
    }*/


	public ChatDeportista(String entrenadorID, String deportistaID, String textoDeportista) {
		this.deportistaID=deportistaID;
		this.entrenadorID=entrenadorID;
		this.textoDeportista = textoDeportista;
		
	}

	public String getTextoDeportista() {
		return textoDeportista;
	}
	public void setTextoDeportista(String textoDeportista) {
		this.textoDeportista = textoDeportista;
	}
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

	
}