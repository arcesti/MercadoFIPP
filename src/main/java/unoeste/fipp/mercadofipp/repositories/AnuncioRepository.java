package unoeste.fipp.mercadofipp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unoeste.fipp.mercadofipp.entities.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
}
