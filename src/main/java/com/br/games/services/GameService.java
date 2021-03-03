package com.br.games.services;

import com.br.games.domain.Games;
import com.br.games.repository.GamesRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GamesRepository gamesRepository;


    public List<Games> listAll() {

        return gamesRepository.findAll();
    }

    public Games save(Games game) {
        return gamesRepository.save(game);
    }

    public Games findById(long id) {
         return gamesRepository.findById(id)
                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Game not Found"));
    }

    public void delete(long id) {
        gamesRepository.delete(findById(id));
    }

    public void replace(Games game) {
        delete(game.getId());
//        games.add(game);
    }

}
