package br.com.ienh.springacessobanco.controllers;

import br.com.ienh.springacessobanco.dto.ProfessorDTO;
import br.com.ienh.springacessobanco.services.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("professores", professorService.obterTodos());
        return "/professor/listar";
    }

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("professor") ProfessorDTO professor){
        return "/professor/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("professor") ProfessorDTO professor, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/professor/novoForm";
        professorService.salvarProfessor(professor);
        return "redirect:/professor/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model){
        model.addAttribute("professor", professorService.obterProfessorPorId(id));
        return "/professor/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("professor") ProfessorDTO professor, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/professor/editarForm";
        professorService.atualizarProfessor(professor);
        return "redirect:/aluno/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        professorService.excluirProfessor(id);
        return "redirect:/professor/listar";
    }
//
}
