package kz.example.G129.service;

import kz.example.G129.model.Film;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("singleton")
public interface FilmService {

    List<Film>getAllFilms();
    Film findById(int id);

    void deleteFilmById(int id);

    void addFilm(Film film);

    void updateFilm(Film film);

    List<Film>getFilmsByWord(String word);

}
