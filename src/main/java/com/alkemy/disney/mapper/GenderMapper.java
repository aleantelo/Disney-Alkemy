package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.GenderDTO;
import com.alkemy.disney.entities.Character;
import com.alkemy.disney.entities.Gender;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenderMapper {

    public Gender genderDtoToEntity(GenderDTO genderDTO){

        Gender gender = new Gender();
        gender.setImage(genderDTO.getImage());
        gender.setName(genderDTO.getName());
        return gender;
    }

    public GenderDTO genderEntityToDto(Gender gender){

        GenderDTO genderDTO= new GenderDTO();
        genderDTO.setId(gender.getId());
        genderDTO.setImage(gender.getImage());
        genderDTO.setName(gender.getName());
        return genderDTO;
    }

    public List<GenderDTO> genderEntityToDtoList(List<Gender> genderList){
        List<GenderDTO> genderDTOList = new ArrayList<>();

        for (Gender gender:genderList){
            genderDTOList.add(this.genderEntityToDto(gender));
        }

        return genderDTOList;
    }


}
