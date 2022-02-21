package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.GenderDTO;
import com.alkemy.disney.entities.Character;
import com.alkemy.disney.entities.Gender;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMapper {

    public Character characterDtoToEntity (CharacterDTO characterDTO){

        Character character = new Character();

        character.setAge(characterDTO.getAge());
        character.setImage(characterDTO.getImage());
        character.setName(characterDTO.getName());
        character.setHistory(characterDTO.getHistory());
        character.setWeight(characterDTO.getWeight());
        character.setMovies(characterDTO.getMovies());

        return character;
    }

    public CharacterBasicDTO characterEntityToBasicDto(Character character){
        CharacterBasicDTO characterBasicDTO = new CharacterBasicDTO();

        characterBasicDTO.setImage(character.getImage());
        characterBasicDTO.setName(character.getName());

        return characterBasicDTO;
    }

    public List<CharacterBasicDTO> characterEntityToBasicDtoList(List<Character> characters){

        List<CharacterBasicDTO> characterBasicDTOS = new ArrayList<>();

        for (Character character:characters){
            characterBasicDTOS.add(this.characterEntityToBasicDto(character));
        }

        return characterBasicDTOS;
    }

    public CharacterDTO characterEntityToDto(Character character){

        CharacterDTO characterDTO = new CharacterDTO();

        characterDTO.setAge(character.getAge());
        characterDTO.setHistory(character.getHistory());
        characterDTO.setId(character.getId());
        characterDTO.setMovies(character.getMovies());
        characterDTO.setImage(character.getImage());
        characterDTO.setWeight(character.getWeight());
        characterDTO.setName(character.getName());

        return characterDTO;
    }
}
