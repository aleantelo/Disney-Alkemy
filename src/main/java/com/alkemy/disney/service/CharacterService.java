package com.alkemy.disney.service;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.GenderDTO;
import com.alkemy.disney.entities.Character;
import com.alkemy.disney.entities.Movie;

import java.util.List;
import java.util.Set;

public interface CharacterService {

    public List<CharacterBasicDTO> getAllCharacters();

    public CharacterDTO save (CharacterDTO characterDTO) ;

    public void delete(Long id);

    public CharacterDTO modify (CharacterDTO characterDTO);

    public CharacterDTO getCharacterById(Long id);

    public List<CharacterDTO> getByFilters(String name, Integer age, Set<Long> movies);
}
