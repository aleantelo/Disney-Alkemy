package com.alkemy.disney.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "gender")
@Setter
@Getter
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    private String name;

    private String image;

}
