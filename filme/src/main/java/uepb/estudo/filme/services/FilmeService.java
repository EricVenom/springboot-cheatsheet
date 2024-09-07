package uepb.estudo.filme.services;

import org.springframework.stereotype.Service;
import uepb.estudo.filme.DTOs.FilmeDTO;
import uepb.estudo.filme.DTOs.FilmeResponseDTO;
import uepb.estudo.filme.entities.Filme;
import uepb.estudo.filme.mappers.FilmeMapper;
import uepb.estudo.filme.repositories.FilmeRepository;

import java.util.List;

@Service
public class FilmeService {
    private final FilmeRepository filmeRepository;
    private final FilmeMapper filmeMapper;

    public FilmeService(FilmeRepository filmeRepository, FilmeMapper filmeMapper) {
        this.filmeRepository = filmeRepository;
        this.filmeMapper = filmeMapper;
    }

    public FilmeResponseDTO addFilme(
            FilmeDTO filmeDTO
    ){
        Filme filme = filmeMapper.toFilme(filmeDTO);
        Filme filmeSalvo = filmeRepository.save(filme);
        return filmeMapper.toFilmeResponseDTO(filmeSalvo);
    }

    public List<FilmeResponseDTO> getFilmes(){
        return filmeMapper.toFilmeResponseDTOList(this.filmeRepository.findAll());
    }

    public FilmeResponseDTO getFilmeById(int id){
        Filme filme = filmeRepository.findById(id).orElse(null);
        return filmeMapper.toFilmeResponseDTO(filme);
    }

    public void deleteFilmeById(int id){
        filmeRepository.deleteById(id);
    }
}
