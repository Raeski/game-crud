package com.br.games.services;

import com.br.games.domain.Games;
import com.br.games.repository.GamesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class GameService implements GamesRepository {



    private static List<Games> games;

    static {
        games = new ArrayList<>(List.of(new Games(1, "Assassins Creed", "Ubisoft", 2020), new Games(2, "World of Warcraft", "Blizard", 2000)));
    }

    public List<Games> listAll() {

        return games;
    }

    public Games save(Games game) {
        game.setId((int) ThreadLocalRandom.current().nextLong(3, 100));
        games.add(game);
        return game;
    }

    public Games findById(long id) {
         return games.stream()
                 .filter(game -> game.getId() == id)
                 .findFirst()
                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Game not Found"));
    }


}
