package co.edu.unbosque.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import co.edu.unbosque.model.MovieDTO;
import co.edu.unbosque.persistence.MovieDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

/**
 * Bean que gestiona las interacciones relacionadas con las películas. Permite
 * buscar películas, filtrar por género y acceder a los detalles de una
 * película. Es un bean de alcance de sesión, lo que significa que su estado se
 * mantiene a través de múltiples solicitudes dentro de una sesión de usuario.
 */
@Named("MovieBean")
@SessionScoped
public class MovieBean implements Serializable {
	/**
	 * UID de versión serial para la serialización.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Lista de todas las películas.
	 */
	private ArrayList<MovieDTO> peliculas;
	/**
	 * Lista de películas de terror.
	 */
	private ArrayList<MovieDTO> peliculasTerror;
	/**
	 * Lista de películas de animación.
	 */
	private ArrayList<MovieDTO> peliculasAnimacion;
	/**
	 * Lista de películas de romance.
	 */
	private ArrayList<MovieDTO> peliculasRomance;
	/**
	 * Constante para el género "Terror".
	 */
	private final String TERROR = "Terror";
	/**
	 * Constante para el género "Animación".
	 */
	private final String ANIMACION = "Animación";
	/**
	 * Constante para el género "Romance".
	 */
	private final String ROMANCE = "Romance";
	/**
	 * Objeto de Acceso a Datos para entidades de Película.
	 */
	private MovieDAO mDao;
	/**
	 * Término de búsqueda para películas.
	 */
	private String buscar;
	/**
	 * URL de la película seleccionada.
	 */
	private String url;
	/**
	 * Nombre de la película seleccionada.
	 */
	private String nombre;

	/**
	 * Constructor para MovieBean. Inicializa MovieDAO y recarga las películas.
	 */
	public MovieBean() {

		mDao = new MovieDAO();
		recargarPeliculas();

	}

	/**
	 * Recarga las listas de películas, filtrándolas por género.
	 */
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

	/**
	 * Busca una película por nombre y redirige a la página de detalles de la
	 * película si se encuentra. Muestra un mensaje de error si la película no se
	 * encuentra.
	 */
	public void search() {

		peliculas = new ArrayList<>();
		peliculas = mDao.buscarTodo();
		boolean existente = true;

		for (MovieDTO p : peliculas) {
			if (buscar.toLowerCase().equals(p.getNombre().toLowerCase())) {
				this.url = p.getUrl();
				this.nombre = p.getNombre();
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("movie.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
				existente = false;
				this.buscar = null;
				break;
			}
		}

		if (existente) {
			this.buscar = null;

			FacesContext.getCurrentInstance().addMessage("messages",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La pelicula no se encuentra disponible."));
		}

	}

	/**
	 * Obtiene la lista de todas las películas.
	 * 
	 * @return La lista de películas.
	 */
	public ArrayList<MovieDTO> getPeliculas() {
		return peliculas;
	}

	/**
	 * Establece la lista de todas las películas.
	 * 
	 * @param peliculas La lista de películas a establecer.
	 */
	public void setPeliculas(ArrayList<MovieDTO> peliculas) {
		this.peliculas = peliculas;
	}

	/**
	 * Obtiene la lista de películas de terror.
	 * 
	 * @return La lista de películas de terror.
	 */
	public ArrayList<MovieDTO> getPeliculasTerror() {
		return peliculasTerror;
	}

	/**
	 * Establece la lista de películas de terror.
	 * 
	 * @param peliculasTerror La lista de películas de terror a establecer.
	 */
	public void setPeliculasTerror(ArrayList<MovieDTO> peliculasTerror) {
		this.peliculasTerror = peliculasTerror;
	}

	/**
	 * Obtiene la lista de películas de animación.
	 * 
	 * @return La lista de películas de animación.
	 */
	public ArrayList<MovieDTO> getPeliculasAnimacion() {
		return peliculasAnimacion;
	}

	/**
	 * Establece la lista de películas de animación.
	 * 
	 * @param peliculasAnimacion La lista de películas de animación a establecer.
	 */
	public void setPeliculasAnimacion(ArrayList<MovieDTO> peliculasAnimacion) {
		this.peliculasAnimacion = peliculasAnimacion;
	}

	/**
	 * Obtiene la lista de películas de romance.
	 * 
	 * @return La lista de películas de romance.
	 */
	public ArrayList<MovieDTO> getPeliculasRomance() {
		return peliculasRomance;
	}

	/**
	 * Establece la lista de películas de romance.
	 * 
	 * @param peliculasRomance La lista de películas de romance a establecer.
	 */
	public void setPeliculasRomance(ArrayList<MovieDTO> peliculasRomance) {
		this.peliculasRomance = peliculasRomance;
	}

	/**
	 * Obtiene la instancia de MovieDAO.
	 * 
	 * @return La instancia de MovieDAO.
	 */
	public MovieDAO getmDao() {
		return mDao;
	}

	/**
	 * Establece la instancia de MovieDAO.
	 * 
	 * @param mDao La instancia de MovieDAO a establecer.
	 */
	public void setmDao(MovieDAO mDao) {
		this.mDao = mDao;
	}

	/**
	 * Obtiene la constante para el género "Terror".
	 * 
	 * @return La constante "Terror".
	 */
	public String getTERROR() {
		return TERROR;
	}

	/**
	 * Obtiene la constante para el género "Animación".
	 * 
	 * @return La constante "Animación".
	 */
	public String getANIMACION() {
		return ANIMACION;
	}

	/**
	 * Obtiene la constante para el género "Romance".
	 * 
	 * @return La constante "Romance".
	 */
	public String getROMANCE() {
		return ROMANCE;
	}

	/**
	 * Obtiene el UID de versión serial.
	 * 
	 * @return El UID de versión serial.
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Obtiene el término de búsqueda.
	 * 
	 * @return El término de búsqueda.
	 */
	public String getBuscar() {
		return buscar;
	}

	/**
	 * Establece el término de búsqueda.
	 * 
	 * @param buscar El término de búsqueda a establecer.
	 */
	public void setBuscar(String buscar) {
		this.buscar = buscar;
	}

	/**
	 * Obtiene la URL de la película seleccionada.
	 * 
	 * @return La URL de la película.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Establece la URL de la película seleccionada.
	 * 
	 * @param url La URL de la película a establecer.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Obtiene el nombre de la película seleccionada.
	 * 
	 * @return El nombre de la película.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de la película seleccionada.
	 * 
	 * @param nombre El nombre de la película a establecer.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
