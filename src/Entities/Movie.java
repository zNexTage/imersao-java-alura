package Entities;

public class Movie {
    private String title;
    public String getTitle() {
        return title;
    }

    private String image;
    public String getImage() {
        return image;
    }
    private String imDbRating;
    public String imDbRating(){
        return imDbRating;
    }

    public Movie(String title, String image, String imDbRating) {
        this.title = title;
        this.image = image;
        this.imDbRating = imDbRating;
    }    
}
