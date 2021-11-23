package model;

import application.ficheros;

public class Administrador extends Usuario {

	public Administrador(String userId, String email, String password, String userType, String name, String lastnames,
			String birthdate, String genre, Boolean active) {
		super(userId, email, password, userType, name, lastnames, birthdate, genre, active);
	}

	public void borrarUsuario(String dni) {
		System.out.println(dni);
		
		ficheros files = new ficheros();
		Usuario persona = files.buscarUsuarioId(dni);
		if(persona!=null) {
			files.eliminarUsuarioLogin(persona.getEmail());
			
			persona = files.leerUsuario(persona);
			persona.setActive(false);
			
			switch (persona.getUserType()) {
				case "administrador":
					files.escribirPersona(persona, "src/files/administradores/" + persona.getUserId() + ".jsonl");
					break;
				case "entrenador":
					files.escribirPersona(persona, "src/files/entrenadores/" + persona.getUserId() + ".jsonl");
					break;
				case "deportista":
					files.escribirPersona(persona, "src/files/deportistas/" + persona.getUserId() + ".jsonl");
					break;
			}
			System.out.println("usuario borrado");
		}else {
			System.out.println("no hemos encontrado el usuario");
		}
		
	}
	
	public void modificarUsuario (String email, String password, String name, String lastnames,
			String birthdate, String genre) {
			
			ficheros files =new ficheros();
			Usuario persona = files.buscarUsuario(email);
			files.eliminarUsuarioLogin(persona.getEmail());
			persona = files.leerUsuario(persona);
				
			persona.setPassword(" ");
			persona.setName(" ");
			persona.setLastnames(" ");
			persona.setBirthdate(" ");
			persona.setGenre(" ");

			switch (persona.getUserType()) {
				case "administrador":
					files.escribirPersona(persona, persona.getPassword());
					files.escribirPersona(persona, persona.getName());
					files.escribirPersona(persona, persona.getLastnames());
					files.escribirPersona(persona, persona.getBirthday());
					files.escribirPersona(persona, persona.getGenre());
					
					break;
				case "entrenador":
					files.escribirPersona(persona, persona.getPassword());
					files.escribirPersona(persona, persona.getName());
					files.escribirPersona(persona, persona.getLastnames());
					files.escribirPersona(persona, persona.getBirthday());
					files.escribirPersona(persona, persona.getGenre());
					
					break;
				case "deportista":
					files.escribirPersona(persona, persona.getPassword());
					files.escribirPersona(persona, persona.getName());
					files.escribirPersona(persona, persona.getLastnames());
					files.escribirPersona(persona, persona.getBirthday());
					files.escribirPersona(persona, persona.getGenre());
					
					break;
					
				}
		
		}

	@Override
	public String toString() {
		return "Administrador [getUserId()=" + getUserId() + ", getEmail()=" + getEmail() + ", getPassword()="
				+ getPassword() + ", getUserType()=" + getUserType() + ", getName()=" + getName() + ", getLastnames()="
				+ getLastnames() + ", getBirthday()=" + getBirthday() + ", getGenre()=" + getGenre()
				+ ", getActive()=" + getActive() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

}