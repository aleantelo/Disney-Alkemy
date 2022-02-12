package com.alkemy.disney.disney.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pelicula")
@Setter
@Getter
public class Pelicula extends Activable{

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "calificacion")
    private Integer calificacion;

    @ManyToOne(targetEntity = Genero.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id",referencedColumnName = "id")
    private Genero genero;

    @ManyToMany(
            targetEntity = Personaje.class,
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
    private Set<Personaje> personajes;

    public Pelicula (){
        this.setActivo(true);
        personajes = new HashSet<>();
    }

}
