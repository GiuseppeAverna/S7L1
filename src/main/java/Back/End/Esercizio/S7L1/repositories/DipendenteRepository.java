package Back.End.Esercizio.S7L1.repositories;


import Back.End.Esercizio.S7L1.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    Optional<Dipendente> findByEmail(String email);
}
