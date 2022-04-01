package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.MovieBasicDTO;
import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.entities.Movie;
import com.alkemy.disney.mapper.MovieMapper;
import com.alkemy.disney.repository.MovieRepository;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieMapper movieMapper;

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<MovieBasicDTO> getAllCharacters() {

        List<Movie> movies = movieRepository.findAll();

        List<MovieBasicDTO> result = movieMapper.movieEntityToBasicDtoList(movies);

        return result;
    }

    @Override
    public MovieDTO save(MovieDTO movieDTO) {

        Movie movie = movieMapper.movieDtoToEntity(movieDTO);
        return null;
    }
}
