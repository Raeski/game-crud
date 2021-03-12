package com.br.games.controller;

import com.br.games.domain.Games;
import com.br.games.requests.GamePostRequestBody;
import com.br.games.requests.GamePutRequestBody;
import com.br.games.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/games")
@RestController
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping
    public ResponseEntity<Page<Games>> list(Pageable pageable) {

        return ResponseEntity.ok(gameService.listAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Games> save(@RequestBody @Valid GamePostRequestBody games) {
        return new ResponseEntity<>(gameService.save(games), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Games> findById(@PathVariable long id) {

        return ResponseEntity.ok(gameService.findById(id));

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        gameService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody @Valid GamePutRequestBody games) {
        gameService.replace(games);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
