package pl.hotowy.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.hotowy.springsecurity.db.UserRepository;
import pl.hotowy.springsecurity.model.User;

import java.security.Principal;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model, @Autowired Principal principal){
        model.addAttribute("user",principal);
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        User admin = userRepository.findOne(1L);
        if (admin.getPassword().equals("admin")){
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(admin.getPassword());
            admin.setPassword(hashedPassword);
            userRepository.save(admin);
        }
        return "login";
    }

    @GetMapping("/admin")
    public String admin(){
        return "adminPanel";
    }
}
