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
public class Gender extends Active {

    @Column(name = "nombre")
    private String name;

    @Column(name = "imagen")
    private String image;

}
