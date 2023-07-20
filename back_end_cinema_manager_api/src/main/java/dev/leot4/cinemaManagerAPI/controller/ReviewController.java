package dev.leot4.cinemaManagerAPI.controller;

import dev.leot4.cinemaManagerAPI.model.Review;
import dev.leot4.cinemaManagerAPI.service.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewServiceImpl reviewServiceImpl;

    //aqui especificamos que o metodo irá tratar de requisições http do tipo POST
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        //definimos a entidade de resposta, definindo o objeto que será retornado, no caso a nova review
        //e o codigo de status http, comunicando se a requisicao foi executada corretamente
        return new ResponseEntity<Review>(reviewServiceImpl.createReview(payload.get("reviewBody"),
                                                                     payload.get("imdbId")),
                                          HttpStatus.CREATED);

    }
}
