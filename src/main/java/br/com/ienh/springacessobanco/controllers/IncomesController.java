package br.com.ienh.springacessobanco.controllers;

import br.com.ienh.springacessobanco.dto.IncomeDTO;
import br.com.ienh.springacessobanco.services.IncomeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/incomes")
public class IncomesController {

    @Autowired
    IncomeService incomeService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("incomes", incomeService.obterTodos());
        return "/incomes/listar";
    }

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("income") IncomeDTO income){
        return "/incomes/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("income") IncomeDTO income, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/incomes/novoForm";
        incomeService.salvarIncome(income);
        return "redirect:/incomes/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model){
        model.addAttribute("income", incomeService.obterIncomePorId(id));
        return "/incomes/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("income") IncomeDTO income, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/incomes/editarForm";
        incomeService.atualizarIncome(income);
        return "redirect:/incomes/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        incomeService.excluirIncome(id);
        return "redirect:/incomes/listar";
    }
}
