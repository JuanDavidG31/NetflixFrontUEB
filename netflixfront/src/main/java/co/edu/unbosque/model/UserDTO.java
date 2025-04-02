package co.edu.unbosque.model;

/**
 * Data Transfer Object (DTO) para representar datos de usuario. Esta clase se
 * utiliza para transferir datos de usuario entre diferentes capas de la
 * aplicación.
 */
public class UserDTO {
	/**
	 * Identificador único del usuario.
	 */
	private Integer id;
	/**
	 * Nombre de usuario.
	 */
	private String user;
	/**
	 * Contraseña del usuario.
	 */
	private String password;
	/**
	 * Nombre completo del usuario.
	 */
	private String name;
	/**
	 * Correo electrónico del usuario.
	 */
	private String email;

	/**
	 * Constructor predeterminado sin argumentos.
	 */
	public UserDTO() {
	}

	/**
	 * Constructor con argumentos para inicializar los campos de nombre de usuario,
	 * contraseña, nombre completo y correo electrónico del usuario.
	 * 
	 * @param user     Nombre de usuario.
	 * @param password Contraseña del usuario.
	 * @param name     Nombre completo del usuario.
	 * @param email    Correo electrónico del usuario.
	 */
	public UserDTO(String user, String password, String name, String email) {
		super();
		this.user = user;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	/**
	 * Obtiene el identificador del usuario.
	 * 
	 * @return El identificador del usuario.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Establece el identificador del usuario.
	 * 
	 * @param id El identificador del usuario a establecer.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre de usuario.
	 * 
	 * @return El nombre de usuario.
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Establece el nombre de usuario.
	 * 
	 * @param user El nombre de usuario a establecer.
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Obtiene la contraseña del usuario.
	 * 
	 * @return La contraseña del usuario.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Establece la contraseña del usuario.
	 * 
	 * @param password La contraseña del usuario a establecer.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Obtiene el nombre completo del usuario.
	 * 
	 * @return El nombre completo del usuario.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre completo del usuario.
	 * 
	 * @param name El nombre completo del usuario a establecer.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene el correo electrónico del usuario.
	 * 
	 * @return El correo electrónico del usuario.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Establece el correo electrónico del usuario.
	 * 
	 * @param email El correo electrónico del usuario a establecer.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Devuelve una representación en cadena del objeto UserDTO.
	 * 
	 * @return Una cadena que representa el objeto UserDTO.
	 */
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", user=" + user + ", password=" + password + ", name=" + name + ", email=" + email
				+ "]";
	}

}
