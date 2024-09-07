package uepb.estudo.filme.controllers;

import org.springframework.web.bind.annotation.*;
import uepb.estudo.filme.DTOs.FilmeDTO;
import uepb.estudo.filme.DTOs.FilmeResponseDTO;
import uepb.estudo.filme.entities.Filme;
import uepb.estudo.filme.repositories.FilmeRepository;
import uepb.estudo.filme.mappers.FilmeMapper;
import uepb.estudo.filme.services.FilmeService;

import java.util.List;

@RestController
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @PostMapping("/filme")
    public FilmeResponseDTO addFilme(
            @RequestBody FilmeDTO filmeDTO
    ) {
       return this.filmeService.addFilme(filmeDTO);
    }

    @GetMapping("/filme")
    public List<FilmeResponseDTO> getFilmes() {
        return this.filmeService.getFilmes();
    }

    @GetMapping("/filme/{id}")
    public FilmeResponseDTO getFilmeById(@PathVariable int id) {
        return this.filmeService.getFilmeById(id);
    }

    @DeleteMapping("/filme/{id}")
    public void deleteFilmeById(@PathVariable int id) {
       this.filmeService.deleteFilmeById(id);
    }
}
