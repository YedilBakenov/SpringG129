package kz.example.G129.service.examples;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class SingletonService {

    private int count;
    public void addCount(){
        count++;
    }

}
