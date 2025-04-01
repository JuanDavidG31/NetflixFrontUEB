package co.edu.unbosque.persistence;

import java.util.ArrayList;
import java.util.List;

public interface CRUDOperation<E, D> {
	public String crear(D nuevoDato);

	public void eliminar(String nuevoDato);

	public void eliminar(int posicionE);

	public void actualizar(D nuevoDato);

	public ArrayList<D> buscarTodo();

	public D buscarUno(int posicionB);

	public E find(E toFind);
}