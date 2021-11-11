package model;

public class Usuario {

    private String userId;
    private String email;
    private String password;
    private String userType;
    private String name;
    private String lastnames;
    private String birthdate;
    private String genre;


    public Usuario(String userId, String email, String password, String userType) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }


    public Usuario(String userId, String email, String password, String userType, String name, String lastnames,
			String birthdate, String genre) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.name = name;
		this.lastnames = lastnames;
		this.birthdate = birthdate;
		this.genre = genre;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastnames() {
		return lastnames;
	}


	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}


	public String getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}

	

}