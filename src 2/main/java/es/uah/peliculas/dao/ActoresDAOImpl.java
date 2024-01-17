package es.uah.peliculas.dao;

import es.uah.peliculas.model.Actor;
import es.uah.peliculas.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ActoresDAOImpl  implements IActoresDAO{
    @Autowired
    IActoresJPA actoresJPA;
    @Autowired
    private IPeliculasJPA iPeliculasJPA;

    @Override
    public List<Actor> buscarTodos() {
        return actoresJPA.findAll();
    }
    @Override
    public Actor buscarActorPorId(Integer idActor) {
        Optional<Actor> optional = actoresJPA.findById(idActor);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }
    @Override
    public List<Actor> buscarActorPorNombre(String nombre) {
        return actoresJPA.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Actor> buscarActorPorPais(String pais) {
        return actoresJPA.findByPaisContainingIgnoreCase(pais);
    }

    @Override
    public void guardarActor(Actor actor) {
        actoresJPA.save(actor);
    }

    @Override
    public void eliminarActor(Integer idActor) {
        actoresJPA.deleteById(idActor);
    }
    @Override
    public void actualizarActor(Actor actor) {
        actoresJPA.save(actor);
    }

    @Override
    public void inscribirPelicula(Integer idActor, Integer idPelicula) {
        Optional<Actor> optionalActor = actoresJPA.findById(idActor);
        Optional<Pelicula> optionalPelicula = iPeliculasJPA.findById(idPelicula);
        if (optionalActor.isPresent() && optionalPelicula.isPresent()) {
            Actor actor = optionalActor.get();
            Pelicula pelicula = optionalPelicula.get();
            actor.addPelicula(pelicula);
            actoresJPA.save(actor);
        }
    }
}
