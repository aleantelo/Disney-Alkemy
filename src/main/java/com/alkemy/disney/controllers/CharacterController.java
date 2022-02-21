package com.alkemy.disney.controllers;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.entities.Character;
import com.alkemy.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping
    public ResponseEntity<List<CharacterBasicDTO>> getAll(){

        List<CharacterBasicDTO> characterBasicDTOS = characterService.getAllCharacters();

        return ResponseEntity.ok().body(characterBasicDTOS);
    }

    @PostMapping
    public ResponseEntity<CharacterDTO> save (@RequestBody CharacterDTO characterDTO) {

        CharacterDTO savedCharacter = characterService.save(characterDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCharacter);
    }
}
