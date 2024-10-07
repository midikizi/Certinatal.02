package com.example.Certinatal.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.Certinatal.services.impl.UserServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class JwtFilter extends OncePerRequestFilter{

    private UserServiceImpl userServiceImpl;
    private JwtService jwtService;

    public JwtFilter(UserServiceImpl userServiceImpl, JwtService jwtService) {
        this.userServiceImpl = userServiceImpl;
        this.jwtService = jwtService;
    }

    @SuppressWarnings("null")
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException {
        String token = null;
        String username = null;
        boolean isTokenExpired = true;

       final String authorization = request.getHeader("Authorization");

       if(authorization != null && authorization.startsWith("Bearer")){
        token = authorization.substring(7);
        isTokenExpired = jwtService.isTokenExpired(token);
        username = jwtService.extractUsername(token);
       }

       if(!isTokenExpired && username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userServiceImpl.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request, response);
    }

}
