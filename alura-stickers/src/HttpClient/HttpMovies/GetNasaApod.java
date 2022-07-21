package HttpClient.HttpMovies;


import java.util.Collection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Entities.NasaApod;
import HttpClient.Providers.IGetClient;
import io.github.cdimascio.dotenv.Dotenv;

public class GetNasaApod {
    private final IGetClient client;

    public GetNasaApod(IGetClient client) {
        this.client = client;
    }

   
    public Collection<NasaApod> get(String startDate, String endDate) throws JsonMappingException, JsonProcessingException{
        Dotenv dotenv = Dotenv.load();

        String apiKey = dotenv.get("NASA_API_KEY");

        String url = String.format("https://api.nasa.gov/planetary/apod?api_key=%s&start_date=%s&end_date=%s", apiKey, startDate, endDate);

        String response = this.client.get(url);

        ObjectMapper objectMapper = new ObjectMapper();

        Collection<NasaApod> listNasaApod = objectMapper.readValue(response, new TypeReference<Collection<NasaApod>>(){});   

        return listNasaApod;
    }    
}
