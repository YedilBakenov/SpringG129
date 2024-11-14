package kz.example.G129.db;

import kz.example.G129.model.Film;

import java.util.ArrayList;

public class DBManager {

    public static ArrayList<Film> films = new ArrayList<>();

    private static int id = 6;

    static {
        films.add(new Film(1, "Harry Potter 1", "Fantasy", 100));
        films.add(new Film(2, "Harry Potter 2", "Fantasy", 110));
        films.add(new Film(3, "Harry Potter 3", "Fantasy", 120));
        films.add(new Film(4, "Harry Potter 4", "Fantasy", 90));
        films.add(new Film(5, "Harry Potter 5", "Fantasy", 95));

    }

    public static ArrayList<Film> getFilms() {
        return films;
    }

    public static void addFilm(Film film) {
        film.setId(++id);
        films.add(film);
    }

    public static Film getFilmById(int id) {
        return films.stream().filter(s-> s.getId()==id).findFirst().orElseThrow();
    }

    public static void updateFilm(Film film) {
        for(Film f: films){
            if(f.getId()==film.getId()){
                f.setGenre(film.getGenre());
                f.setDuration(film.getDuration());
                f.setName(film.getName());
            }
        }
    }

    public static void deleteFilm(int id) {
        films.removeIf(s->s.getId()==id);
    }
}
