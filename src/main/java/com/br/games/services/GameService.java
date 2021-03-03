package com.br.games.services;

import com.br.games.domain.Games;
import com.br.games.mapper.GamesMapper;
import com.br.games.repository.GamesRepository;
import com.br.games.requests.GamePostRequestBody;
import com.br.games.requests.GamePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GamesRepository gamesRepository;


    public List<Games> listAll() {

        return gamesRepository.findAll();
    }

    public Games save(GamePostRequestBody gamePostRequestBody) {
        return gamesRepository.save(GamesMapper.INSTANCE.toGame(gamePostRequestBody));
    }

    public Games findById(long id) {
         return gamesRepository.findById(id)
                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Game not Found"));
    }

    public void delete(long id) {
        gamesRepository.delete(findById(id));
    }

    public void replace(GamePutRequestBody gamePutRequestBody) {
        Games savedGame = findById(gamePutRequestBody.getId());
        Games game = GamesMapper.INSTANCE.toGame(gamePutRequestBody);
        game.setId(savedGame.getId());
        gamesRepository.save(game);
    }

}
