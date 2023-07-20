package dev.leot4.cinemaManagerAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
//especifica que cada instancia dessa classe deve ser tratada como um documento diferente no banco de dados
@Data
//cria pelo lombok os getters e setters dos atributos na classe
@AllArgsConstructor
//cria um construtor para a classe com todos os atributos como argumento
@NoArgsConstructor
//cria um construtor para a classe sem nenhuma atributo como argumento
public class Movie {

    @Id
    //associa esse atributo como o identificador principal da classe
    private ObjectId id;

    private String imdbId;

    private String title;

    private String releaseDate;

    private String trailerLink;

    private String poster;

    private List<String> genres;

    private List<String> backdrops;

    @DocumentReference
    //isso faz com que em vez do MongoDB guardar todas as reviews de um filme na classe Movie, somente seus ids serão ar
    //mazenados, e as reviews em si vão ser armazenadas em outro documento
    private List<Review> reviews;
}
