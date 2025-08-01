package entities;


import com.example.gestioneEventi.enums.Ruolo;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "utenti")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    @Enumerated(EnumType.STRING)
    private Ruolo ruolo;
    private String email;
    private String password;

    public User(String nome, String cognome, LocalDate dataDiNascita, String email, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.ruolo = Ruolo.PARTECIPANTE;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", ruolo=" + ruolo +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
