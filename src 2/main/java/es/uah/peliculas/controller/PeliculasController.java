package es.uah.peliculas.controller;

import es.uah.peliculas.model.Pelicula;
import es.uah.peliculas.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeliculasController {
    @Autowired
    IPeliculasService peliculasService;

    @GetMapping("/peliculas")
    public List<Pelicula> buscarTodasPeliculas() {
        byte[] portadaBytes = peliculasService.getPortadaAsByteArray();

        // Set the byte array in a new field in the response DTO or directly in the Pelicula entity
        peliculasService.setPortadaBytes(portadaBytes);

        return peliculasService.buscarTodasPeliculas();
    }

    @GetMapping("/peliculas/{idPelicula}")
    public Pelicula buscarPeliculaPorId(@PathVariable("idPelicula") Integer idPelicula) {
        return peliculasService.buscarPeliculaPorId(idPelicula);
    }

    @GetMapping("/peliculas/titulo/{titulo}")
    public List<Pelicula> buscarPeliculaPorTitulo(@PathVariable("titulo") String titulo) {
        return peliculasService.buscarPeliculaPorTitulo(titulo);
    }
    @GetMapping("/peliculas/actor/{actor}")
    public List<Pelicula> buscarPeliculaPorActor(@PathVariable("actor") String actor) {
        return peliculasService.buscarPeliculaPorActor(actor);
    }
    @GetMapping ("/peliculas/genero/{genero}")
    public List<Pelicula> buscarPeliculaPorGenero(@PathVariable("genero") String genero) {
        return peliculasService.buscarPeliculaPorGenero(genero);
    }
    @PostMapping("/peliculas")
    public void guardarPelicula(@RequestBody Pelicula pelicula) {
        peliculasService.guardarPelicula(pelicula);
    }
    @PutMapping("/peliculas/{idPelicula}" +
            "")
    public void actualizarPelicula(@RequestBody Pelicula pelicula) {
        peliculasService.actualizarPelicula(pelicula);
    }
    @DeleteMapping("/peliculas/{idPeliculas}")
    public void eliminarPelicula(@PathVariable("idPeliculas") Integer id) {
        peliculasService.eliminarPelicula(id);
    }

}
