package com.br.games.requests;

import lombok.Data;

@Data
public class GamePutRequestBody {

    private Long id;

    private String name;

    private String producer;

    private Long releaseYear;
}
