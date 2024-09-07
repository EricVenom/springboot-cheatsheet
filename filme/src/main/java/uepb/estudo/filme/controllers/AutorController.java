package uepb.estudo.filme.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uepb.estudo.filme.DTOs.AutorDTO;
import uepb.estudo.filme.entities.Autor;
import uepb.estudo.filme.repositories.AutorRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @GetMapping("/autor")
    public List<AutorDTO> listarAutores() {
        return autorRepository
                .findAll()
                .stream()
                .map(this::toAutorDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/autor")
    public Autor adicionaAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    private Autor toAutor(AutorDTO dto) {
        return new Autor(
                dto.id(),
                dto.nome()
        );
    }

    private AutorDTO toAutorDTO(Autor autor) {
        return new AutorDTO(
                autor.getId(),
                autor.getNome()
        );
    }
}
