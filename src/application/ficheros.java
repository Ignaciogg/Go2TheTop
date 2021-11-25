package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import model.Administrador;
import model.Deportista;
import model.Entrenador;
import model.Usuario;

public class ficheros {

	public Usuario IniciarSesion(String email, String password) {
		Usuario persona = buscarUsuario(email);

		if (persona != null && persona.getPassword().equals(password)) {
			return leerUsuario(persona);
		}else {
			return null;
		}
	}

	public Usuario buscarUsuario(String email) {
		Gson gson = new Gson();
		Usuario persona = null;
		Usuario personaBuscada = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/files/login.jsonl"));
			String linea;
			
			Boolean encontrado = false;
			while ((linea = br.readLine()) != null && !encontrado) {
				persona = gson.fromJson(linea, Usuario.class);
				if (persona.getEmail().equalsIgnoreCase(email)) {
					encontrado = true;
					personaBuscada=persona;
				}
			}
			br.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return personaBuscada;
	}
	
	public Usuario buscarUsuarioId(String dni) {
		Gson gson = new Gson();
		Usuario persona = null;

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/files/login.jsonl"));
			String linea;
			Boolean encontrado = false;
			while ((linea = br.readLine()) != null && !encontrado) {
				persona = gson.fromJson(linea, Usuario.class);
				if (persona.getUserId().equalsIgnoreCase(dni)) {
					encontrado = true;
				}
			}
			br.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return persona;
	}
	
	public Usuario leerUsuario(Usuario persona) {
		switch (persona.getUserType()) { // Seleccionar la ruta
			case "administrador":
				persona = leerAdministrador("src/files/administradores/" + persona.getUserId() + ".jsonl");
				break;
			case "entrenador":
				persona = leerEntrenador("src/files/entrenadores/" + persona.getUserId() + ".jsonl");
				break;
			case "deportista":
				persona = leerDeportista("src/files/deportistas/" + persona.getUserId() + ".jsonl");
				break;
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

	public void escribirLogin(Usuario user) {
		Gson gson = new Gson();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/files/login.jsonl", true));
			bw.newLine();
			bw.append(gson.toJson(user));
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void escribirPersona(Usuario nuevo, String ruta) {
		Gson gson = new Gson();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
			bw.write(gson.toJson(nuevo));
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean eliminarUsuarioLogin(String email) {
		Gson gson = new Gson();
		Usuario persona = null;
		File ficheroViejo = new File("src/files/login.jsonl");
		File ficheroNuevo = new File("src/files/login2.jsonl");
		try {
			BufferedReader br = new BufferedReader(new FileReader(ficheroViejo));
			BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroNuevo, true));

			String linea;
			while ((linea = br.readLine()) != null) {
				persona = gson.fromJson(linea, Usuario.class);
				if (!persona.getEmail().equalsIgnoreCase(email)) {
					bw.append(gson.toJson(persona));
					bw.flush();
					bw.newLine();
				}
			}
			br.close();
			bw.close();
			System.out.println("fichero viejo duplicado");
			if (ficheroViejo.delete()) { // Aqui­ deberia eliminar el original
				System.out.println("fichero viejo eliminado");
				File renombrar = new File("src/files/login.jsonl");
				if (ficheroNuevo.renameTo(renombrar)) { // Aqui deberia renombrarlo al nombre original
					System.out.println("fichero renombrado");
					return true;
				} else {
					System.out.println("error al renombrar fichero");
				}
			} else {
				System.out.println("error al eliminar fichero");
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return false;
	}

}
