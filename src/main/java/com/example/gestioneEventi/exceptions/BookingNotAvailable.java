package com.example.gestioneEventi.exceptions;

public class BookingNotAvailable extends RuntimeException {
    public BookingNotAvailable(long id) {

        super("l'evento con id "+id+" non ha posti disponibili");
    }
}
