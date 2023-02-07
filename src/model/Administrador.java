package model;

import application.BBDD;

public class Administrador extends Usuario {

	public Administrador(String userId, String email, String password, String userType, String name, String lastnames,
			String birthdate, String genre, Boolean active) {
		super(userId, email, password, userType, name, lastnames, birthdate, genre, active);
	}

	public void borrarUsuario(String dni) {
		
		BBDD bd = new BBDD();
		Usuario persona = bd.buscarUsuarioid(dni);
		if(persona!=null) {
			bd.eliminarUsuario(persona.getUserId());
			System.out.println("usuario borrado");
		}else {
			System.out.println("no hemos encontrado el usuario");
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