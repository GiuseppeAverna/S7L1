package Back.End.Esercizio.S7L1.payloads.dipendenti;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record NewDipendenteDTO(
        @NotEmpty(message = "Il nome è obbligatorio")
        @Size(min = 3, max = 30, message = "Il nome deve avere minimo 3 caratteri, massimo 30")
        String nome,
        @NotEmpty(message = "Il cognome è obbligatorio")
        String cognome,
        @NotEmpty(message = "l'username è obbligatorio")
        String username,
        @NotEmpty(message = "L'email è obbligatoria")
        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "L'email inserita non è valida")
        String email
) {
}
