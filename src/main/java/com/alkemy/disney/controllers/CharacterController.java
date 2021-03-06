package com.alkemy.disney.controllers;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.entities.Character;
import com.alkemy.disney.entities.Movie;
import com.alkemy.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping("/all")
    public ResponseEntity<List<CharacterBasicDTO>> getAll(){

        List<CharacterBasicDTO> characterBasicDTOS = characterService.getAllCharacters();

        return ResponseEntity.ok().body(characterBasicDTOS);
    }

    @PostMapping
    public ResponseEntity<CharacterDTO> save (@RequestBody CharacterDTO characterDTO) {

        CharacterDTO savedCharacter = characterService.save(characterDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCharacter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        characterService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> modify(@RequestBody CharacterDTO characterDTO){

        CharacterDTO savedCharacter = characterService.modify(characterDTO);

        return ResponseEntity.ok().body(savedCharacter);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> characterDetail(@PathVariable Long id){

        CharacterDTO characterDetail = characterService.getCharacterById(id);

        return ResponseEntity.ok().body(characterDetail);
    }

    @GetMapping()
    public ResponseEntity<List<CharacterDTO>> getDetailsByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false)Set<Long> movies
            ) {

        List<CharacterDTO> characters = characterService.getByFilters(name,age,movies);

        return ResponseEntity.ok().body(characters);
    }
}
