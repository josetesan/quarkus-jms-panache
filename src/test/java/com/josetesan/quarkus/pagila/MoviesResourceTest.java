package com.josetesan.quarkus.pagila;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MoviesResourceTest {

    @Test
    public void testMovieEndpoint() {
        given()
          .when().get("/movies")
          .then()
             .statusCode(200)
//             .body(everyItem(is(Movie.class))
             ;
    }

}