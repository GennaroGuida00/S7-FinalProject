package payloads;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record NewEventDto(

        @NotNull(message = "il titolo deve essere obbligatorio!")
        String titolo,
        @NotNull(message = "la descrizione deve essere obbligatoria!")
        String descrizione,
        @NotNull(message = "il luogo deve essere obbligatorio!")
        String luogo,
        @NotNull
        @FutureOrPresent( message = "la data da inserire non deve essere nel passato")
        LocalDate data,
        @NotEmpty(message = "il numero dei posti deve essere obbligatorio!")
        int posti) {
}
