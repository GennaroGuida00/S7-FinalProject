package repositories;

import entities.Event;
import entities.Prenotation;
import entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface PrenotationRepository extends JpaRepository<Prenotation,Long> {
    @Query("SELECT COUNT(p) from Prenotazione p WHERE p.event=:event")
    int numeroPrenotazioniPerEvento(@Param("event") Event event);
}
