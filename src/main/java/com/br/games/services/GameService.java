package com.br.games.services;

import com.br.games.domain.Games;
import com.br.games.exception.BadRequestException;
import com.br.games.mapper.GamesMapper;
import com.br.games.repository.GamesRepository;
import com.br.games.requests.GamePostRequestBody;
import com.br.games.requests.GamePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GamesRepository gamesRepository;


    public Page<Games> listAll(Pageable pageable) {

        return gamesRepository.findAll(pageable);
    }

    public Games save(GamePostRequestBody gamePostRequestBody) {
        return gamesRepository.save(GamesMapper.INSTANCE.toGame(gamePostRequestBody));
    }

    public Games findById(long id) {
         return gamesRepository.findById(id)
                 .orElseThrow(() -> new BadRequestException("Game not Found"));
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
