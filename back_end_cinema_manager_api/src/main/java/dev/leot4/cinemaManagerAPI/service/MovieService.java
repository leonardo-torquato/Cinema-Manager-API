package dev.leot4.cinemaManagerAPI.service;

import dev.leot4.cinemaManagerAPI.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    public List<Movie> allMovies();
    public Optional<Movie> singleMovie(String imdbId);
}
