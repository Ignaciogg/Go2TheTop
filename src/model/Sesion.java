package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import com.google.gson.Gson;

public class Sesion {

	private int id_Sesion;
	private String id_Deportista;
    private String fecha;
    private String feedback;


	public Sesion(int id_Sesion, String id_Deportista, String fecha, String feedback) {
		this.id_Sesion=id_Sesion;
		this.id_Deportista=id_Deportista;
		this.fecha=fecha;
		this.feedback=feedback;
	}

	public int getId_Sesion() {
		return id_Sesion;
	}

	public void setId_Sesion(int id_Sesion) {
		this.id_Sesion = id_Sesion;
	}

	public String getId_Deportista() {
		return id_Deportista;
	}

	public void setId_Deportista(String id_Deportista) {
		this.id_Deportista = id_Deportista;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

}