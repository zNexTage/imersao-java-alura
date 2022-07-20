package DTO;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import Entities.Movie;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDTO {

    @JsonCreator
    public MovieDTO(@JsonProperty("items") Collection<Movie> items) {
        this.items = items;
    }

    @JsonProperty("items")
    private Collection<Movie> items;

    public Collection<Movie> getItems() {
        return items;
    }
}
