package com.epam.quizportal.controller;


import com.epam.quizportal.dto.AuthenticationRequest;
import com.epam.quizportal.dto.AuthenticationResponse;
import com.epam.quizportal.service.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationApiController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping(value="/authenticate")
    public ResponseEntity<AuthenticationResponse> createAuthenticationNewToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println("in cont");

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
        }catch (BadCredentialsException badCredentialsException){
            throw new Exception("Incorrect Username or Password");
        }
        final UserDetails userDetail=userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt=jwtUtil.generateToken(userDetail);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
