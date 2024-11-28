package kz.example.G129.service.impl;

import kz.example.G129.model.Film;
import kz.example.G129.repository.FilmRepository;
import kz.example.G129.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Film findById(int id) {
        return filmRepository.findById(id).get();
    }

    public void deleteFilmById(int id) {
        filmRepository.deleteById(id);
    }

    public void addFilm(Film film) {
        filmRepository.save(film);
    }

    public void updateFilm(Film film) {
        filmRepository.save(film);
    }

    public List<Film> getFilmsByWord(String word) {
        return filmRepository.getFilmsByWord(word);
    }
}
