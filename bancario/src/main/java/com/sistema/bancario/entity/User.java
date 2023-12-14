package com.sistema.bancario.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long DNI;
    private String name;
    private String lastname;
    private String contact;
    private String mail;
    private String direction;

}
