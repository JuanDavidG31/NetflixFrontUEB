package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.model.PeliculaDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.inject.Named;

@Named("PeliculasBean")
@SessionScoped
public class PeliculaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<PeliculaDTO> peliculas;

    public PeliculaBean() {
        peliculas = new ArrayList<>();
        peliculas.add(new PeliculaDTO("Interestellar", "img/1.png", "https://www.youtube.com/embed/1ukG4FTmdWQ?si=Ojh0roBFOCAgtxqz"));
        peliculas.add(new PeliculaDTO("Origen", "img/2.png", "https://www.youtube.com/embed/JWC-kswMRq4?si=QKRInenZ8eH32Mn5"));
        peliculas.add(new PeliculaDTO("Interestellar", "img/1.png", "https://www.youtube.com/embed/1ukG4FTmdWQ?si=Ojh0roBFOCAgtxqz"));
        peliculas.add(new PeliculaDTO("Origen", "img/2.png", "https://www.youtube.com/embed/JWC-kswMRq4?si=QKRInenZ8eH32Mn5"));
        peliculas.add(new PeliculaDTO("Interestellar", "img/1.png", "https://www.youtube.com/embed/1ukG4FTmdWQ?si=Ojh0roBFOCAgtxqz"));
        peliculas.add(new PeliculaDTO("Origen", "img/2.png", "https://www.youtube.com/embed/JWC-kswMRq4?si=QKRInenZ8eH32Mn5"));
        peliculas.add(new PeliculaDTO("Peppa Y El Tocino", "img/2.png", "https://www.youtube.com/embed/IvXldkKLVBQ?si=rK29MjXkswi_e6HN"));
    }
   

    public List<PeliculaDTO> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<PeliculaDTO> peliculas) {
        this.peliculas = peliculas;
    }
}
