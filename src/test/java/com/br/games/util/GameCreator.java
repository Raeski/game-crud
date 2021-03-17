package com.br.games.util;

import com.br.games.domain.Game;

public class GameCreator {

    public static Game createGameToBeSaved() {
        return Game.builder()
                .name("Final Fantasy XIV")
                .producer("Square Enix")
                .releaseYear(2010L)
                .build();
    }

    public static Game createValidGame() {
        return Game.builder()
                .name("Final Fantasy XIV")
                .producer("Square Enix")
                .releaseYear(2010L)
                .id(1L)
                .build();
    }

    public static Game createValidUpdatedGame() {
        return Game.builder()
                .name("Final Fantasy XIV")
                .producer("Square Enix")
                .releaseYear(2010L)
                .id(1L)
                .build();
    }


}
