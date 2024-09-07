package uepb.estudo.filme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uepb.estudo.filme.entities.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {
}
