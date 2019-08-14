package com.twu.biblioteca;

public class Movie {
    private String movieName;
    private Integer year;
    private String director;
    private float movieRating;
    private Boolean available;

    public Movie(String movieName, Integer year, String director, float movieRating, Boolean available) {
        this.movieName = movieName;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
        this.available = available;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public float getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(float movieRating) {
        this.movieRating = movieRating;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
