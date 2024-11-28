package kz.example.G129.conroller;

import kz.example.G129.model.Film;
import kz.example.G129.model2.Award;
import kz.example.G129.repository.FilmRepository;
import kz.example.G129.repository2.AwardRepository;
import kz.example.G129.service.ActorService;
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
    private final DirectorService directorService;
    private final ActorService actorService;
    private final AwardRepository awardRepository;


    @PostMapping(value = "/add-award")
    public String addAward(Award award){
        awardRepository.save(award);
        return "redirect:/";
    }


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
        var film = filmService.findById(id);
        model.addAttribute("film", film);
        model.addAttribute("directors",directorService.getAllDirectors());
        var actors = actorService.getAllActors();
        actors.removeAll(film.getActors());
        model.addAttribute("actors", actors);
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

    @PostMapping(value = "/delete-actor")
    public String deleteActor(@RequestParam int film_id,
                              @RequestParam int acter_id){
        var film = filmService.findById(film_id);
        var acter = actorService.getActorById(acter_id);

        film.getActors().remove(acter);

        filmService.updateFilm(film);

        return "redirect:film-details/" + film_id;

    }

    @PostMapping(value = "/add-actor")
    public String addActor(@RequestParam int film_id,
                           @RequestParam int acter_id){
        var film = filmService.findById(film_id);
        var acter = actorService.getActorById(acter_id);


        film.getActors().add(acter);

        filmService.updateFilm(film);

        return "redirect:film-details/" + film_id;

    }
}
