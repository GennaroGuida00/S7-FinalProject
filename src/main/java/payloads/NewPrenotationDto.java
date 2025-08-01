package payloads;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record NewPrenotationDto(@NotNull(message = "l'id user deve essere obbligatoria!")
                                Long userId,
                                @NotNull(message = "l'id event deve essere obbligatoria!")
                                Long eventId,
                                @NotNull
                                @FutureOrPresent( message = "la data da inserire non deve essere nel passato")
                                LocalDate dataRichiesta
){}
