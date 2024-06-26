package es.uah.peliculas.dao;

import es.uah.peliculas.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPeliculasJPA extends JpaRepository<Pelicula, Integer> {
    List<Pelicula> findByTituloContainingIgnoreCase(String titulo);
    List<Pelicula> findByActoresNombreContainingIgnoreCase(String actorName);
    List <Pelicula> findByGenero(String genero);
}
