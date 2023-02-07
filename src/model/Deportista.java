package model;

public class Deportista extends Usuario{

	private float peso;
    private float altura;
    private String id_entrenador;

	public Deportista(String userId, String email, String password, String userType, String name, String lastnames,
			String birthdate, String genre, Boolean active) {
        super(userId, email, password, userType, name, lastnames, birthdate, genre, active);
    }
	public Deportista(String userId, String email, String password, String userType, String name, String lastnames,
			String birthdate, String genre, Boolean active, float altura, float peso ) {
        super(userId, email, password, userType, name, lastnames, birthdate, genre, active);
        this.peso = peso;
        this.altura = altura;
    }

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public String getId_entrenador() {
		return id_entrenador;
	}

	public void setId_entrenador(String id_entrenador) {
		this.id_entrenador = id_entrenador;
	}

	@Override
	public String toString() {
		return "Deportista [peso=" + peso + ", altura=" + altura + ", id_entrenador=" + id_entrenador + ", getPeso()="
				+ getPeso() + ", getAltura()=" + getAltura() + ", getId_entrenador()=" + getId_entrenador()
				+ ", getUserId()=" + getUserId() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getUserType()=" + getUserType() + ", getName()=" + getName() + ", getLastnames()=" + getLastnames()
				+ ", getBirthday()=" + getBirthday() + ", getGenre()=" + getGenre() + ", getActive()=" + getActive()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}




}