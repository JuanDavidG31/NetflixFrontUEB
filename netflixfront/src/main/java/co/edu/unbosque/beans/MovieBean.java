package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.model.MovieDTO;
import co.edu.unbosque.persistence.MovieDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.inject.Named;

@Named("MovieBean")
@SessionScoped
public class MovieBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<MovieDTO> peliculas;
	private ArrayList<MovieDTO> peliculasTerror;
	private ArrayList<MovieDTO> peliculasAnimacion;
	private ArrayList<MovieDTO> peliculasRomance;
	private final String TERROR = "Terror";
	private final String ANIMACION = "Animación";
	private final String ROMANCE = "Romance";
	private MovieDAO mDao;

	public MovieBean() {

		mDao = new MovieDAO();
		recargarPeliculas();

	}

	public void recargarPeliculas() {

		peliculasTerror = new ArrayList<>();
		peliculasAnimacion = new ArrayList<>();
		peliculasRomance = new ArrayList<>();

		peliculas = new ArrayList<>();
		peliculas = mDao.buscarTodo();

		for (MovieDTO m : peliculas) {
			if (m.getGenero().equals(TERROR)) {
				peliculasTerror.add(new MovieDTO(m.getUrl(), m.getNombre(), m.getGenero()));
			} else if (m.getGenero().equals(ANIMACION)) {
				peliculasAnimacion.add(new MovieDTO(m.getUrl(), m.getNombre(), m.getGenero()));
			} else if (m.getGenero().equals(ROMANCE)) {
				peliculasRomance.add(new MovieDTO(m.getUrl(), m.getNombre(), m.getGenero()));
			}
		}

	}

	public ArrayList<MovieDTO> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(ArrayList<MovieDTO> peliculas) {
		this.peliculas = peliculas;
	}

	public ArrayList<MovieDTO> getPeliculasTerror() {
		return peliculasTerror;
	}

	public void setPeliculasTerror(ArrayList<MovieDTO> peliculasTerror) {
		this.peliculasTerror = peliculasTerror;
	}

	public ArrayList<MovieDTO> getPeliculasAnimacion() {
		return peliculasAnimacion;
	}

	public void setPeliculasAnimacion(ArrayList<MovieDTO> peliculasAnimacion) {
		this.peliculasAnimacion = peliculasAnimacion;
	}

	public ArrayList<MovieDTO> getPeliculasRomance() {
		return peliculasRomance;
	}

	public void setPeliculasRomance(ArrayList<MovieDTO> peliculasRomance) {
		this.peliculasRomance = peliculasRomance;
	}

	public MovieDAO getmDao() {
		return mDao;
	}

	public void setmDao(MovieDAO mDao) {
		this.mDao = mDao;
	}

	public String getTERROR() {
		return TERROR;
	}

	public String getANIMACION() {
		return ANIMACION;
	}

	public String getROMANCE() {
		return ROMANCE;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
