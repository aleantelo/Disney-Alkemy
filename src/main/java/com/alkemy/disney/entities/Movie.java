package com.alkemy.disney.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movie")
@Setter
@Getter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    private String image;

    private String title;

    private LocalDate creationDate;

    private Integer qualification;

    @ManyToOne(
            targetEntity = Gender.class,
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(name = "gender_id",referencedColumnName = "id")
    private Gender gender;

    @ManyToMany(
            targetEntity = Character.class,
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name="movie_charact",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "charact_id")}
    )
    private List<Character> characters;

    public Movie(){
        characters = new ArrayList<>();
    }

}
