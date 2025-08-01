package com.example.gestioneEventi.services;

import com.example.gestioneEventi.exceptions.NotFoundException;
import com.example.gestioneEventi.entities.User;
import com.example.gestioneEventi.payloads.NewUserDto;
import com.example.gestioneEventi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User addUser(NewUserDto userDto){
        User user=new User();
        user.setNome(userDto.nome());
        user.setCognome(userDto.cognome());
        user.setDataDiNascita(userDto.dataDiNascita());
        user.setRuolo(userDto.ruolo());
        user.setEmail(userDto.email());
        user.setPassword(passwordEncoder.encode(userDto.password()));
        return userRepository.save(user);
    }

    public void delete(long id){
        userRepository.deleteById(id);
    }

    public User findByEmail(String mail){
        return userRepository.findByEmail(mail).orElseThrow(()->new NotFoundException(mail));
    }

    public User findById(long id){
        return userRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }



    public List<User> findall(){
        return userRepository.findAll();
    }
}
