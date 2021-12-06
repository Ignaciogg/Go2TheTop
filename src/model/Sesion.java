package model;

public class Sesion {

    private String sesionId;
    private String userId;
    private float valor1;
    private float valor2;
    private float valor3;
    private float valor4;
    private String fecha;


    public Sesion (String sesionId, String userId, float valor1, float valor2, float valor3, float valor4, String fecha) {
    	this.sesionId = sesionId;
    	this.userId = userId;
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.valor3 = valor3;
        this.valor4 = valor4;
        this.fecha = fecha;
    }

    public String getSesionId() {
		return sesionId;
	}

	public void setSesionId(String sesionId) {
		this.sesionId = sesionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public float getValor1() {
		return valor1;
	}

	public void setValor1(float valor1) {
		this.valor1 = valor1;
	}

	public float getValor2() {
		return valor2;
	}

	public void setValor2(float valor2) {
		this.valor2 = valor2;
	}

	public float getValor3() {
		return valor3;
	}

	public void setValor3(float valor3) {
		this.valor3 = valor3;
	}

	public float getValor4() {
		return valor4;
	}

	public void setValor4(float valor4) {
		this.valor4 = valor4;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}