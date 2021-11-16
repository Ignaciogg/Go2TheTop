package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

import model.Administrador;
import model.Deportista;
import model.Entrenador;
import model.Usuario;

public class ficheros {

	public Usuario IniciarSesion (String email, String password) {
		Usuario persona = buscarUsuario(email);
		
		if (persona != null && persona.getPassword().equals(password)) {
			
			switch (persona.getUserType()) { // Seleccionar la ruta
				case "administrador":
					persona = leerAdministrador("src/files/administradores/" + persona.getUserId() + ".jsonl");
					break;
	
				case "entrenador":
					persona = leerAdministrador("src/files/entrenadores/" + persona.getUserId() + ".jsonl");
					break;
	
				case "deportista":
					persona = leerAdministrador("src/files/deportistas/" + persona.getUserId() + ".jsonl");
					break;
			}
		}
		return persona;
	}

	public Usuario buscarUsuario(String email) {
		Gson gson = new Gson();
		Usuario persona = null;

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/files/login.jsonl"));
			String linea;
			Boolean encontrado = false;
			while ((linea = br.readLine()) != null && !encontrado) {
				persona = gson.fromJson(linea, Usuario.class);
				if (persona.getEmail().equalsIgnoreCase(email)) {
					encontrado = true;
				}
			}
			br.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return persona;
	}

	public Administrador leerAdministrador(String ruta) {
		Administrador persona = null;
		try {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			persona = gson.fromJson(br.readLine(), Administrador.class);
			br.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return persona;
	}

	public Entrenador leerEntrenador(String ruta) {
		Entrenador persona = null;
		try {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			persona = gson.fromJson(br.readLine(), Entrenador.class);
			br.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return persona;
	}

	public Deportista leerDeportista(String ruta) {
		Deportista persona = null;
		try {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			persona = gson.fromJson(br.readLine(), Deportista.class);
			br.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return persona;
	}

}
