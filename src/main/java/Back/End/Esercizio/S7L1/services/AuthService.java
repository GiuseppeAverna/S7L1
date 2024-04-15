package Back.End.Esercizio.S7L1.services;

import Back.End.Esercizio.S7L1.entities.Dipendente;
import Back.End.Esercizio.S7L1.exceptions.NotFoundException;
import Back.End.Esercizio.S7L1.payloads.dipendenti.DipendentiLoginDTO;
import Back.End.Esercizio.S7L1.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthService {
    public String generateToken(Dipendente dipendente) {
        // Implementa qui la logica per generare il token
        // Ad esempio, potresti utilizzare JWT per generare il token
        return "token"; // Ritorna un token fittizio
    }

    private DipendenteRepository dipendenteRepository;

    @Autowired
    public AuthService(DipendenteRepository dipendenteRepository) {
        this.dipendenteRepository = dipendenteRepository;
    }

    public String authenticateDipendenteAndGenerateToken(DipendentiLoginDTO payload) {
        String email = payload.getEmail(); // Ottieni l'email dal payload
        // Resto del codice
    }

    // Cerca il dipendente per email e restituisci un'eccezione se non viene trovato
        Dipendente dipendente = dipendenteRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Dipendente con email " + email + " non trovato"));

        // Genera e restituisci il token
        String token = generateToken(dipendente); // Supponiamo che ci sia un metodo per generare il token
        return token;
    }
}
