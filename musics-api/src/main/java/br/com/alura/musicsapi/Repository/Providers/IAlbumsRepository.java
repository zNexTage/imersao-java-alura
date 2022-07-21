package br.com.alura.musicsapi.Repository.Providers;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.alura.musicsapi.Entities.Album;

public interface IAlbumsRepository extends MongoRepository<Album, String> {
    
}
