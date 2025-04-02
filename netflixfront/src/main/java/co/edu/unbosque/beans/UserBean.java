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

@Named("UserBean")
@SessionScoped
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password2;
	private String user;
	private String password;
	private String passwordCheck;

	private String name;
	private String email;
	private String emailIniciar;
	private String emailRecuperar;

	private UserDAO uDao;
	private ExcelDAO eDao;

	ArrayList<UserDTO> Usuario;

	public UserBean() {

		uDao = new UserDAO();
		eDao = new ExcelDAO();
	}

	public void crear() {
		eDao.openCSV("data/Usuario.csv");

	}

	public void nuevoUsuario() {

		System.out.println(uDao.crear(new UserDTO(user, password, name, email)));
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

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

	public String signOut() {
		// Lógica para cerrar sesión
		return "login.xhtml?faces-redirect=true";
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
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

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getEmailIniciar() {
		return emailIniciar;
	}

	public void setEmailIniciar(String emailIniciar) {
		this.emailIniciar = emailIniciar;
	}

	public String getEmailRecuperar() {
		return emailRecuperar;
	}

	public void setEmailRecuperar(String emailRecuperar) {
		this.emailRecuperar = emailRecuperar;
	}

	public UserDAO getuDao() {
		return uDao;
	}

	public void setuDao(UserDAO uDao) {
		this.uDao = uDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
