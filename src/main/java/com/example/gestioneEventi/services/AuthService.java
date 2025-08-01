package com.example.gestioneEventi.services;

import com.example.gestioneEventi.Tools.JWTTools;
import com.example.gestioneEventi.entities.User;
import com.example.gestioneEventi.exceptions.UnauthorizedException;
import com.example.gestioneEventi.payloads.LoginUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserService userService;

    @Autowired
    private JWTTools jwtTools;

    @Autowired
    private PasswordEncoder bcrypt;


    public String checkCredentialEGenerateToken(LoginUserDto body){
        User found= userService.findByEmail(body.email());
        if (bcrypt.matches(body.password(), found.getPassword()))
        {
            String accessToken=jwtTools.createToken(found);
            return accessToken;
        }
        else{
            throw new UnauthorizedException("credenziali errate!");
        }
    }

}
