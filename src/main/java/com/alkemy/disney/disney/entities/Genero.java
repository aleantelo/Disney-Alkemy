package com.alkemy.disney.disney.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "genero")
@Setter
@Getter
public class Genero extends Activable{

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "imagen")
    private String imagen;

}
