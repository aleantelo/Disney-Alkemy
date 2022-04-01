package com.alkemy.disney.repository;

import com.alkemy.disney.entities.Character;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character,Long> {

    public List<Character> findAll(Specification<Character> specification);
}
