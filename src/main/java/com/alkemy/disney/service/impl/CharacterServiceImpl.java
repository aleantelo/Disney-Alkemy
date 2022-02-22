package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.GenderDTO;
import com.alkemy.disney.entities.Character;
import com.alkemy.disney.entities.Gender;
import com.alkemy.disney.mapper.CharacterMapper;
import com.alkemy.disney.repository.CharacterRepository;
import com.alkemy.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    CharacterMapper characterMapper;

    @Override
    public List<CharacterBasicDTO> getAllCharacters() {

        List<Character> characters = characterRepository.findAll();

        List<CharacterBasicDTO> characterBasicDTOS= characterMapper.characterEntityToBasicDtoList(characters);

        return  characterBasicDTOS;
    }

    @Override
    public CharacterDTO save(CharacterDTO characterDTO ) {

        Character character = characterMapper.characterDtoToEntity(characterDTO);

        Character characterSaved = characterRepository.save(character);

        CharacterDTO result = characterMapper.characterEntityToDto(characterSaved);

        return characterDTO;
    }

    @Override
    public void delete(Long id) {

        characterRepository.deleteById(id);
    }

    @Override
    public CharacterDTO modify(CharacterDTO characterDTO) {

        Character savedCharacter = characterMapper.characterDtoToEntity(characterDTO);

        characterRepository.save(savedCharacter);

        CharacterDTO result = characterMapper.characterEntityToDto(savedCharacter);
        return result;
    }

}
