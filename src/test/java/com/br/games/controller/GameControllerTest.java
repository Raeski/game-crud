package com.br.games.controller;

import com.br.games.domain.Game;
import com.br.games.requests.GamePostRequestBody;
import com.br.games.requests.GamePutRequestBody;
import com.br.games.services.GameService;
import com.br.games.util.GameCreator;
import com.br.games.util.GamePostRequestBodyCreator;
import com.br.games.util.GamePutRequestBodyCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class GameControllerTest {

    @InjectMocks
    private GameController gameController;

    @Mock
    private GameService gameServiceMock;

    @BeforeEach
    void setUp() {

        PageImpl<Game> gamePage = new PageImpl<>(List.of(GameCreator.createValidGame()));

        BDDMockito.when(gameServiceMock.listAll(ArgumentMatchers.any()))
                .thenReturn(gamePage);

        BDDMockito.when(gameServiceMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(GameCreator.createValidGame());

        BDDMockito.when(gameServiceMock.save(ArgumentMatchers.any(GamePostRequestBody.class)))
                .thenReturn(GameCreator.createValidGame());

        BDDMockito.doNothing().when(gameServiceMock).replace(ArgumentMatchers.any(GamePutRequestBody.class));

        BDDMockito.doNothing().when(gameServiceMock).delete(ArgumentMatchers.anyLong());


    }

    @Test
    @DisplayName("List returns list of game inside page object when successful")
    void list_ReturnListOfGameInsidePageObject_WhenSuccessful(){
        String expectedName = GameCreator.createValidGame().getName();

        Page<Game> gamePage = gameController.list(null).getBody();

        Assertions.assertThat(gamePage).isNotNull();

        Assertions.assertThat(gamePage.toList())
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(gamePage.toList().get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("List returns game when successful")
    void findById_ReturnGame_WhenSuccessful(){
        Long expectedId = GameCreator.createValidGame().getId();

        Game game = gameController.findById(1).getBody();

        Assertions.assertThat(game).isNotNull();

        Assertions.assertThat(game.getId()).isNotNull().isEqualTo(expectedId);

    }

    @Test
    @DisplayName("save returns game when successful")
    void save_ReturnGame_WhenSuccessful(){

        Game game = gameController.save(GamePostRequestBodyCreator.createGamePostRequestBody()).getBody();

        Assertions.assertThat(game).isNotNull().isEqualTo(GameCreator.createValidGame());

    }

    @Test
    @DisplayName("replace updates game when successful")
    void replace_UpdatesGame_WhenSuccessful(){

        Assertions.assertThatCode(() -> gameController.replace(GamePutRequestBodyCreator.createGamePostRequestBody()))
                .doesNotThrowAnyException();

        ResponseEntity<Void> entity = gameController.replace(GamePutRequestBodyCreator.createGamePostRequestBody());

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

    }


    @Test
    @DisplayName("delete removes game when successful")
    void delete_UpdatesGame_WhenSuccessful(){

        Assertions.assertThatCode(() -> gameController.delete(1))
                .doesNotThrowAnyException();

        ResponseEntity<Void> entity = gameController.replace(GamePutRequestBodyCreator.createGamePostRequestBody());

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}