package com.alkemy.disney.service;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.GenderDTO;
import com.alkemy.disney.entities.Character;

import java.util.List;

public interface CharacterService {

    public List<CharacterBasicDTO> getAllCharacters();

    public CharacterDTO save (CharacterDTO characterDTO) ;
}
