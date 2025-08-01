package services;


import com.example.gestioneEventi.exceptions.BookingNotAvailable;
import com.example.gestioneEventi.exceptions.NotFoundException;
import entities.Event;
import entities.Prenotation;
import entities.User;
import payloads.NewPrenotationDto;
import repositories.EventRepository;
import repositories.PrenotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import java.util.List;

@Service
public class PrenotationService {

    @Autowired
    PrenotationRepository prenotationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventRepository eventRepository;

    public Prenotation findById(long id){
        return prenotationRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    public Prenotation addPrenotation(NewPrenotationDto newPrenotationDto){
        Event event=eventRepository.findById(newPrenotationDto.eventId()).orElseThrow(()->new NotFoundException(newPrenotationDto.eventId()));
        User user=userRepository.findById(newPrenotationDto.userId()).orElseThrow(()->new NotFoundException(newPrenotationDto.userId()));
        boolean postiDisponibili=prenotationRepository.numeroPrenotazioniPerEvento(event)>=event.getPostiDisponibili();
        if (postiDisponibili) {
            throw new BookingNotAvailable(event.getId());
        }
            Prenotation prenotation=new Prenotation();
            prenotation.setDataRichiesta(newPrenotationDto.dataRichiesta());
            prenotation.setEvent(event);
            prenotation.setUser(user);
            return prenotationRepository.save(prenotation);



    }
    public void delete(long id){
        prenotationRepository.deleteById(id);
    }

    public List<Prenotation> findall(){
        return prenotationRepository.findAll();
    }
}
