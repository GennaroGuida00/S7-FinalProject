package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
public class Prenotation {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private LocalDate dataRichiesta;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id",nullable = false)
    private Event event;

    public Prenotation(LocalDate dataRichiesta, User user, Event event) {
        this.dataRichiesta = dataRichiesta;
        this.user = user;
        this.event = event;
    }

    public Prenotation() {
    }

    public long getId() {
        return id;
    }

    public LocalDate getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(LocalDate dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Prenotation{" +
                "id=" + id +
                ", dataRichiesta=" + dataRichiesta +
                ", user=" + user +
                ", event=" + event +
                '}';
    }
}
