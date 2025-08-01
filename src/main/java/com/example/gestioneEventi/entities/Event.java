package com.example.gestioneEventi.entities;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table (name = "eventi")
public class Event {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String titolo;
    private String descrizione;
    private String luogo;
    private LocalDate data;
    private int postiDisponibili;

    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = false)
    private User organizer;


    public Event(String titolo, String descrizione, String luogo, LocalDate data, int postiDisponibili) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.luogo = luogo;
        this.data = data;
        this.postiDisponibili = postiDisponibili;
    }

    public Event() {
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getPostiDisponibili() {
        return postiDisponibili;
    }

    public void setPostiDisponibili(int postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }
    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", luogo='" + luogo + '\'' +
                ", data=" + data +
                ", postiDisponibili=" + postiDisponibili +
                '}';
    }
}
