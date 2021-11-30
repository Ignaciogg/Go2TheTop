package model;

import application.ficheros;

public class Administrador extends Usuario {

	public Administrador(String userId, String email, String password, String userType, String name, String lastnames,
			String birthdate, String genre, Boolean active) {
		super(userId, email, password, userType, name, lastnames, birthdate, genre, active);
	}

	public void borrarUsuario(String dni) {
		
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
	
	public void modificarUsuario (String dni) {
		ficheros files = new ficheros();
		Usuario persona = files.buscarUsuarioId(dni);
		System.out.println("modificar");
		if(persona!=null) {
			
			persona = files.leerUsuario(persona);
			
			switch (persona.getUserType()) {
				case "administrador":
					//files.escribirPersona(persona, "src/files/administradores/" + persona.getUserId() + ".jsonl");
					System.out.println("a");
					System.out.println("USUARIO ESCOGIDO: " + persona.getName());
					
					break;
				case "entrenador":
					//files.escribirPersona(persona, "src/files/entrenadores/" + persona.getUserId() + ".jsonl");
					System.out.println("e");
					System.out.println("USUARIO ESCOGIDO: " + persona.getName());
					break;
				case "deportista":
					//files.escribirPersona(persona, "src/files/deportistas/" + persona.getUserId() + ".jsonl");
					System.out.println("USUARIO ESCOGIDO: " + persona.getName());
					break;
										
			}
						
		}else {
			System.out.println("No hemos encontrado el usuario");
		}
		}

	/*public void confirmarModificarUsuario(String dni, String id,String mail,
			String password, String type, String name, String lastname, String day,
			String gen, Boolean act) {
		ficheros files = new ficheros();
		Usuario persona = files.buscarUsuarioId(dni);
		System.out.println("confirmar");
		System.out.println(dni);

		if(persona!=null) {
			files.eliminarUsuarioLogin(persona.getEmail());

			persona = files.leerUsuario(persona);
			
			switch (persona.getUserType()) {
				case "administrador":
					files.escribirPersona(persona, "src/files/administradores/" + persona.getUserId() + ".jsonl");
					System.out.println("a");
					System.out.println("USUARIO ESCOGIDO: " + persona.getName());
					

					break;
				case "entrenador":
					files.escribirPersona(persona, "src/files/entrenadores/" + persona.getUserId() + ".jsonl");
					System.out.println("e");
					System.out.println("USUARIO ESCOGIDO: " + persona.getName());
					
					break;
				case "deportista":
					files.escribirPersona(persona, "src/files/deportistas/" + persona.getUserId() + ".jsonl");
					System.out.println("USUARIO ESCOGIDO: " + persona.getName());
					
					break;
							
			}
						
		}else {
			System.out.println("No hemos encontrado el usuario");
		}

	}*/
	

	@Override
	public String toString() {
		return "Administrador [getUserId()=" + getUserId() + ", getEmail()=" + getEmail() + ", getPassword()="
				+ getPassword() + ", getUserType()=" + getUserType() + ", getName()=" + getName() + ", getLastnames()="
				+ getLastnames() + ", getBirthday()=" + getBirthday() + ", getGenre()=" + getGenre()
				+ ", getActive()=" + getActive() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

}