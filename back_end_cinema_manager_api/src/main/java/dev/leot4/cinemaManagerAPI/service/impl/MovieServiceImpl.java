package dev.leot4.cinemaManagerAPI.service.impl;

import dev.leot4.cinemaManagerAPI.model.Movie;
import dev.leot4.cinemaManagerAPI.repository.MovieRepository;
import dev.leot4.cinemaManagerAPI.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//indica que esta será uma classe de serviço, que irá se comunicar com o nosso repositório
public class MovieServiceImpl implements MovieService {
    @Autowired
    //sinaliza para o spring que sempre que esse atributo deve ser instanciado automaticamente ao utilizarmos essa classe
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }
    //a classe optional serve para que, caso o valor de retorno seja nulo, o retorno é ignorado sem causar erros
    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
