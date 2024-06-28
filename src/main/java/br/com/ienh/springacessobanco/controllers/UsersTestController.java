package br.com.ienh.springacessobanco.controllers;

import br.com.ienh.springacessobanco.entities.Users;
import br.com.ienh.springacessobanco.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersTestController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/teste")
    public String teste(Model model) {
        // Fetch all users and add them to the model
        Iterable<Users> users = usersRepository.findAll();
        model.addAttribute("users", users);

        return "teste";
    }
}
