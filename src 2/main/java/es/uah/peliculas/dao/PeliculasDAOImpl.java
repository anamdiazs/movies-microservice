package es.uah.peliculas.dao;

import es.uah.peliculas.model.Pelicula;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class PeliculasDAOImpl implements IPeliculasDAO{
    @Autowired
    IPeliculasJPA peliculasJPA;
    @Override
    public List<Pelicula> buscarTodasPeliculas() {
        return peliculasJPA.findAll();
    }

    @Override
    public Pelicula buscarPeliculaPorId(Integer idPelicula) {
        Optional<Pelicula> optional = peliculasJPA.findById(idPelicula);
        if(optional.isPresent()){
            return optional.get();
        }else {
            return null;
        }
    }

    @Override
    public List<Pelicula> buscarPeliculaPorTitulo(String titulo) {
        return peliculasJPA.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorActor(String actorName) {
        return peliculasJPA.findByActoresNombreContainingIgnoreCase(actorName);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorGenero(String genero) {
        return peliculasJPA.findByGenero(genero);
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) {
        peliculasJPA.save(pelicula);
    }

    @Override
    public void eliminarPelicula(Integer idPelicula) {
        peliculasJPA.deleteById(idPelicula);
    }
    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        peliculasJPA.save(pelicula);
    }

    @Override
    public void setPortadaBytes(byte[] portadaBytes) {

    }

    @Override
    public byte[] getPortadaAsByteArray() {
        return new byte[0];
    }
}
