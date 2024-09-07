package uepb.estudo.filme.mappers;

import org.springframework.stereotype.Service;
import uepb.estudo.filme.DTOs.FilmeDTO;
import uepb.estudo.filme.DTOs.FilmeResponseDTO;
import uepb.estudo.filme.entities.Autor;
import uepb.estudo.filme.entities.Filme;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeMapper {
    public Filme toFilme(FilmeDTO filmeDTO) {
        Filme novoFilme = new Filme();
        novoFilme.setTitulo(filmeDTO.titulo());
        novoFilme.setAno(filmeDTO.ano());

        Autor novoAutor = new Autor();
        novoAutor.setId(filmeDTO.autorId());

        novoFilme.setAutor(novoAutor);

        return novoFilme;
    }

    public FilmeResponseDTO toFilmeResponseDTO(Filme filme){
        return new FilmeResponseDTO(
                filme.getTitulo(),
                filme.getAno()
        );
    }

    public List<FilmeResponseDTO> toFilmeResponseDTOList(List<Filme> filme){
        return filme
                .stream()
                .map(this::toFilmeResponseDTO)
                .collect(Collectors.toList());
    }
}
