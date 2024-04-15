package Back.End.Esercizio.S7L1.services;


import Back.End.Esercizio.S7L1.entities.Dispositivo;
import Back.End.Esercizio.S7L1.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class DispositivoService {
    private List<Dispositivo> dispositiviList = new ArrayList<>();

    public List<Dispositivo> getDispositiviList() {
        return this.dispositiviList;
    }

    public Dispositivo saveDispositivo(Dispositivo body) {
        Random rndm = new Random();
        body.setId(rndm.nextLong(1, 1000));
        this.dispositiviList.add(body);
        return body;
    }

    public Dispositivo findById(long id) {
        for (Dispositivo dispositivo : this.dispositiviList) {
            if (dispositivo.getId() == id) {
                return dispositivo;
            }
        }
        throw new NotFoundException(id);
    }

    public Dispositivo findByIdAndUpdate(long id, Dispositivo updatedDispositivo) {
        for (Dispositivo dispositivo : this.dispositiviList) {
            if (dispositivo.getId() == id) {
                dispositivo.setTipo(updatedDispositivo.getTipo());
                dispositivo.setStato(updatedDispositivo.getStato());
                return dispositivo;
            }
        }
        throw new NotFoundException(id);
    }

    public void findByIdAndDelete(long id) {
        Iterator<Dispositivo> iterator = this.dispositiviList.iterator();
        while (iterator.hasNext()) {
            Dispositivo current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
                return;
            }
        }
        throw new NotFoundException(id);
    }
}
