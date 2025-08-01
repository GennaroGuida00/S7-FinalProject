package controllers;

import entities.Event;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import payloads.NewEventDto;
import services.EventService;

@RestController
@RequestMapping("/eventi")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping
    public Event addEvent(@Valid @RequestBody NewEventDto eventDto) {
        return eventService.addEvent(eventDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.delete(id);
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable long id) {
        return eventService.findById(id);
    }


}
