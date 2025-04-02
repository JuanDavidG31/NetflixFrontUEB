package co.edu.unbosque.beans;

import java.io.IOException;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import co.edu.unbosque.model.ExcelDTO;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.persistence.ExcelDAO;
import co.edu.unbosque.persistence.UserDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;

import jakarta.faces.context.FacesContext;

import jakarta.inject.Named;
/**
 * Bean que gestiona las interacciones del usuario, incluyendo el registro, inicio de sesión y recuperación de contraseña.
 * Esta clase utiliza DAOs (Objetos de Acceso a Datos) para interactuar con los datos del usuario y de Excel.
 * Es un bean de alcance de sesión, lo que significa que su estado se mantiene a través de múltiples solicitudes dentro de una sesión de usuario.
 */
@Named("UserBean")
@SessionScoped
public class UserBean implements Serializable {

	 /**
     * UID de versión serial para la serialización.
     */
	private static final long serialVersionUID = 1L;
	/**
     * Campo de contraseña secundaria, utilizado para la confirmación de la contraseña.
     */
	private String password2;
	/**
     * Campo de nombre de usuario.
     */
	private String user;
	 /**
     * Campo de contraseña.
     */
	private String password;
	/**
     * Campo de confirmación de contraseña.
     */
	private String passwordCheck;
	/**
     * Campo de nombre del usuario.
     */
	private String name;
	/**
     * Campo de correo electrónico del usuario.
     */
	private String email;
	/**
     * Campo de correo electrónico utilizado para el inicio de sesión.
     */
	private String emailIniciar;
	/**
     * Campo de correo electrónico utilizado para la recuperación de contraseña.
     */
	private String emailRecuperar;
	/**
     * Objeto de Acceso a Datos para entidades de Usuario.
     */
	private UserDAO uDao;
	/**
     * Objeto de Acceso a Datos para entidades de Excel.
     */
	private ExcelDAO eDao;
	/**
     * Lista de objetos UserDTO.
     */
	ArrayList<UserDTO> Usuario;
	/**
     * Constructor para UserBean. Inicializa UserDAO y ExcelDAO.
     */
	public UserBean() {

		uDao = new UserDAO();
		eDao = new ExcelDAO();
	}
	/**
     * Abre el archivo CSV para los datos del usuario.
     */
	public void crear() {
		eDao.openCSV("data/Usuario.csv");

	}
	/**
     * Crea un nuevo usuario y redirige a la página de inicio.
     */
	public void nuevoUsuario() {

		System.out.println(uDao.crear(new UserDTO(user, password, name, email)));
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
     * Inicia sesión del usuario, registra la hora de inicio de sesión y redirige a la página del menú.
     */
	public void iniciarSesion() {
		ArrayList<UserDTO> userList = uDao.getUserList();
		for (UserDTO u : userList) {
			String tusuario = u.getUser();
			String temail = u.getEmail();
			String tpassword = u.getPassword();

			if ((tusuario.equals(email) || temail.equals(email)) && tpassword.equals(password)) {

				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("menu.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}

				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				String formattedDate = now.format(formatter);

				ExcelDTO nuevoUsuario = new ExcelDTO(tusuario, formattedDate);
				System.out.println(eDao.crear(nuevoUsuario));

				eDao.exportToCSV("data/Usuario.csv", nuevoUsuario);

				break;
			}
		}

	}
	/**
     * Inicia el proceso de recuperación de contraseña redirigiendo a la página de nueva contraseña si se encuentra el correo electrónico/nombre de usuario.
     * Muestra un mensaje de error si el correo electrónico/nombre de usuario es incorrecto.
     */
	public void recuperar() {
		Usuario = new ArrayList<>();
		Usuario = uDao.getUserList();
		for (UserDTO u : Usuario) {
			String tEmail = u.getEmail();
			String tusuario = u.getUser();
			if (tEmail.equals(email) || tusuario.equals(email)) {
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("newPassword.xhtml");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

				continue;
			}

		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "ID incorrecto."));
	}
	/**
     * Cambia la contraseña del usuario si las nuevas contraseñas coinciden y redirige a la página de inicio.
     */
	public void cambiarContrasegna() {
		Usuario = new ArrayList<>();
		Usuario = uDao.getUserList();

		for (UserDTO u : Usuario) {

			String tEmail = u.getEmail();
			String tusuario = u.getUser();

			if (tEmail.equals(email) || tusuario.equals(email)) {

				if (password.equals(passwordCheck)) {
					UserDTO usuarioNuevo = new UserDTO(null, password, null, u.getEmail());

					uDao.actualizar2(usuarioNuevo);

					try {
						FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				break;
			}

		}
	}
	/**
     * Cierra la sesión del usuario y redirige a la página de inicio de sesión.
     * @return El resultado de la navegación.
     */
	public String signOut() {
		// Lógica para cerrar sesión
		return "login.xhtml?faces-redirect=true";
	}
	 /**
     * Obtiene la contraseña secundaria.
     * @return La contraseña secundaria.
     */
	public String getPassword2() {
		return password2;
	}
	/**
     * Establece la contraseña secundaria.
     * @param password2 La contraseña secundaria a establecer.
     */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	/**
     * Obtiene el nombre de usuario.
     * @return El nombre de usuario.
     */
	public String getUser() {
		return user;
	}
	/**
     * Establece el nombre de usuario.
     * @param user El nombre de usuario a establecer.
     */
	public void setUser(String user) {
		this.user = user;
	}
	/**
     * Obtiene la contraseña.
     * @return La contraseña.
     */
	public String getPassword() {
		return password;
	}
	/**
     * Establece la contraseña.
     * @param password La contraseña a establecer.
     */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
     * Obtiene el nombre del usuario.
     * @return El nombre del usuario.
     */
	public String getName() {
		return name;
	}
	 /**
     * Establece el nombre del usuario.
     * @param name El nombre del usuario a establecer.
     */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * Obtiene el correo electrónico del usuario.
     * @return El correo electrónico del usuario.
     */
	public String getEmail() {
		return email;
	}
	/**
     * Establece el correo electrónico del usuario.
     * @param email El correo electrónico del usuario a establecer.
     */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
     * Obtiene la confirmación de la contraseña.
     * @return La confirmación de la contraseña.
     */
	public String getPasswordCheck() {
		return passwordCheck;
	}
	/**
     * Establece la confirmación de la contraseña.
     * @param passwordCheck La confirmación de la contraseña a establecer.
     */
	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}
	/**
     * Obtiene el correo electrónico de inicio de sesión.
     * @return El correo electrónico de inicio de sesión.
     */
	public String getEmailIniciar() {
		return emailIniciar;
	}
	/**
     * Establece el correo electrónico de inicio de sesión.
     * @param emailIniciar El correo electrónico de inicio de sesión a establecer.
     */
	public void setEmailIniciar(String emailIniciar) {
		this.emailIniciar = emailIniciar;
	}
	/**
     * Obtiene el correo electrónico de recuperación.
     * @return El correo electrónico de recuperación.
     */
	public String getEmailRecuperar() {
		return emailRecuperar;
	}
	/**
     * Establece el correo electrónico de recuperación.
     * @param emailRecuperar El correo electrónico de recuperación a establecer.
     */
	public void setEmailRecuperar(String emailRecuperar) {
		this.emailRecuperar = emailRecuperar;
	}
	/**
     * Obtiene la instancia de UserDAO.
     * @return La instancia de UserDAO.
     */
	public UserDAO getuDao() {
		return uDao;
	}
	/**
     * Establece la instancia de UserDAO.
     * @param uDao La instancia de UserDAO a establecer.
     */
	public void setuDao(UserDAO uDao) {
		this.uDao = uDao;
	}
	/**
     * Obtiene el UID de versión serial.
     * @return El UID de versión serial.
     */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
