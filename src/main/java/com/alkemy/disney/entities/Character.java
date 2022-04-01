package com.alkemy.disney.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "charact")
@Setter
@Getter
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    private String image;

    private String name;

    private Integer age;

    private Double weight;

    private String history;

    @ManyToMany(mappedBy = "characters",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    private List<Movie> movies;

    public Character(){
        movies = new ArrayList<>();
    }
}
