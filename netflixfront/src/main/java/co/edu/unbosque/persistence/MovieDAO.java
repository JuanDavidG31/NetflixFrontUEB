package co.edu.unbosque.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.MovieDTO;

public class MovieDAO implements CRUDOperation<MovieDTO, MovieDTO> {

	ArrayList<MovieDTO> movieLista;

	public MovieDAO() {
		movieLista = new ArrayList<>();
	}

	@Override
	public String crear(MovieDTO nuevoDato) {
		// TODO Auto-generated method stub
		return null;
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
	public void actualizar(MovieDTO nuevoDato) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<MovieDTO> buscarTodo() {

		return ExternalHTTPRequestHandler.doGetAllMovies("http://localhost:8082/movie/showAll");
	}

	@Override
	public MovieDTO buscarUno(int posicionB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieDTO find(MovieDTO toFind) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<MovieDTO> getMovieLista() {
		return movieLista;
	}

	public void setMovieLista(ArrayList<MovieDTO> movieLista) {
		this.movieLista = movieLista;
	}

}
