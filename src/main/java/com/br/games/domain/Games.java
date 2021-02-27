package com.br.games.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Games {

    private Integer id;

    private String name;

    private String producer;

    private int releaseYear;

}
