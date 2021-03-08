package com.br.games.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) // Aqui eu falo que essa exception sempre vai ser do tipo BadRequestException
public class BadRequestException extends RuntimeException{

    public BadRequestException(String message) {
        super(message);
    }

}
