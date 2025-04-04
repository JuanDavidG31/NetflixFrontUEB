package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.MovieDTO;

/**
 * Clase que implementa la interfaz CRUDOperation para la manipulación de datos
 * de MovieDTO. Esta clase proporciona métodos para realizar operaciones CRUD en
 * objetos MovieDTO, utilizando una API HTTP externa para recuperar la lista de
 * películas.
 */
public class MovieDAO implements CRUDOperation<MovieDTO, MovieDTO> {
	/**
	 * Lista de objetos MovieDTO.
	 */
	ArrayList<MovieDTO> movieLista;

	/**
	 * Constructor para MovieDAO. Inicializa la lista de películas.
	 */
	public MovieDAO() {
		movieLista = new ArrayList<>();
	}

	/**
	 * Crea un nuevo registro de MovieDTO. (Método no implementado).
	 *
	 * @param nuevoDato El objeto MovieDTO a crear.
	 * @return null.
	 */
	@Override
	public String crear(MovieDTO nuevoDato) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Elimina un registro de MovieDTO basado en una cadena de identificación.
	 * (Método no implementado).
	 *
	 * @param nuevoDato La cadena que identifica el registro a eliminar.
	 */
	@Override
	public void eliminar(String nuevoDato) {
		// TODO Auto-generated method stub

	}

	/**
	 * Elimina un registro de MovieDTO basado en su posición en la lista. (Método no
	 * implementado).
	 *
	 * @param posicionE La posición del registro a eliminar.
	 */
	@Override
	public void eliminar(int posicionE) {
		// TODO Auto-generated method stub

	}

	/**
	 * Actualiza un registro de MovieDTO existente. (Método no implementado).
	 *
	 * @param nuevoDato El objeto MovieDTO con los datos actualizados.
	 */
	@Override
	public void actualizar(MovieDTO nuevoDato) {
		// TODO Auto-generated method stub

	}

	/**
	 * Busca y devuelve todos los registros de MovieDTO, recuperándolos de una API
	 * HTTP externa.
	 *
	 * @return Una lista de todos los registros de MovieDTO.
	 */
	@Override
	public ArrayList<MovieDTO> buscarTodo() {

		return ExternalHTTPRequestHandler.doGetAllMovies("http://localhost:8082/movie/showAll");
	}

	/**
	 * Busca y devuelve un registro de MovieDTO basado en su posición en la lista.
	 * (Método no implementado).
	 *
	 * @param posicionB La posición del registro a buscar.
	 * @return null.
	 */
	@Override
	public MovieDTO buscarUno(int posicionB) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Busca y devuelve un registro de MovieDTO basado en un objeto de búsqueda.
	 * (Método no implementado).
	 *
	 * @param toFind El objeto MovieDTO a buscar.
	 * @return null.
	 */
	@Override
	public MovieDTO find(MovieDTO toFind) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Obtiene la lista de películas.
	 *
	 * @return La lista de películas.
	 */
	public ArrayList<MovieDTO> getMovieLista() {
		return movieLista;
	}

	/**
	 * Establece la lista de películas.
	 *
	 * @param movieLista La lista de películas a establecer.
	 */
	public void setMovieLista(ArrayList<MovieDTO> movieLista) {
		this.movieLista = movieLista;
	}

}
