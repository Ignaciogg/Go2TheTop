package model;

public class Deportista extends Usuario{

	private float peso;
    private float altura;

	public Deportista(String userId, String email, String password, String userType, String name, String lastnames,
			String birthdate, String genre, Boolean active, float peso, float altura) {
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
}