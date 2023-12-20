package com.sistema.bancario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    private Long id;

    private String name;
    private String lastname;
    private String contact;
    private String mail;
    private String direction;

}
