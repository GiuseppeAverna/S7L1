package Back.End.Esercizio.S7L1.services;

import Back.End.Esercizio.S7L1.entities.Dipendente;
import Back.End.Esercizio.S7L1.exceptions.BadRequestException;
import Back.End.Esercizio.S7L1.exceptions.NotFoundException;
import Back.End.Esercizio.S7L1.payloads.dipendenti.NewDipendenteDTO;
import Back.End.Esercizio.S7L1.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class DipendenteService {
    @Autowired
    private DipendenteRepository dipendenteRepository;
    private List<Dipendente> dipendentiList = new ArrayList<>();

    public Page<Dipendente> getAuthors(int page, int size, String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return dipendenteRepository.findAll(pageable);
    }

    public Dipendente saveDipendente(NewDipendenteDTO body) throws IOException {
        dipendenteRepository.findByEmail(body.email()).ifPresent(dipendente -> {
            throw new BadRequestException("L'email"+ body.email() + "è già stata utilizzata");
        });
      Dipendente newDipendente = new Dipendente();
      newDipendente.setNome(body.nome());
      newDipendente.setUsername(body.username());
      newDipendente.setCognome(body.cognome());
      newDipendente.setEmail(body.email());


        return dipendenteRepository.save(newDipendente);
    }

    public Dipendente findById(long id) {
        return dipendenteRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public Dipendente findByIdAndUpdate(long id, Dipendente body) {

        Dipendente found = this.findById(id);
        found.setEmail(body.getEmail());
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        return dipendenteRepository.save(found);
    }
    public void findByIdAndDelete(int id) {
        Dipendente found = this.findById(id);
        dipendenteRepository.delete(found);
    }
    public static Dipendente findByEmail(String email, DipendenteRepository dipendenteRepository) {
        Optional<Dipendente> dipendenteOptional = dipendenteRepository.findByEmail(email);
        return dipendenteOptional.orElse(null);
    }


}


