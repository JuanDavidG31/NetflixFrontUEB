package co.edu.unbosque.persistence;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;

import co.edu.unbosque.model.UserDTO;

public class UserDAO implements CRUDOperation<UserDTO, UserDTO> {

	ArrayList<UserDTO> userList;

	public UserDAO() {
		userList = new ArrayList<>();
	}

	@Override
	public String crear(UserDTO nuevoDato) {

		return ExternalHTTPRequestHandler.doPost("http://localhost:8082/user/crearjson",
				new GsonBuilder().create().toJson(nuevoDato));

	}

	@Override
	public void eliminar(String nuevoDato) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(int posicionE) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(UserDTO nuevoDato) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<UserDTO> buscarTodo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO buscarUno(int posicionB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO find(UserDTO toFind) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<UserDTO> getUserList() {
		userList = new ArrayList<>();
		userList = ExternalHTTPRequestHandler.doGetAllUsuarios("http://localhost:8082/user/showAll");
		return userList;
	}

	public void setUserList(ArrayList<UserDTO> userList) {
		this.userList = userList;
	}

}
