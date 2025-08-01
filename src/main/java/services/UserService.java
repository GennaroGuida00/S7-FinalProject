package services;

import com.example.gestioneEventi.exceptions.NotFoundException;
import entities.User;
import payloads.NewUserDto;
import repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(NewUserDto userDto){
        User user=new User();
        user.setNome(userDto.nome());
        user.setCognome(userDto.cognome());
        user.setDataDiNascita(userDto.dataDiNascita());
        user.setRuolo(userDto.ruolo());
        user.setEmail(userDto.email());
        user.setPassword(userDto.password());
        return userRepository.save(user);
    }

    public void delete(long id){
        userRepository.deleteById(id);
    }

    public User findByEmail(String mail){
        return userRepository.findByEmail(mail).orElseThrow(()->new NotFoundException(mail));
    }

    public List<User> findall(){
        return userRepository.findAll();
    }
}
