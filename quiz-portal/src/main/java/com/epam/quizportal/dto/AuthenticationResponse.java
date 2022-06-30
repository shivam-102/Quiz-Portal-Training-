package com.epam.quizportal.dto;

import lombok.Getter;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
    @Getter
    private final String jwt;

    public AuthenticationResponse(String jwt){
        super();
        this.jwt=jwt;
    }
}
