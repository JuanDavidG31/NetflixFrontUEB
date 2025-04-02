package co.edu.unbosque.model;

import java.io.Serializable;

public class PeliculaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String imagenUrl;
    private String videoUrl;

    public PeliculaDTO() {
        // Constructor vacío necesario para JSF
    }

    public PeliculaDTO(String nombre, String imagenUrl, String videoUrl) {
        this.nombre = nombre;
        this.imagenUrl = imagenUrl;
        this.videoUrl = videoUrl;
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    // Método toString (opcional, pero útil para depuración)

    @Override
    public String toString() {
        return "PeliculaDTO{" +
                "nombre='" + nombre + '\'' +
                ", imagenUrl='" + imagenUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
