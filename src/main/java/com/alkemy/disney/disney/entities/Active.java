package com.alkemy.disney.disney.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@Getter
public abstract class Active extends PersistentEntity {

    @Column(name = "activo")
    private Boolean active;    //Atributo que representa si esta borrado o no. (baja logica)
}
