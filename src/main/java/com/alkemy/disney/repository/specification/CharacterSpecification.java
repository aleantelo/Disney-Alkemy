package com.alkemy.disney.repository.specification;

import com.alkemy.disney.dto.CharacterFiltersDTO;
import com.alkemy.disney.entities.Character;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class CharacterSpecification {

    public Specification<Character> getByFilters(CharacterFiltersDTO filtersDTO) {
        return  (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.hasLength(filtersDTO.getName())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                "%" + filtersDTO.getName().toLowerCase() +"%"
                        )
                );
            }

            if(filtersDTO.getAge() != null){
                predicates.add(criteriaBuilder.equal(root.get("age"),filtersDTO.getAge()));
            }
            query.distinct(true);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
