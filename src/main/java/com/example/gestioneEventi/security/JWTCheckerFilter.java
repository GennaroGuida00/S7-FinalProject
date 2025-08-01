package com.example.gestioneEventi.security;

import com.example.gestioneEventi.Tools.JWTTools;
import com.example.gestioneEventi.entities.User;
import com.example.gestioneEventi.exceptions.UnauthorizedException;
import com.example.gestioneEventi.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class  JWTCheckerFilter extends OncePerRequestFilter {


    @Autowired
    private JWTTools jwtTools;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response , FilterChain filterChain) throws ServletException, IOException {


        String autHeader=request.getHeader("Authorization");
        if(autHeader==null || !autHeader.startsWith("Bearer "))
            throw new UnauthorizedException("inserire il token nell'authorization Header nel fromato corretto");

        String accessToken=autHeader.replace("Bearer ","");
        jwtTools.verifyToken(accessToken);
        String userid=jwtTools.extractIdFromToken(accessToken);
        User user= userService.findById(Long.parseLong(userid));
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request,response);
    }
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request){
        return new AntPathMatcher().match("/auth/**",request.getServletPath());
    }
}
