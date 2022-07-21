package HttpClient.Providers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
 

public class GetClient implements IGetClient{
    public String get(String url) {
        HttpClient client = HttpClient.newHttpClient();

        URI addressUri = URI.create(url);

        HttpRequest request = HttpRequest.newBuilder(addressUri).GET().build(); 
        
        HttpResponse<String> response;

        try {
            response = client.send(request, BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            throw new RuntimeException(e);
        }

        String body = response.body();

        return body;      
    }
}
