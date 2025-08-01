package com.example.gestioneEventi.payloads;

import com.example.gestioneEventi.enums.Ruolo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record NewUserDto(
        @NotEmpty(message = "il nome deve essere obbligatorio!")
        String nome,
        @NotEmpty(message = "il cognome deve essere obbligatorio!")
        String cognome,
        @NotEmpty(message = "la data di nascita deve essere obbligatoria!")
        LocalDate dataDiNascita,
        @NotEmpty(message = "il ruolo deve essere obbligatorio!")
        Ruolo ruolo,
        @NotEmpty(message = "l'email essere obbligatoria!")
        @Email
        String email,
        @NotEmpty(message = "la password deve essere obbligatoria!")
        String password) {}
