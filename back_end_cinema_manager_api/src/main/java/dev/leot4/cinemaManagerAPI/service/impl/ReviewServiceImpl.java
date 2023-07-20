package dev.leot4.cinemaManagerAPI.service.impl;

import dev.leot4.cinemaManagerAPI.model.Movie;
import dev.leot4.cinemaManagerAPI.model.Review;
import dev.leot4.cinemaManagerAPI.repository.ReviewRepository;
import dev.leot4.cinemaManagerAPI.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        //podemos acessar metodos nativos do repositorio mongoDB
        Review review = reviewRepository.insert(new Review(reviewBody));

        //aqui realizamos a comunicação com o banco de dados via template do mongoDB, onde utilizamos o template de update
        //e especificamos que é para a classe Movie
        mongoTemplate.update(Movie.class)
                //Depois declaramos a ação matching, que vai verificar se alguma instancia de filme corresponde ao criterio
                //que se a chave imdbId for igual ao valor imdbId passado como argumrnyo no metodo
                .matching(Criteria.where("imdbId").is(imdbId))
                //deve-se aplicar uma nova atualizacao, e inserir os valores da review na primeira instancia correspondente
                //por meio de uma chave reviewIds
                .apply(new Update().push("reviews").value(review))
                .first();

        return review;
    }
}
