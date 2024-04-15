package Back.End.Esercizio.S7L1.controllers;

import Back.End.Esercizio.S7L1.payloads.dipendenti.DipendentiLoginDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @PostMapping("/login")
    public String login(@RequestBody DipendentiLoginDTO payload) {
        return "token";

    }
}
