package com.example.springstudent.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id //    Son id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // - Son nom
    @NotEmpty
    @Size(min = 2, max= 40)
    private String nom;

    // - Son prénom
    @NotEmpty
    @Size(min = 2, max= 40)
    private String prenom;

    // - Sa date naissance
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;

    // - Son email
    @NotEmpty
    @Size(min = 2, max= 40)
    private String email;

    // - Son genre : MASCULIN ou FEMININ
    Genre  genre ;

    // - Un attribut qui indique si il est en règle ou non
    private boolean isRegle;



}
