package Services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import Entities.Movie;
import io.github.cdimascio.dotenv.Dotenv;

public class GetImdbTop250Movies {
    
    /**
     * Requisita a api do imdb e obtém os top 250 filmes
     * @return json contendo os filmes
     * @throws InterruptedException
     * @throws IOException
     */    
    public String get() throws IOException, InterruptedException {
        Dotenv dotenv = Dotenv.load();
        
        String apiKey = dotenv.get("IMDB_API_KEY");

        //String url = "https://imdb-api.com/en/API/Top250Movies/" + apiKey;
        //System.out.println(url);

        String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";

        HttpClient client = HttpClient.newHttpClient();

        URI addressUri = URI.create(url);

        HttpRequest request = HttpRequest.newBuilder(addressUri).GET().build(); 
        
        HttpResponse<String> response;

        response = client.send(request, BodyHandlers.ofString());

        String body = response.body();

        return body;      
    }
}
