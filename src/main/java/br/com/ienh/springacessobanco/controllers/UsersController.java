package br.com.ienh.springacessobanco.controllers;

import br.com.ienh.springacessobanco.dto.UserDTO;
import br.com.ienh.springacessobanco.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("users", usersService.obterTodos());
        return "/users/listar";
    }

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("user") UserDTO user){
        return "/users/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("user") UserDTO user, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "/users/novoForm";
        }

        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }
        usersService.salvarUser(user);
        return "redirect:/users/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model){
        model.addAttribute("user", usersService.obterUserPorId(id));
        return "/users/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("user") UserDTO user, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/users/editarForm";

        UserDTO userAtual = usersService.obterUserPorId(user.getId());

        if(user.getName() != null && !user.getName().isEmpty()) {
            userAtual.setName(user.getName());
        }
        if(user.getEmail() != null && !user.getEmail().isEmpty()) {
            userAtual.setEmail(user.getEmail());
        }
        if(user.getPassword() != null && !user.getPassword().isEmpty()) {
            userAtual.setPassword(user.getPassword());
        }

        usersService.atualizarUser(userAtual);
        return "redirect:/users/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        usersService.excluirUser(id);
        return "redirect:/users/listar";
    }
}
