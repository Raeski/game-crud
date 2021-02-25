package com.br.games.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Games {

    private String name;

    private String producer;

    private Date releaseYear;

}
