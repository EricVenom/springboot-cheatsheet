package uepb.estudo.filme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uepb.estudo.filme.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
