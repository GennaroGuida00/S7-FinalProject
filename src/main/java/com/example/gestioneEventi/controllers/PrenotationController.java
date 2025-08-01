package com.example.gestioneEventi.controllers;


import com.example.gestioneEventi.entities.Prenotation;
import com.example.gestioneEventi.entities.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import com.example.gestioneEventi.payloads.NewPrenotationDto;
import com.example.gestioneEventi.services.PrenotationService;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotationController {

    @Autowired
    PrenotationService prenotationService;

    @GetMapping
    public List<Prenotation> getTuttePrenotazioni() {
        return prenotationService.findall();
    }

    @PostMapping
    public Prenotation creaPrenotazione(@Valid @RequestBody NewPrenotationDto prenotationDto, @AuthenticationPrincipal User currentUser) {
        return prenotationService.addPrenotation(prenotationDto,currentUser);
    }

    @DeleteMapping("/{id}")
    public void eliminaPrenotazione(@PathVariable Long id) {
        prenotationService.delete(id);
    }

    @GetMapping("/{id}")
    public Prenotation getById(@PathVariable long id) {
        return prenotationService.findById(id);
    }


}
