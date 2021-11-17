package model;

public class Administrador extends Usuario{

	public Administrador(String userId, String email, String password, String userType, String name, String lastnames,
			String birthdate, String genre, Boolean active) {
        super(userId, email, password, userType, name, lastnames, birthdate, genre, active);
    }

	
	public void borrarUsuario(Usuario user) {
		
	}
}