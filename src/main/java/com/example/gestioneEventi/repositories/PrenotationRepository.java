package com.example.gestioneEventi.repositories;

import com.example.gestioneEventi.entities.Event;
import com.example.gestioneEventi.entities.Prenotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PrenotationRepository extends JpaRepository<Prenotation,Long> {
    @Query("SELECT COUNT(p) from Prenotazione p WHERE p.event=:event")
    int numeroPrenotazioniPerEvento(@Param("event") Event event);
}
