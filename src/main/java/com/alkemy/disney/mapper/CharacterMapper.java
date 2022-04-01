package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.GenderDTO;
import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.entities.Character;
import com.alkemy.disney.entities.Gender;
import com.alkemy.disney.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CharacterMapper {

    @Autowired
    MovieMapper movieMapper;

    public Character characterDtoToEntity (CharacterDTO characterDTO){

        Character character = new Character();

        character.setId(characterDTO.getId());

        if(characterDTO.getAge()!=null){
            character.setAge(characterDTO.getAge());
        }
        if(StringUtils.hasLength(characterDTO.getImage())){
            character.setImage(characterDTO.getImage());
        }
        if(StringUtils.hasLength(characterDTO.getName())){
            character.setName(characterDTO.getName());
        }
        if(StringUtils.hasLength(characterDTO.getHistory())){
            character.setHistory(characterDTO.getHistory());
        }
        if(characterDTO.getWeight()!=null){
            character.setWeight(characterDTO.getWeight());
        }
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

    public CharacterDTO characterEntityToDto(Character character, boolean loadMovies){

        CharacterDTO characterDTO = new CharacterDTO();

        characterDTO.setAge(character.getAge());
        characterDTO.setHistory(character.getHistory());
        characterDTO.setId(character.getId());
        characterDTO.setImage(character.getImage());
        characterDTO.setWeight(character.getWeight());
        characterDTO.setName(character.getName());

        if(loadMovies){
            List<MovieDTO> movieDTOS = this.movieMapper.movieEntityListToDtoList(character.getMovies(), false);
            characterDTO.setMovies(movieDTOS);
        }

        return characterDTO;
    }

    public List<CharacterDTO> characterEntitySetToDtoList(Collection<Character> characters,boolean loadMovies){
        List<CharacterDTO> characterDTOS = new ArrayList<>();

        for(Character character:characters){
            characterDTOS.add(this.characterEntityToDto(character,true));
        }

        return characterDTOS;
    }
}
