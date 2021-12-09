package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class Sesion {

    private int valorF1;
    private int valorF2;
    private int valorF3;
    private int valorF4;
    private int valorO1;
    private int valorO2;
    private int valorO3;
    private int valorO4;
    private String fecha;


    public Sesion (int valorF1, int valorF2, int valorF3, int valorF4, int valorO1, int valorO2, int valorO3, int valorO4, String fecha) {

        this.valorF1 = valorF1;
        this.valorF2 = valorF2;
        this.valorF3 = valorF3;
        this.valorF4 = valorF4;
        this.valorO1 = valorO1;
        this.valorO2 = valorO2;
        this.valorO3 = valorO3;
        this.valorO4 = valorO4;
        this.fecha = fecha;
    }

	public int getValorF1() {
		return valorF1;
	}

	public void setValorF1(int valorF1) {
		this.valorF1 = valorF1;
	}

	public int getValorF2() {
		return valorF2;
	}

	public void setValorF2(int valorF2) {
		this.valorF2 = valorF2;
	}

	public int getValorF3() {
		return valorF3;
	}

	public void setValorF3(int valorF3) {
		this.valorF3 = valorF3;
	}

	public int getValorF4() {
		return valorF4;
	}

	public void setValorF4(int valorF4) {
		this.valorF4 = valorF4;
	}

	public int getValorO1() {
		return valorO1;
	}

	public void setValorO1(int valorO1) {
		this.valorO1 = valorO1;
	}

	public int getValorO2() {
		return valorO2;
	}

	public void setValorO2(int valorO2) {
		this.valorO2 = valorO2;
	}

	public int getValorO3() {
		return valorO3;
	}

	public void setValorO3(int valorO3) {
		this.valorO3 = valorO3;
	}

	public int getValorO4() {
		return valorO4;
	}

	public void setValorO4(int valorO4) {
		this.valorO4 = valorO4;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Sesion leerSesion(String ruta) {

		Sesion sesion = null;
		try {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			sesion = gson.fromJson(br.readLine(), Sesion.class);
			br.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return sesion;

	}
}