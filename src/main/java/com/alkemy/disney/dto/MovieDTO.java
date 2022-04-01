package com.alkemy.disney.dto;

import com.alkemy.disney.entities.Character;
import com.alkemy.disney.entities.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Setter
@Getter
public class MovieDTO {

    private Long id;

    private String image;

    private String title;

    private LocalDate creationDate;

    private Integer qualification;

    private Gender gender;

    private List<CharacterDTO> characters;
}
