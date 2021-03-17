package com.br.games.controller;

import com.br.games.services.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class GameControllerTest {

    @InjectMocks
    private GameController gameController;

    @Mock
    private GameService gameService;

    @BeforeEach
    void setUp() {
    }
}