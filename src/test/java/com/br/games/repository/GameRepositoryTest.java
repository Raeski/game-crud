package com.br.games.repository;

import com.br.games.domain.Game;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
    @DisplayName("Save create game producer is empty when Successful")
    void save_PersistGameIsProducerIsEmpty_WhenSuccessful(){
        Game gameToBeSaved = createGame();

        Game gameSaved = this.gamesRepository.save(gameToBeSaved);

        gameSaved.setProducer("");

        Assertions.assertThat(gameSaved).isNotNull();

        Assertions.assertThat(gameSaved.getId()).isNotNull();

        Assertions.assertThat(gameSaved.getName()).isEqualTo(gameToBeSaved.getName());

        Assertions.assertThat(gameSaved.getProducer()).isEqualTo(gameToBeSaved.getProducer());

        Assertions.assertThat(gameSaved.getReleaseYear()).isEqualTo(gameToBeSaved.getReleaseYear());
    }

    @Test
    @DisplayName("Save create game releaseYear is null when Successful")
    void save_PersistGameIsReleaseYearIsEmpty_WhenSuccessful(){
        Game gameToBeSaved = createGame();

        Game gameSaved = this.gamesRepository.save(gameToBeSaved);

        gameSaved.setReleaseYear(null);

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

    @Test
    @DisplayName("Delete remove game when Successful")
    void delete_RemovesGame_WhenSuccessful(){
        Game gameToBeSaved = createGame();

        Game gameSaved = this.gamesRepository.save(gameToBeSaved);

        this.gamesRepository.delete(gameSaved);

        Optional<Game> gameOptional = this.gamesRepository.findById(gameSaved.getId());

        Assertions.assertThat(gameOptional).isEmpty();
    }

    @Test
    @DisplayName("Find By Name returns list of game when Sucessful")
    void findByName_ReturnsListOfGame_WhenSuccessful(){
        Game gameToBeSaved = createGame();

        Game gameSaved = this.gamesRepository.save(gameToBeSaved);

        String name = gameSaved.getName();

        Collection<Game> byName = this.gamesRepository.findByName(name);

        Assertions.assertThat(byName).isNotEmpty();

        Assertions.assertThat(byName).contains(gameSaved);

    }

    @Test
    @DisplayName("Find By Name returns empty list when no game is found")
    void findByName_ReturnsEmptyList_WhenGameIsNotFound(){
        List<Game> games = this.gamesRepository.findByName("lçop");

        Assertions.assertThat(games).isEmpty();
    }

    @Test
    @DisplayName("Save throw ConstraintViolationException when name is empty")
    void save_ThrowsConstraintViolationException_WhenNameIsEmpty() {
        Game game = new Game();

        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(() -> this.gamesRepository.save(game))
                .withMessageContaining("The game name cannot be empty");
    }

    private Game createGame() {
        return Game.builder()
                .name("Skyrim V")
                .producer("Bethesda Game Studios")
                .releaseYear(2011L)
                .build();
    }
}