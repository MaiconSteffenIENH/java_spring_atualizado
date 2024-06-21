package br.com.ienh.springacessobanco.controllers;

import br.com.ienh.springacessobanco.dto.AlunoDTO;
import br.com.ienh.springacessobanco.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("alunos", alunoService.obterTodos());
        return "/aluno/listar";
    }

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("aluno") AlunoDTO aluno){
        return "/aluno/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("aluno") AlunoDTO aluno, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/aluno/novoForm";
        alunoService.salvarAluno(aluno);
        return "redirect:/aluno/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model){
        model.addAttribute("aluno", alunoService.obterAlunoPorId(id));
        return "/aluno/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("aluno") AlunoDTO aluno, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/aluno/editarForm";
        alunoService.atualizarAluno(aluno);
        return "redirect:/aluno/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        alunoService.excluirAluno(id);
        return "redirect:/aluno/listar";
    }

}
