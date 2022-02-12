package com.alkemy.disney.disney.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "personaje")
@Setter
@Getter
public class Character extends Active {

    @Column(name = "imagen")
    private String image;

    @Column(name = "nombre")
    private String name;

    @Column(name = "edad")
    private Integer age;

    @Column(name = "peso")
    private Double weight;

    @Column(name = "historia")
    private String history;

    @ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
    private Set<Movie> movies;

    public Character(){
        this.setActive(true);
        movies = new HashSet<>();
    }
}
