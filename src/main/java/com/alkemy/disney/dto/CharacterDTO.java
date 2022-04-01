package com.alkemy.disney.dto;

import com.alkemy.disney.entities.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Setter
@Getter
public class CharacterDTO {

    private Long id;

    private String image;

    private String name;

    private Integer age;

    private Double weight;

    private String history;

    private List<MovieDTO> movies;
}
