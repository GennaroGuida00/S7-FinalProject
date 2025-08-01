package controllers;


import entities.Prenotation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import payloads.NewPrenotationDto;
import services.PrenotationService;

import java.util.List;

@RestController
@RequestMapping("/prenotazions")
public class PrenotationController {

    @Autowired
    PrenotationService prenotationService;

    @GetMapping
    public List<Prenotation> getTuttePrenotazioni() {
        return prenotationService.findall();
    }

    @PostMapping
    public Prenotation creaPrenotazione(@Valid @RequestBody NewPrenotationDto prenotationDto) {
        return prenotationService.addPrenotation(prenotationDto);
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
