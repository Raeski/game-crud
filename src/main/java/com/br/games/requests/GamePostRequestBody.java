package com.br.games.requests;

import lombok.Data;

@Data
public class GamePostRequestBody {

    private String name;

    private String producer;

    private Long releaseYear;

}
