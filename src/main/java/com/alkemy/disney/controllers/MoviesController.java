package com.alkemy.disney.controllers;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.MovieBasicDTO;
import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MoviesController {

    @Autowired
    MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<MovieBasicDTO>> getAll(){

        List<MovieBasicDTO> movieDTOS = movieService.getAllCharacters();

        return ResponseEntity.ok().body(movieDTOS);
    }

    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movieDTO){

        MovieDTO savedMovie = movieService.save(movieDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }
}
