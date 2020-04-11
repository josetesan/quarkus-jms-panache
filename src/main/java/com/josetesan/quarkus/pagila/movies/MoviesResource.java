package com.josetesan.quarkus.pagila.movies;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/movies")
public class MoviesResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> movies() {
        return Movie
            .findAll()
            .list();
    }
}
