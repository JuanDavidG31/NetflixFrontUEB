package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.List;

/**
 * Interfaz genérica para operaciones CRUD (Crear, Leer, Actualizar, Eliminar).
 * Define los métodos básicos para la manipulación de datos de tipo D, y la
 * búsqueda de entidades de tipo E.
 *
 * @param <E> El tipo de entidad que se busca.
 * @param <D> El tipo de Data Transfer Object (DTO) que se manipula.
 */
public interface CRUDOperation<E, D> {
	/**
	 * Crea un nuevo registro de datos.
	 *
	 * @param nuevoDato El DTO que contiene los datos a crear.
	 * @return Un mensaje indicando el resultado de la operación.
	 */
	public String crear(D nuevoDato);

	/**
	 * Elimina un registro de datos basado en una cadena de identificación.
	 *
	 * @param nuevoDato La cadena que identifica el registro a eliminar.
	 */

	public void eliminar(String nuevoDato);

	/**
	 * Elimina un registro de datos basado en su posición en la lista.
	 *
	 * @param posicionE La posición del registro a eliminar.
	 */

	public void eliminar(int posicionE);

	/**
	 * Actualiza un registro de datos existente.
	 *
	 * @param nuevoDato El DTO que contiene los datos actualizados.
	 */
	public void actualizar(D nuevoDato);

	/**
	 * Busca y devuelve todos los registros de datos.
	 *
	 * @return Una lista de todos los DTOs.
	 */
	public ArrayList<D> buscarTodo();

	/**
	 * Busca y devuelve un registro de datos basado en su posición en la lista.
	 *
	 * @param posicionB La posición del registro a buscar.
	 * @return El DTO encontrado, o null si no se encuentra.
	 */
	public D buscarUno(int posicionB);

	/**
	 * Busca y devuelve una entidad basada en un objeto de búsqueda.
	 *
	 * @param toFind El objeto de búsqueda.
	 * @return La entidad encontrada, o null si no se encuentra.
	 */
	public E find(E toFind);
}