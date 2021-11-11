package model;

public class Usuario {

    private String userId;
    private String email;
    private String password;
    private String userType;


    public Usuario(String userId, String email, String password, String userType) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

	public Usuario() {

    }

    public String toString() {
    	String salida = "Usuario: ( "+userId+", "+email+", "+password+", "+userType+" )";
    	return salida;
    }


    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}