package model;

public class Usuario {

    private String userId;
    private String email;
    private String password;
    private String userType;
    private String name;
    private String lastnames;
    private String birthday;
    private String genre;
    private Boolean active;


    public Usuario(String userId, String email, String password, String userType, String name, String lastnames,
			String birthdate, String genre, Boolean active) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.name = name;
		this.lastnames = lastnames;
		this.birthday = birthdate;
		this.genre = genre;
		this.active = active;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthdate(String birthday) {
		this.birthday = birthday;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}


	@Override
	public String toString() {
		return "Usuario [userId=" + userId + ", email=" + email + ", password=" + password + ", userType=" + userType
				+ ", name=" + name + ", lastnames=" + lastnames + ", birthday=" + birthday + ", genre=" + genre
				+ ", active=" + active + "]";
	}

}