package com.josetesan.quarkus.pagila.actors;


import com.josetesan.quarkus.pagila.movies.Movie;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/actors")
@Produces(MediaType.APPLICATION_JSON)
public class ActorsResource {

    @GET
    public List<Actor> actors() {
        return Actor
            .findAll()
            .list();
    }

    @GET
    @Path("/{id}/movies")
    public List<Movie> myMovies(@QueryParam("id") Long actorId) {
        Actor me = Actor
            .findById(actorId)
            ;
        return me
            .getMovieList();
    }

}
