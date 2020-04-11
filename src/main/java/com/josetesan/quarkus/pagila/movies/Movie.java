package com.josetesan.quarkus.pagila.movies;

import com.josetesan.quarkus.pagila.actors.Actor;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "film")
public class Movie extends PanacheEntityBase {

    @Id
    @Column(name="film_id")
    private Long filmId;
    @Column(name="title")
    private String title;
    @Column(name="release_year")
    private Integer releaseYear;
    @Column(name="length")
    private Integer length;

    @ManyToOne
    public List<Actor> actorList;

    public Movie() {
        super();
    }

    public Movie(Long filmId, String title, Integer releaseYear, Integer length) {
        this.filmId = filmId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.length = length;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }
}
