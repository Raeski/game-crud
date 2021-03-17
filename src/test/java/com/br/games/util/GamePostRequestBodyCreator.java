package com.br.games.util;

import com.br.games.requests.GamePostRequestBody;

public class GamePostRequestBodyCreator {


    public static GamePostRequestBody createGamePostRequestBody() {
        return GamePostRequestBody.builder()
                .name(GameCreator.createGameToBeSaved().getName())
                .producer(GameCreator.createGameToBeSaved().getProducer())
                .releaseYear(GameCreator.createGameToBeSaved().getReleaseYear())
                .build();
    }
}
