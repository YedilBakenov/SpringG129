package kz.example.G129.conroller;

import kz.example.G129.db.DBManager;
import kz.example.G129.model.Film;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @GetMapping(value = "/") //@WebServlet(value="/")
    public String homePage(Model model) {
        model.addAttribute("filmy", DBManager.getFilms()); // request.setAttribute("films",  DBManager.getFilms());
        return "main"; // request.getRequestDispatcher("/main.jsp").forward(request,response);
    }

    @PostMapping(value = "/add-film")
    public String addFilm(Film film) {
        DBManager.addFilm(film);
        return "redirect:/";
    }

    @PostMapping(value = "/add-film-v2")
    public String addFilmV2(@RequestParam String name, // String name = request.getParameter("name");
                            @RequestParam String genre,
                            @RequestParam double duration) {
        Film film = new Film();
        film.setName(name);
        film.setDuration(duration);
        film.setGenre(genre);
        DBManager.addFilm(film);
        return "redirect:/";
    }

    @GetMapping(value = "/add-film")
    public String addFilm() {
        return "add-film";
    }
}
