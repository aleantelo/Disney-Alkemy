package com.alkemy.disney.service;

import com.alkemy.disney.dto.GenderDTO;
import com.alkemy.disney.entities.Gender;

import java.util.List;

public interface GenderService {

    public GenderDTO save (GenderDTO genderDTO);

    public List<GenderDTO> getAllGenders();

    public void delete(Long id);
}
