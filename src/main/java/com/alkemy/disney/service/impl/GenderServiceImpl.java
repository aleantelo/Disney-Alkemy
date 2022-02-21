package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.GenderDTO;
import com.alkemy.disney.entities.Gender;
import com.alkemy.disney.mapper.GenderMapper;
import com.alkemy.disney.repository.GenderRepository;
import com.alkemy.disney.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    GenderRepository genderRepository;

    @Autowired
    GenderMapper genderMapper;

    @Override
    public GenderDTO save(GenderDTO genderDTO) {

        Gender gender = genderMapper.genderDtoToEntity(genderDTO);

        Gender genderSaved  = genderRepository.save(gender);

        GenderDTO result = genderMapper.genderEntityToDto(genderSaved);

        System.out.println("Genero guardado" );
        
        return result;
    }

    @Override
    public List<GenderDTO> getAllGenders() {

        List<Gender> genderEntities = genderRepository.findAll();

        List<GenderDTO> resultList = genderMapper.genderEntityToDtoList(genderEntities);

        return resultList;
    }

    @Override
    public void delete(Long id) {

        genderRepository.deleteById(id);
    }
}
