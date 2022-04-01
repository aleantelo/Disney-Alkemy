package com.alkemy.disney.dto;

import com.alkemy.disney.entities.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class CharacterFiltersDTO {

    private String name;
    private Integer age;
    private Set<Long> movies;

    public CharacterFiltersDTO(String name, Integer age,Set<Long> movies){
        this.name = name;
        this.age = age;
        this.movies = movies;
    }


}
