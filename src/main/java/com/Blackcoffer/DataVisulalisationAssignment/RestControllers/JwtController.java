package com.Blackcoffer.DataVisulalisationAssignment.RestControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Blackcoffer.DataVisulalisationAssignment.Models.JwtRequest;
import com.Blackcoffer.DataVisulalisationAssignment.Models.JwtResponse;
import com.Blackcoffer.DataVisulalisationAssignment.Utilities.Jwthelper;

import lombok.AllArgsConstructor;
import lombok.Builder;

@RestController
@AllArgsConstructor
@Builder
@CrossOrigin(origins = "http://localhost:3000")
public class JwtController {

    private UserDetailsService userDetailsService;

    private AuthenticationManager manager;

    private Jwthelper helper;

    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

    	 this.doAuthenticate(request.getUsername(), request.getPassword());


         UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
         String token = this.helper.generateToken(userDetails);

         JwtResponse response = JwtResponse.builder()
                 .jwtToken(token)
                 .build();
         return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Credentials Invalid !!");
        }

    }
}