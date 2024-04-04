package com.lql.springdemo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @SequenceGenerator(name = "id_generator_seq", sequenceName = "id_generator_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "id_generator_seq")
    private Long id;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String username;

    @NotNull
    @NotBlank
    @Length(min = 6)
    private String password;
}
