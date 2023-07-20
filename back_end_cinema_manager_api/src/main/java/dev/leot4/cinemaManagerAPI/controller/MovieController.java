package dev.leot4.cinemaManagerAPI.controller;

import dev.leot4.cinemaManagerAPI.model.Movie;
import dev.leot4.cinemaManagerAPI.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//associa a classe a um controller para requisições HTTP, e também engloba a anotação @responseBody, serializando os valores retornados
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/movies")
//mapeia a url na qual a classe irá lidar com as requisições em questao
public class MovieController {
    @Autowired
    private MovieServiceImpl movieServiceImpl;

    @GetMapping
    //especifica que esse metodo ira lidar somente com metodos GET
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieServiceImpl.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    //{imdbId} está entre chaves pois nao será um valor fixo, e sim variavel
    //utilizamos tambem a notacao @PathVariable para sinalizar que o valor id vai ser uma variavel da url,
    // associando ele ao {imdbIdd} que está na notacao @GetMapping
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieServiceImpl.singleMovie(imdbId), HttpStatus.OK);
    }
}
