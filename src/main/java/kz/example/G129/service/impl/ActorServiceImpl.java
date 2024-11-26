package kz.example.G129.service.impl;

import kz.example.G129.model.Actor;
import kz.example.G129.model.Director;
import kz.example.G129.repository.ActorRepository;
import kz.example.G129.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public Actor getActorById(int id) {
        return actorRepository.findById(id).get();
    }
}
