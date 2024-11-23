package kz.example.G129.service.impl;

import kz.example.G129.model.Director;
import kz.example.G129.repository.DirectorRepository;
import kz.example.G129.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;
    @Override
    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }
}
