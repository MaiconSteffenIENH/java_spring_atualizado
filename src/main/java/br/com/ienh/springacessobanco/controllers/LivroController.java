package br.com.ienh.springacessobanco.controllers;

import br.com.ienh.springacessobanco.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroService livroService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("livros", livroService.obterTodos());
        return "/livro/listar";
    }
}
