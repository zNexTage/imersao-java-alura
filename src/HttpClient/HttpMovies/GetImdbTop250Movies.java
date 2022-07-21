package HttpClient.HttpMovies;

import java.io.IOException;
import java.util.Collection;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import DTO.MovieDTO;
import Entities.Movie;
import HttpClient.Providers.IGetClient;
import io.github.cdimascio.dotenv.Dotenv;

public class GetImdbTop250Movies  {
    private final IGetClient client;

    public GetImdbTop250Movies(IGetClient client) {
        this.client = client;
    }

    public Collection<Movie> get() throws IOException, InterruptedException{
        Dotenv dotenv = Dotenv.load();
        
        String apiKey = dotenv.get("IMDB_API_KEY");

        //String url = "https://imdb-api.com/en/API/Top250Movies/" + apiKey;
        //System.out.println(url);

        String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";

        String response = this.client.get(url);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        //List<Movie> moviesResponse = objectMapper.readValue(moviesJson, new TypeReference<List<Movie>>() {});        
        MovieDTO moviesResponse = objectMapper.readValue(response, MovieDTO.class);   

        return moviesResponse.getItems();
    }
}
