package com.example.gestioneEventi.services;

import com.example.gestioneEventi.entities.User;
import com.example.gestioneEventi.exceptions.NotFoundException;
import com.example.gestioneEventi.entities.Event;
import com.example.gestioneEventi.exceptions.UnauthorizedException;
import com.example.gestioneEventi.payloads.NewEventDto;
import com.example.gestioneEventi.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public Event addEvent(NewEventDto newEventDto, User user){
        Event event=new Event();
        event.setTitolo(newEventDto.titolo());
        event.setDescrizione(newEventDto.descrizione());
        event.setLuogo(newEventDto.luogo());
        event.setData(newEventDto.data());
        event.setPostiDisponibili(newEventDto.posti());
        event.setOrganizer(user);
        return eventRepository.save(event);
    }

    public Event findById(long id){
        return eventRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    public Event findByIdAndUpdate(long id, NewEventDto eventDto, User currentUser){
        Event found=eventRepository.findById(id).orElseThrow(()->new NotFoundException(id));

        if (!(found.getOrganizer().getId() ==currentUser.getId())){
            throw new UnauthorizedException("non puoi modificare l'evento");
        }

        found.setTitolo(eventDto.titolo());
        found.setDescrizione(eventDto.descrizione());
        found.setData(eventDto.data());
        found.setLuogo(eventDto.luogo());
        found.setPostiDisponibili(eventDto.posti());

        if (found.getOrganizer().getId()!=(currentUser.getId())) {
            throw new UnauthorizedException("Non puoi modificare questo evento");
        }

        return eventRepository.save(found);
    }

    public void delete(long id,User user){
        Event e = findById(id);
        if (!(e.getOrganizer().getId() == user.getId())) {
            throw new UnauthorizedException("Puoi eliminare solo i tuoi eventi.");
        }
         eventRepository.deleteById(id);
    }

    public List<Event> findall(){
        return eventRepository.findAll();
    }


}
