package com.alkemy.disney.disney.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pelicula")
@Setter
@Getter
public class Movie extends Active {

    @Column(name = "imagen")
    private String image;

    @Column(name = "titulo")
    private String title;

    @Column(name = "fecha_creacion")
    private LocalDate creationDate;

    @Column(name = "calificacion")
    private Integer qualification;

    @ManyToOne(targetEntity = Gender.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id",referencedColumnName = "id")
    private Gender gender;

    @ManyToMany(
            targetEntity = Character.class,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name="pelicula_personaje",
            joinColumns = {@JoinColumn(name = "pelicula_id")},
            inverseJoinColumns = {@JoinColumn(name = "personaje_id")}
    )
    private Set<Character> characters;

    public Movie(){
        this.setActive(true);
        characters = new HashSet<>();
    }

}
