package uepb.estudo.filme.DTOs;

import uepb.estudo.filme.entities.Autor;

public record FilmeDTO(
        String titulo,
        int ano,
        Integer autorId
) {
}
