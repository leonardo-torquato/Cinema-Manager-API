package dev.leot4.cinemaManagerAPI.repository;

import dev.leot4.cinemaManagerAPI.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//especifica ao spring que esta interface servirá de repositorio para nossos filmes
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //queries automaticas tratam certos metodos de modo automatico apennas pelo seu nome
    //o que significa que apenas nomeando o metodo imdbId, o spring ja reconhece a funcao desejada do metodo e a executa
    Optional<Movie> findMovieByImdbId(String imdbId);
}
