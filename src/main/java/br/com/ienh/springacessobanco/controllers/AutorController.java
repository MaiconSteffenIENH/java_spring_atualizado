package br.com.ienh.springacessobanco.controllers;

import br.com.ienh.springacessobanco.dto.AutorDTO;
import br.com.ienh.springacessobanco.services.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    AutorService autorService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("autores", autorService.obterTodos());
        return "/autor/listar";
    }

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("autor") AutorDTO autor){
        return "/autor/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("autor") AutorDTO autor, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/autor/novoForm";
        autorService.salvarAutor(autor);
        return "redirect:/autor/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        autorService.excluirAutor(id);
        return "redirect:/autor/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model){
        model.addAttribute("autor", autorService.obterAutorPorID(id));
        return "/autor/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("autor") AutorDTO autor, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/autor/editarForm";
        autorService.atualizarAutor(autor);
        return "redirect:/autor/listar";
    }
}
