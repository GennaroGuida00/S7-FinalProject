package com.example.gestioneEventi.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(long id) {
        super("la risorsa con id "+id+ " non è stata trovata");
    }

    public NotFoundException(String mail){
        super("la risorsa con mail "+mail+ " non è stata trovata");
    }
}