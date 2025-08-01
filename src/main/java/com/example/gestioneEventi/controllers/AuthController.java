package com.example.gestioneEventi.controllers;

import com.example.gestioneEventi.entities.User;
import com.example.gestioneEventi.payloads.LoginUserDto;
import com.example.gestioneEventi.payloads.LoginUserRespDto;
import com.example.gestioneEventi.payloads.NewUserDto;
import com.example.gestioneEventi.payloads.NewUserRespDto;
import com.example.gestioneEventi.services.AuthService;
import com.example.gestioneEventi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoginUserRespDto login(@RequestBody LoginUserDto body) {
        String accessToken = authService.checkCredentialEGenerateToken(body);
        return new LoginUserRespDto(accessToken);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public NewUserRespDto save(@RequestBody @Validated NewUserDto payload, BindingResult validationResult)
    {

        if (validationResult.hasErrors()) {
            String errorMessages=validationResult.getFieldErrors()
                    .stream()
                    .map(fieldError ->fieldError.getDefaultMessage()).collect(Collectors.joining(","));

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessages);
        } else {
            User newUser = userService.addUser(payload);
            return new NewUserRespDto(newUser.getId());

        }

    }

}
