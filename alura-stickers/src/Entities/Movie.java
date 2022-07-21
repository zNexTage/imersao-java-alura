package Entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
    
    @JsonProperty("title")
    private String title;
    public String getTitle() {
        return title;
    }    

    @JsonProperty("image")
    private String image;
    public String getImage() {
        return image;
    }

    @JsonProperty("imDbRating")
    private float imDbRating;
    public float imDbRating(){
        return imDbRating;
    }

    @JsonCreator
    public Movie(@JsonProperty("title") String title, 
    @JsonProperty("image") String image, 
    @JsonProperty("imDbRating") String imDbRating) {
        this.title = title;
        this.image = image;
        this.imDbRating = Float.parseFloat(imDbRating);
    }
}
