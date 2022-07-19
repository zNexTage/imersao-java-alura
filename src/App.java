import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Entities.Movie;
import Services.GetImdbMovies;

public class App {
    public static void main(String[] args) throws Exception {
        /* 
            1 - Fazer uma conexão HTTP e buscar os top 250 filmes;
            2 - Pegar só os dados que interessam (título, poster, classificação)
            3 - Exibir e manipular os dados
        */

        //1:
        String moviesJson = new GetImdbMovies().getMovies();

        //2:
        ObjectMapper objectMapper = new ObjectMapper();

        List<Movie> movies = objectMapper.readValue(moviesJson, new TypeReference<List<Movie>>(){});

        //3:
        for (Movie movie : movies) {
            System.out.println(movie.getTitle());
            System.out.println(movie.getImage());
            System.out.println(movie.imDbRating());
        }
    }
}
