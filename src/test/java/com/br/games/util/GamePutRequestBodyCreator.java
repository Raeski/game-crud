package com.br.games.util;

import com.br.games.requests.GamePostRequestBody;
import com.br.games.requests.GamePutRequestBody;

public class GamePutRequestBodyCreator {


    public static GamePutRequestBody createGamePostRequestBody() {
        return GamePutRequestBody.builder()
                .name(GameCreator.createGameToBeSaved().getName())
                .producer(GameCreator.createGameToBeSaved().getProducer())
                .releaseYear(GameCreator.createGameToBeSaved().getReleaseYear())
                .id(GameCreator.createValidGame().getId())
                .build();
    }
}
