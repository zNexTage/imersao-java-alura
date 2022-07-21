package br.com.alura.musicsapi.Entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "albums")
public class Album {
    @Id
    private String id;  
    private List<String> musics;
    private String title;
    private String image;
    private String band;
    public List<String> getMusics() {
        return musics;
    }
    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }
    public String getBand() {
        return band;
    }

    

    public Album(List<String> musics, String title, String image, String band) {
        this.musics = new ArrayList<>(musics);
        this.title = title;
        this.image = image;
        this.band = band;
    }
    public String getId() {
        return id;
    }

    
}
