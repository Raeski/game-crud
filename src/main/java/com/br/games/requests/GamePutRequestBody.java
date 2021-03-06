package com.br.games.requests;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class GamePutRequestBody {

    private Long id;

    @NotEmpty(message = "The game name cannot be empty")
    private String name;

    private String producer;

    private Long releaseYear;
}
