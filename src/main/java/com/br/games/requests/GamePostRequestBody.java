package com.br.games.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class GamePostRequestBody {

    @NotEmpty(message = "The game name cannot be empty")
    private String name;

    private String producer;

    private Long releaseYear;

}
