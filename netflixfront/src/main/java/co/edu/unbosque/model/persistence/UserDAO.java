package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.UserDTO;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/**
 * Clase que implementa la interfaz CRUDOperation para la manipulación de datos de UserDTO. Esta
 * clase proporciona métodos para realizar operaciones CRUD en objetos UserDTO, utilizando una API
 * HTTP externa para interactuar con los datos de usuarios.
 */
public class UserDAO implements CRUDOperation<UserDTO, UserDTO> {
  /** Lista de objetos UserDTO. */
  ArrayList<UserDTO> userList;

  /** Constructor para UserDAO. Inicializa la lista de usuarios. */
  public UserDAO() {
    userList = new ArrayList<>();
  }

  /**
   * Crea un nuevo registro de UserDTO enviando una solicitud POST a una API HTTP externa.
   *
   * @param nuevoDato El objeto UserDTO a crear.
   * @return La respuesta de la API HTTP como una cadena.
   */
  @Override
  public String crear(UserDTO nuevoDato) {

    return ExternalHTTPRequestHandler.doPost(
        "http://localhost:8082/user/crearjson", new GsonBuilder().create().toJson(nuevoDato));
  }

  /**
   * Elimina un registro de UserDTO basado en una cadena de identificación. (Método no
   * implementado).
   *
   * @param nuevoDato La cadena que identifica el registro a eliminar.
   */
  @Override
  public void eliminar(String nuevoDato) {
    // TODO Auto-generated method stub

  }

  /**
   * Elimina un registro de UserDTO basado en su posición en la lista. (Método no implementado).
   *
   * @param posicionE La posición del registro a eliminar.
   */
  @Override
  public void eliminar(int posicionE) {
    // TODO Auto-generated method stub

  }

  /**
   * Actualiza un registro de UserDTO existente. (Método no implementado).
   *
   * @param nuevoDato El objeto UserDTO con los datos actualizados.
   */
  @Override
  public void actualizar(UserDTO nuevoDato) {
    // TODO Auto-generated method stub

  }

  /**
   * Actualiza un registro de UserDTO enviando una solicitud PUT a una API HTTP externa.
   *
   * @param nuevoDato El objeto UserDTO con los datos actualizados.
   * @return La respuesta de la API HTTP como una cadena.
   */
  public String actualizar2(UserDTO nuevoDato) {
    return ExternalHTTPRequestHandler.doPut(
        "http://localhost:8082/user/actualizarjson", new GsonBuilder().create().toJson(nuevoDato));
  }

  /**
   * Busca y devuelve todos los registros de UserDTO. (Método no implementado).
   *
   * @return Una lista de todos los registros de UserDTO.
   */
  @Override
  public ArrayList<UserDTO> buscarTodo() {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * Busca y devuelve un registro de UserDTO basado en su posición en la lista. (Método no
   * implementado).
   *
   * @param posicionB La posición del registro a buscar.
   * @return null.
   */
  @Override
  public UserDTO buscarUno(int posicionB) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * Busca y devuelve un registro de UserDTO basado en un objeto de búsqueda. (Método no
   * implementado).
   *
   * @param toFind El objeto UserDTO a buscar.
   * @return null.
   */
  @Override
  public UserDTO find(UserDTO toFind) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * Obtiene la lista de usuarios, recuperándola de una API HTTP externa.
   *
   * @return La lista de usuarios.
   */
  public ArrayList<UserDTO> getUserList() {
    userList = new ArrayList<>();
    userList = ExternalHTTPRequestHandler.doGetAllUsuarios("http://localhost:8082/user/showAll");
    return userList;
  }

  /**
   * Establece la lista de usuarios.
   *
   * @param userList La lista de usuarios a establecer.
   */
  public void setUserList(ArrayList<UserDTO> userList) {
    this.userList = userList;
  }
}
