package co.edu.unbosque.model;

import java.io.Serializable;

public class MovieDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String genero;
	private String videoUrl;

	public MovieDTO() {
	}

	public MovieDTO(String nombre, String genero, String videoUrl) {
		this.nombre = nombre;
		this.genero = genero;
		this.videoUrl = videoUrl;
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

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	@Override
	public String toString() {
		return "PeliculaDTO{" + "nombre='" + nombre + '\'' + ", genero='" + genero + '\'' + ", videoUrl='" + videoUrl
				+ '\'' + '}';
	}
}
