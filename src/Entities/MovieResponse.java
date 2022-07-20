package Entities;

import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieResponse {

    @JsonCreator
    public MovieResponse(@JsonProperty("items") Collection<Movie> items) {
        this.items = items;
    }

    @JsonProperty("items")
    private Collection<Movie> items;

    public Collection<Movie> getItems() {
        return items;
    }
}
