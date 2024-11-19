package kz.example.G129.service.impl;

import kz.example.G129.model.Film;
import kz.example.G129.repository.ItemRepository;
import kz.example.G129.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Film> getAllFilms() {
        return itemRepository.findAll();
    }

    public Film findById(int id) {
        return itemRepository.findById(id).get();
    }

    public void deleteFilmById(int id) {
        itemRepository.deleteById(id);
    }

    public void addFilm(Film film) {
        itemRepository.save(film);
    }

    public void updateFilm(Film film) {
        itemRepository.save(film);
    }
}
