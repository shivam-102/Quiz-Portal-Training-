package com.epam.quizportal.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
@Getter
@Setter
public class AuthenticationRequest implements Serializable {
    String username;

    String password;

    public AuthenticationRequest(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
}
