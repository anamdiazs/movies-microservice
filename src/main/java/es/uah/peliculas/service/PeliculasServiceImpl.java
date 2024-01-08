package es.uah.peliculas.service;

import es.uah.peliculas.dao.IPeliculasDAO;
import es.uah.peliculas.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.nio.file.Files.readAllBytes;

@Service
public class PeliculasServiceImpl implements IPeliculasService{
    @Autowired
    IPeliculasDAO peliculasDAO;

    @Override
    public List<Pelicula> buscarTodasPeliculas() {
        return peliculasDAO.buscarTodasPeliculas();
    }

    @Override
    public Pelicula buscarPeliculaPorId(Integer idPelicula) {
        return peliculasDAO.buscarPeliculaPorId(idPelicula);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorTitulo(String titulo) {
        return peliculasDAO.buscarPeliculaPorTitulo(titulo);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorActor(String actor) {
        return peliculasDAO.buscarPeliculaPorActor(actor);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorGenero(String genero) {
        return peliculasDAO.buscarPeliculaPorGenero(genero);
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) {
        peliculasDAO.guardarPelicula(pelicula);
    }

    @Override
    public void eliminarPelicula(Integer idPelicula) {
        peliculasDAO.eliminarPelicula(idPelicula);
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        peliculasDAO.actualizarPelicula(pelicula);
    }

    @Override
    public void setPortadaBytes(byte[] portadaBytes) {
        peliculasDAO.setPortadaBytes(portadaBytes);
    }

    @Override
    public byte[] getPortadaAsByteArray() {
        if (peliculasDAO.getPortadaAsByteArray() != null) {
            return peliculasDAO.getPortadaAsByteArray();
        }
        return null;
    }
}
