package com.example.mymovie.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Acteur {
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private List<Film> filmographie;
}
