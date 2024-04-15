package Back.End.Esercizio.S7L1.entities;

import Back.End.Esercizio.S7L1.repositories.DipendenteRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;

    public static Dipendente findByEmail(String email, DipendenteRepository dipendenteRepository) {
        Optional<Dipendente> dipendenteOptional = dipendenteRepository.findByEmail(email);
        return dipendenteOptional.orElse(null);
    }
}
