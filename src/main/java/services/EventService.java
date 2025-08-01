package services;

import com.example.gestioneEventi.exceptions.NotFoundException;
import entities.Event;
import entities.User;
import payloads.NewEventDto;
import repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public Event addEvent(NewEventDto newEventDto){
        Event event=new Event();
        event.setTitolo(newEventDto.titolo());
        event.setDescrizione(newEventDto.descrizione());
        event.setLuogo(newEventDto.luogo());
        event.setData(newEventDto.data());
        event.setPostiDisponibili(newEventDto.posti());
        return eventRepository.save(event);
    }

    public Event findById(long id){
        return eventRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    public void delete(long id){
         eventRepository.deleteById(id);
    }

    public List<Event> findall(){
        return eventRepository.findAll();
    }


}
