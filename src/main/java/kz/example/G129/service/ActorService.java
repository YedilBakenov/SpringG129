package kz.example.G129.service;

import kz.example.G129.model.Actor;
import kz.example.G129.model.Film;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActorService {

    List<Actor>getAllActors();

    Actor getActorById(int id);
}
