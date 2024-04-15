package Back.End.Esercizio.S7L1.payloads.dispositivi;

import jakarta.validation.constraints.NotNull;

public record NewDispositivoDTO(
        @NotNull(message = "Il tipo del dispositivo è obbligatorio")
        String tipo,
        @NotNull(message = "Lo stato del dispositivo è obbligatorio")
        String stato
) {
}
