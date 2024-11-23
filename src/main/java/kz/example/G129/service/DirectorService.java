package kz.example.G129.service;

import kz.example.G129.model.Director;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DirectorService {

    List<Director>getAllDirectors();

}
