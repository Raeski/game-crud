package com.br.games.repository;

import com.br.games.domain.Game;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Tests for Game Repository")
class GameRepositoryTest {

    @Autowired
    private GameRepository gamesRepository;


    @Test
    @DisplayName("Save create game when Successful")
    void save_PersistGame_WhenSuccessful(){
        Game gameToBeSaved = createGame();

        Game gameSaved = this.gamesRepository.save(gameToBeSaved);

        Assertions.assertThat(gameSaved).isNotNull();

        Assertions.assertThat(gameSaved.getId()).isNotNull();

        Assertions.assertThat(gameSaved.getName()).isEqualTo(gameToBeSaved.getName());

        Assertions.assertThat(gameSaved.getProducer()).isEqualTo(gameToBeSaved.getProducer());

        Assertions.assertThat(gameSaved.getReleaseYear()).isEqualTo(gameToBeSaved.getReleaseYear());
    }

    @Test
    @DisplayName("Save updates game when Successful")
    void save_UpdatesGame_WhenSuccessful(){
        Game gameToBeSaved = createGame();

        Game gameSaved = this.gamesRepository.save(gameToBeSaved);

        gameSaved.setName("Metro Exodus");

        gameSaved.setProducer("4A Games");

        gameSaved.setReleaseYear(2019L);

        Game gameUpdated = this.gamesRepository.save(gameSaved);

        Assertions.assertThat(gameUpdated).isNotNull();

        Assertions.assertThat(gameUpdated.getId()).isNotNull();

        Assertions.assertThat(gameUpdated.getName()).isEqualTo(gameToBeSaved.getName());

        Assertions.assertThat(gameUpdated.getProducer()).isEqualTo(gameToBeSaved.getProducer());

        Assertions.assertThat(gameUpdated.getReleaseYear()).isEqualTo(gameToBeSaved.getReleaseYear());
    }




    private Game createGame() {
        return Game.builder()
                .name("Skyrim V")
                .producer("Bethesda Game Studios")
                .releaseYear(2011L)
                .build();
    }
}