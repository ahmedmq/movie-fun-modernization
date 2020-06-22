package org.superbiz.moviefun.albums;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    private final AlbumsRepository albumsRepository;

    public AlbumsController(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    @PostMapping
    public void addAlbum(@RequestBody Album album){
        albumsRepository.addAlbum(album);
    }

    @GetMapping("/{albumId}")
    public Album details(@PathVariable long albumId){
        return albumsRepository.find(albumId);
    }

    @GetMapping
    public List<Album> details(){
        return albumsRepository.getAlbums();
    }
}
