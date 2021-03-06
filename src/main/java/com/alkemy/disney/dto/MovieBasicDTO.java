package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class MovieBasicDTO {

    private String image;

    private String title;

    private LocalDate creationDate;
}
