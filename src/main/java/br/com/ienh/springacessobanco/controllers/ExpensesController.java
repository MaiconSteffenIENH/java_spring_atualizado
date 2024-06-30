package br.com.ienh.springacessobanco.controllers;

import br.com.ienh.springacessobanco.dto.ExpenseDTO;
import br.com.ienh.springacessobanco.services.ExpenseCategoryService;
import br.com.ienh.springacessobanco.services.ExpenseService;
import br.com.ienh.springacessobanco.services.UsersService;
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
    @Autowired
    UsersService usersService;
    @Autowired
    ExpenseCategoryService expenseCategoryService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("expenses", expenseService.obterTodos());
        return "/expenses/listar";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("expense", new ExpenseDTO());
        model.addAttribute("users", usersService.obterTodos());
        model.addAttribute("categories", expenseCategoryService.obterTodos());
        return "/expenses/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("expense") ExpenseDTO expense, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/expenses/novoForm";
        }
        expenseService.salvarExpense(expense);
        return "redirect:/expenses/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model) {
        ExpenseDTO expense = expenseService.obterExpensePorId(id);
        model.addAttribute("expense", expense);
        model.addAttribute("users", usersService.obterTodos());
        model.addAttribute("categories", expenseCategoryService.obterTodos());
        return "/expenses/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("expense") ExpenseDTO expenseDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("users", usersService.obterTodos());
            model.addAttribute("categories", expenseCategoryService.obterTodos());
            return "/expenses/editarForm";
        }
        expenseService.atualizarExpense(expenseDTO);
        return "redirect:/expenses/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        expenseService.excluirExpense(id);
        return "redirect:/expenses/listar";
    }
}
