package es.uah.peliculas.controller;

import es.uah.peliculas.model.Actor;
import es.uah.peliculas.service.IActoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActoresController {
    @Autowired
    IActoresService actoresService;
    @GetMapping("/actores")
    public List<Actor> buscarTodos() {
        return actoresService.buscarTodos();
    }

    @GetMapping("/actores/{idActor}")
    public Actor buscarActorPorId(@PathVariable("idActor") Integer id) {
        return actoresService.buscarActorPorId(id);
    }

    @GetMapping("/actores/nombre/{nombre}")
    public List<Actor> buscarActorPorNombre(@PathVariable("nombre") String nombre) {
        return actoresService.buscarActorPorNombre(nombre);
    }
    @GetMapping("/actores/pais/{pais}")
    public List<Actor> buscarActorPorPais(@PathVariable("pais") String pais) {
        return actoresService.buscarActorPorNombre(pais);
    }

    @PostMapping("/actores")
    public void guardarActor(@RequestBody Actor actor) {
        actoresService.guardarActor(actor);
    }
    @PutMapping("/actores/{idActor}")
    public void actualizarActor(@RequestBody Actor actor) {
        actoresService.actualizarActor(actor);
    }
    @DeleteMapping("/actores/{idActor}")
    public void eliminarActor(@PathVariable("idActor") Integer id) {
        actoresService.eliminarActor(id);
    }
    @PostMapping("/actores/inscPelicula/{ida}/{idp}")
    public void inscribirPelicula(@PathVariable("ida") Integer ida, @PathVariable("idp") Integer idp) {
        actoresService.inscribirPelicula(ida, idp);
    }
}
