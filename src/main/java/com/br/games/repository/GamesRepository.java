package com.br.games.repository;

import com.br.games.domain.Games;

import java.util.List;

public interface GamesRepository {

    List<Games> listAll();
}
