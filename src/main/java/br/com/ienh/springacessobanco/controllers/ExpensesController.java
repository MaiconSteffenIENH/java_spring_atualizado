package br.com.ienh.springacessobanco.controllers;

import br.com.ienh.springacessobanco.dto.ExpenseDTO;
import br.com.ienh.springacessobanco.services.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/expenses")
public class ExpensesController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("expenses", expenseService.obterTodos());
        return "/expenses/listar";
    }

    @GetMapping("/novo")
    public String novoForm(@ModelAttribute("expense") ExpenseDTO expense){
        return "/expenses/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("expense") ExpenseDTO expense, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/expenses/novoForm";
        expenseService.salvarExpense(expense);
        return "redirect:/expenses/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model){
        model.addAttribute("expense", expenseService.obterExpensePorId(id));
        return "/expenses/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("expense") ExpenseDTO expense, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "/expenses/editarForm";
        expenseService.atualizarExpense(expense);
        return "redirect:/expenses/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        expenseService.excluirExpense(id);
        return "redirect:/expenses/listar";
    }
}
