package co.edu.unbosque.model;

import java.io.Serializable;

public class MovieDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String url;
	private String nombre;
	private String genero;

	public MovieDTO() {
	}

	public MovieDTO(String url, String nombre, String genero) {
		super();
		this.url = url;
		this.nombre = nombre;
		this.genero = genero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MovieDTO [id=" + id + ", url=" + url + ", nombre=" + nombre + ", genero=" + genero + "]";
	}

}
