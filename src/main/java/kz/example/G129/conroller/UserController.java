package kz.example.G129.conroller;

import kz.example.G129.model3.User;
import kz.example.G129.repository3.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public String getAllUsers(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }


    @PostMapping(value = "/add-user")
    public String addUser(User user){
        userRepository.save(user);
        return "redirect:/";
    }

}
