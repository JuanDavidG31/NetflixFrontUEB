package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Data Transfer Object (DTO) para representar datos de películas. Esta clase se utiliza para
 * transferir datos de películas entre diferentes capas de la aplicación.
 */
public class MovieDTO implements Serializable {
  /** UID de versión serial para la serialización. */
  private static final long serialVersionUID = 1L;

  /** Identificador único de la película. */
  private Integer id;

  /** URL de la imagen o video de la película. */
  private String url;

  /** Nombre de la película. */
  private String nombre;

  /** Género de la película. */
  private String genero;

  /** Constructor predeterminado sin argumentos. */
  public MovieDTO() {}

  /**
   * Constructor con argumentos para inicializar los campos de URL, nombre y género de la película.
   *
   * @param url URL de la película.
   * @param nombre Nombre de la película.
   * @param genero Género de la película.
   */
  public MovieDTO(String url, String nombre, String genero) {
    super();
    this.url = url;
    this.nombre = nombre;
    this.genero = genero;
  }

  /**
   * Obtiene el identificador de la película.
   *
   * @return El identificador de la película.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Establece el identificador de la película.
   *
   * @param id El identificador de la película a establecer.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Obtiene la URL de la película.
   *
   * @return La URL de la película.
   */
  public String getUrl() {
    return url;
  }

  /**
   * Establece la URL de la película.
   *
   * @param url La URL de la película a establecer.
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * Obtiene el nombre de la película.
   *
   * @return El nombre de la película.
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Establece el nombre de la película.
   *
   * @param nombre El nombre de la película a establecer.
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Obtiene el género de la película.
   *
   * @return El género de la película.
   */
  public String getGenero() {
    return genero;
  }

  /**
   * Establece el género de la película.
   *
   * @param genero El género de la película a establecer.
   */
  public void setGenero(String genero) {
    this.genero = genero;
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
   * Devuelve una representación en cadena del objeto MovieDTO.
   *
   * @return Una cadena que representa el objeto MovieDTO.
   */
  @Override
  public String toString() {
    return "MovieDTO [id="
        + id
        + ", url="
        + url
        + ", nombre="
        + nombre
        + ", genero="
        + genero
        + "]";
  }
}
