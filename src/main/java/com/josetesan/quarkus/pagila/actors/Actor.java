package com.josetesan.quarkus.pagila.actors;

import com.josetesan.quarkus.pagila.movies.Movie;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * @See https://quarkus.io/guides/hibernate-orm-panache
 */
@Entity
@Table(name = "actor")
public class Actor extends PanacheEntityBase {

    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "actor_actor_id_seq")
    private Long actorId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    @OneToMany
    @JoinTable(
        name = "film_actor",
        joinColumns = {@JoinColumn(name = "actor_id")},
        inverseJoinColumns = @JoinColumn(name="film_id")
        )
    public Set<Movie> movieList;

    public Actor() {
        super();
    }


    public Actor(Long actorId, String firstName, String lastName) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return String.join(" ", firstName,lastName);
    }

    public Set<Movie> getMovieList() {
        return movieList;
    }

    public Long getActorId() {
        return actorId;
    }
}
