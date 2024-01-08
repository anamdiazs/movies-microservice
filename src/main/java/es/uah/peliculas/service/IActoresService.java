package es.uah.peliculas.service;

import es.uah.peliculas.model.Actor;

import java.util.List;

public interface IActoresService {
    List<Actor> buscarTodos();
    Actor buscarActorPorId(Integer idActor);
    List<Actor> buscarActorPorNombre(String nombre);
    List<Actor> buscarActorPorPais(String pais);
    void guardarActor(Actor actor);
    void eliminarActor(Integer idActor);
    void actualizarActor(Actor actor);
    void inscribirPelicula(Integer idActor, Integer idPelicula);
}
