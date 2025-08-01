package com.example.gestioneEventi.controllers;

import com.example.gestioneEventi.entities.Event;
import com.example.gestioneEventi.entities.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import com.example.gestioneEventi.payloads.NewEventDto;
import com.example.gestioneEventi.services.EventService;

import java.util.List;

@RestController
@RequestMapping("/eventi")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")
    public Event addEvent(@Valid @RequestBody NewEventDto eventDto,@AuthenticationPrincipal User currentUser) {
        return eventService.addEvent(eventDto,currentUser);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")
    public Event updateEvent(@PathVariable Long id,
                             @RequestBody @Valid NewEventDto eventDto,
                             @AuthenticationPrincipal User currentUser) {
        return eventService.findByIdAndUpdate(id, eventDto, currentUser);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")
    public void deleteEvent(@PathVariable Long id,@AuthenticationPrincipal User currentUser) {
        eventService.delete(id,currentUser);
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable long id) {
        return eventService.findById(id);
    }

    @GetMapping
    public List<Event> getAllEvents(){
        return eventService.findall();
    }


}
