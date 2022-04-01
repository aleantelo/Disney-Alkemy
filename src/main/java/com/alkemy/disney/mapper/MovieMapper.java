package com.alkemy.disney.mapper;


import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.MovieBasicDTO;
import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    @Autowired
    CharacterMapper characterMapper;

    public Movie movieDtoToEntity (MovieDTO movieDTO){

        Movie movie = new Movie();

        movie.setId(movieDTO.getId());
        movie.setGender(movieDTO.getGender());
        movie.setImage(movieDTO.getImage());
        movie.setQualification(movieDTO.getQualification());
        //movie.setCreationDate(movieDTO.getCreationDate()); FALTA FORMATEAR LA FECHA
        movie.setTitle(movieDTO.getTitle());
        //TODO:AGREGAR LOS CHARACTERS

        return movie;
    }

    public MovieBasicDTO movieEntityToBasicDTO(Movie movie){
//asdd
        MovieBasicDTO movieBasicDTO = new MovieBasicDTO();

        movieBasicDTO.setImage(movie.getImage());
        movieBasicDTO.setTitle(movie.getTitle());
        movieBasicDTO.setCreationDate(movie.getCreationDate());

        return movieBasicDTO;
    }

    public List<MovieBasicDTO> movieEntityToBasicDtoList(List<Movie> movies){

        List<MovieBasicDTO> movieBasicDTOS = new ArrayList<>();

        for (Movie movie:movies){
            movieBasicDTOS.add(this.movieEntityToBasicDTO(movie));
        }

        return movieBasicDTOS;
    }

    public MovieDTO movieEntityToDto(Movie movie, boolean loadCharacters){

        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setGender(movie.getGender());
        movieDTO.setCreationDate(movie.getCreationDate());
        movieDTO.setId(movie.getId());
        movieDTO.setImage(movie.getImage());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setQualification(movie.getQualification());
        if(loadCharacters){
            List<CharacterDTO> characterDTOS = this.characterMapper.characterEntitySetToDtoList(movie.getCharacters(), false);
            movieDTO.setCharacters(characterDTOS);
        }

        return movieDTO;
    }

    public List<MovieDTO> movieEntityListToDtoList(List<Movie> movies, boolean loadCharacters) {

        List<MovieDTO> movieDTOS = new ArrayList<>();

        for(Movie movie:movies){
            movieDTOS.add(this.movieEntityToDto(movie,loadCharacters));
        }
        return movieDTOS;
    }
}