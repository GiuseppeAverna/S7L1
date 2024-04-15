package Back.End.Esercizio.S7L1.controllers;


import Back.End.Esercizio.S7L1.entities.Dispositivo;
import Back.End.Esercizio.S7L1.services.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @GetMapping
    public List<Dispositivo> getAllDispositivi() {
        return dispositivoService.getDispositiviList();
    }

    @PostMapping
    public Dispositivo saveDispositivo(@RequestBody Dispositivo body) {
        return dispositivoService.saveDispositivo(body);
    }

    @GetMapping("/{dispositivoId}")
    public Dispositivo findDispositivoById(@PathVariable long dispositivoId) {
        return dispositivoService.findById(dispositivoId);
    }

    @PutMapping("/{dispositivoId}")
    public Dispositivo findDispositivoByIdAndUpdate(@PathVariable long dispositivoId, @RequestBody Dispositivo body) {
        return dispositivoService.findByIdAndUpdate(dispositivoId, body);
    }

    @DeleteMapping("/{dispositivoId}")
    public void findDispositivoByIdAndDelete(@PathVariable long dispositivoId) {
        dispositivoService.findByIdAndDelete(dispositivoId);
    }
}
