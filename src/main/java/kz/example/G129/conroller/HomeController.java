package kz.example.G129.conroller;

import kz.example.G129.model.Film;
import kz.example.G129.repository.FilmRepository;
import kz.example.G129.service.DirectorService;
import kz.example.G129.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final  FilmService filmService;
    private final FilmRepository filmRepository;
    private final DirectorService directorService;
    @GetMapping(value = "/") //@WebServlet(value="/")
    public String homePage(Model model) {
        model.addAttribute("filmy", filmService.getAllFilms()); // request.setAttribute("films",  DBManager.getFilms());
        return "main"; // request.getRequestDispatcher("/main.jsp").forward(request,response);
    }

    @PostMapping(value = "/add-film")
    public String addFilm(Film film) {
        filmService.addFilm(film);
        return "redirect:/";
    }

    @GetMapping(value = "/film-details/{id}")
    public String detailsFilm(@PathVariable int id,
                              Model model){
        model.addAttribute("film",filmService.findById(id));
        model.addAttribute("directors",directorService.getAllDirectors());
        return "film-details";
    }

    @GetMapping(value = "/add-film")
    public String addFilm(Model model) {
        model.addAttribute("directors", directorService.getAllDirectors());
        return "add-film";
    }

    @PostMapping(value = "/update-film")
    public String updateFilm(Film film){
       filmService.updateFilm(film);
        return "redirect:/";
    }

    @PostMapping(value = "/delete-film/{id}")
    public String deleteFilm(@PathVariable int id){
       filmService.deleteFilmById(id);

        return "redirect:/";
    }

    @GetMapping(value = "/search")
    public String searchByWord(@RequestParam String word,
                               Model model){
        model.addAttribute("filmy", filmService.getFilmsByWord(word));
        return "main";
    }
}
