package co.edu.unbosque.model;


public class UserDTO {

	private Integer id;
	private String user;
	private String password;
	private String name;
	private String email;

	public UserDTO() {
	}

	public UserDTO(String user, String password, String name, String email) {
		super();
		this.user = user;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", user=" + user + ", password=" + password + ", name=" + name + ", email=" + email
				+ "]";
	}

}
