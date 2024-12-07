package kz.example.G129.conroller;

import kz.example.G129.service.examples.PrototypeService;
import kz.example.G129.service.examples.SingletonService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scope")
public class ExampleController {

    @Autowired
    private ObjectProvider<PrototypeService> prototypeServiceProvider;

    @Autowired
    private SingletonService singletonService;

    @GetMapping("/single")
    public String getSingleton(){
        singletonService.addCount();
        System.out.println(singletonService.getCount());
        return "index";
    }

    @GetMapping("/ptototype")
    public String getProto(){
        PrototypeService prototypeService = prototypeServiceProvider.getObject(); // Создаёт новый экземпляр
        prototypeService.addCount();
        System.out.println(prototypeService.getCount());
        return "index";
    }

}
