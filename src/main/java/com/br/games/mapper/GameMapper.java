package com.br.games.mapper;


import com.br.games.domain.Game;
import com.br.games.requests.GamePostRequestBody;
import com.br.games.requests.GamePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class GameMapper {

    public static final GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    public abstract Game toGame(GamePostRequestBody gamePostRequestBody);

    public abstract Game toGame(GamePutRequestBody gamePutRequestBody);
}
