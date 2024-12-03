package kz.example.G129.repository;


import kz.example.G129.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface FilmRepository extends JpaRepository<Film, Integer>{

    @Query("SELECT f FROM Film f " +
            "WHERE f.name ILIKE concat('%', :s, '%')" +
            "OR f.genre ILIKE concat('%', :s, '%')")
    List<Film>getFilmsByWord(String s);

    Film findByName(String name);
}
