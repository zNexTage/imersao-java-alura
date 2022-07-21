package Entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaApod {
    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;

    @JsonProperty("explanation")
    private String explanation;

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getExplanation() {
        return explanation;
    }

    @JsonCreator
    public NasaApod(@JsonProperty("title")String title, @JsonProperty("url")String url, @JsonProperty("explanation")String explanation) {
        this.title = title;
        this.url = url;
        this.explanation = explanation;
    }
    
}
