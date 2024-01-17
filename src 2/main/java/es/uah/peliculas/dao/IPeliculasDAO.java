package es.uah.peliculas.dao;

import es.uah.peliculas.model.Pelicula;

import java.util.List;

public interface IPeliculasDAO {

    List<Pelicula> buscarTodasPeliculas();

    Pelicula buscarPeliculaPorId(Integer idPelicula);
    List<Pelicula> buscarPeliculaPorTitulo(String titulo);
    List<Pelicula> buscarPeliculaPorActor(String actor);

    List<Pelicula> buscarPeliculaPorGenero(String genero);
    void guardarPelicula(Pelicula pelicula);
    void eliminarPelicula(Integer idPelicula);
    void actualizarPelicula(Pelicula pelicula);
    void setPortadaBytes(byte[] portadaBytes);

    byte[] getPortadaAsByteArray();
}
