package com.alkemy.disney.service;

import com.alkemy.disney.dto.MovieBasicDTO;
import com.alkemy.disney.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    public List<MovieBasicDTO> getAllCharacters ();

    public MovieDTO save(MovieDTO movieDTO);
}
