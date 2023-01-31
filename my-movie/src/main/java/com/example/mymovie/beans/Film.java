package com.example.mymovie.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Film {
    private String titre;
    private String realisateur;
    private Date dateDeSortie;
    private Acteur acteurPrincipale;

}
