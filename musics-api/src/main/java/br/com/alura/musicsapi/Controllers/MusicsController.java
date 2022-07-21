package br.com.alura.musicsapi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.musicsapi.Entities.Album;
import br.com.alura.musicsapi.Repository.Providers.IAlbumsRepository;

@RestController
public class MusicsController {

    @Autowired
    private IAlbumsRepository albumsRepository;    

    @GetMapping(value = "/albums")
    public List<Album> getAlbums() {
        return albumsRepository.findAll();
    }

    @PostMapping(value="/albums")
    public Album createAlbum(@RequestBody Album album){
        return this.albumsRepository.save(album);
    }
    
}
