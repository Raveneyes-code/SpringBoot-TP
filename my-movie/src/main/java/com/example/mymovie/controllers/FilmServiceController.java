package com.example.mymovie.controllers;

import com.example.mymovie.beans.Acteur;
import com.example.mymovie.beans.Film;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class FilmServiceController {

    private static final Map<String, Acteur> ActeurData = new HashMap<String, Acteur>() {
        {
            put("Aiman",new Acteur("Aiman","Benomar",new Date(1997, 1, 5),new ArrayList<Film>()));
            put("Anass",new Acteur("Anass","Benomar",new Date(2001, 3, 16),new ArrayList<Film>()));
            put("Yhaya",new Acteur("Yhaya","Benomar",new Date(2005, 4, 14),new ArrayList<Film>()));
        }
    };
    private static final Map<String, Film> FilmData = new HashMap<String, Film>() {
        {
            put("Hobbit",new Film("Hobbit","realisateur1",new Date(2033, 1, 16),ActeurData.get(1)));
            put("Avatar",new Film("Avatar","realisateur2",new Date(2023, 5, 12),ActeurData.get(3)));
            put("Harry Potter",new Film("Harry Potter","realisateur3",new Date(2018, 2, 4),ActeurData.get(2)));
        }
    };

    @RequestMapping(value = "/findActeurDetails/{ActeurNom}", method = RequestMethod.GET)
    public Acteur getActeurDetails(@PathVariable String ActeurNom){
        Acteur acteur= ActeurData.get(ActeurNom);
        if (acteur == null) {
            acteur = new Acteur("N/A","N/A",new Date(0, 0, 0),new ArrayList<Film>());
        }
        return acteur;
    }

    @RequestMapping(value = "/findAllActeur", method = RequestMethod.GET)
    public Map<String, Acteur> getAllActeurs(){
        return ActeurData;
    }
    @RequestMapping(value = "/findActeurByFilm/{filmTitle}", method = RequestMethod.GET)
    public Acteur getActeurByFilm(@PathVariable String filmTitle){
        Acteur acteur=null;
        for (Map.Entry<String, Acteur> entry : ActeurData.entrySet()) {
            if (entry.getValue().getFilmographie().contains(filmTitle)) {
                acteur= entry.getValue();
        }
    }
        if (acteur == null) {
            acteur = new Acteur("N/A","N/A",new Date(0, 0, 0),new ArrayList<Film>());
        }
        return acteur;
    }

    @RequestMapping(value = "/findAllFilms", method = RequestMethod.GET)
    public Map<String, Film> getAllFilms(){
        return FilmData;
    }
    @RequestMapping(value = "/findFilmDetails/{FilmNom}", method = RequestMethod.GET)
    public Film getFilmDetails(@PathVariable String FilmNom){
        Film film= FilmData.get(FilmNom);
        if (film == null) {
            film = new Film("N/A","N/A",new Date(0, 0, 0),null);
        }
        return film;
    }


}
