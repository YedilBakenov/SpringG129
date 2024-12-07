package kz.example.G129.service.examples;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Getter
@Service
@Scope("prototype")
public class PrototypeService {
    private int count = 0;

    public void addCount(){
        count++;
    }

}
