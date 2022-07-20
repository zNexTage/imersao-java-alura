import java.io.InputStream;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Entities.Movie;
import Entities.MovieResponse;
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
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        //List<Movie> moviesResponse = objectMapper.readValue(moviesJson, new TypeReference<List<Movie>>() {});        
        MovieResponse moviesResponse = objectMapper.readValue(moviesJson, MovieResponse.class);        

        //3:
        StickerFactory sticker = new StickerFactory();

        for (Movie movie : moviesResponse.getItems()) {
            System.out.println(movie.getTitle());
            System.out.println(movie.getImage());
            System.out.println(movie.imDbRating());
            
            InputStream fileUrl = new URL(movie.getImage()).openStream();

            sticker.create(fileUrl, movie.getTitle());
        }
    }
}
