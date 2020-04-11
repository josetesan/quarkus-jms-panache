package com.josetesan.quarkus.pagila.actors;


import com.josetesan.quarkus.pagila.movies.Movie;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

@Path("/actors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ActorsResource {

    @Inject
    ActorService actorService;

    @GET
    public List<Actor> actors() {
        return Actor
            .findAll()
            .list();
    }

    @GET
    @Path("/{id}/movies")
    public Set<Movie> myMovies(@PathParam("id") Long actorId) {
        Actor me = Actor
            .findById(actorId)
            ;
        return  me
            .getMovieList();
    }

    @POST
    @Transactional
    public Actor createActor(Actor actor) {
         Actor
            .persist(actor);
         actorService.publish(actor);
         return actor;

    }



}
