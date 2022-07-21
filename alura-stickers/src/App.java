import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import Entities.Movie;
import Entities.NasaApod;
import HttpClient.HttpMovies.GetImdbTop250Movies;
import HttpClient.HttpMovies.GetNasaApod;
import HttpClient.Providers.GetClient;

public class App {
    public static void main(String[] args) throws Exception {
        getMovies();        
    }

    public static void getMovies() throws IOException, InterruptedException{
        Collection<Movie> moviesJson = new GetImdbTop250Movies(new GetClient()).get();  

        StickerFactory sticker = new StickerFactory();

        for (Movie movie : moviesJson) {
            System.out.println(movie.getTitle());
            System.out.println(movie.getImage());
            System.out.println((int)movie.imDbRating());
            
            InputStream fileUrl = new URL(movie.getImage()).openStream();

            sticker.create(fileUrl, movie.getTitle());

            System.out.println("--------------------------------------");
        }
    }

    public static void getNasaApod() throws IOException, InterruptedException{
        Collection<NasaApod> nasaApods = new GetNasaApod(new GetClient()).get("2022-07-10", "2022-07-20");  

        StickerFactory sticker = new StickerFactory();

        for (NasaApod nasaApod : nasaApods) {
            System.out.println(nasaApod.getTitle());
            //System.out.println(nasaApod.getExplanation());
            
            InputStream fileUrl = new URL(nasaApod.getUrl()).openStream();

            sticker.create(fileUrl, nasaApod.getTitle());

            System.out.println("--------------------------------------");
        }
    }
}
