package br.com.ienh.springacessobanco.controllers;

import br.com.ienh.springacessobanco.dto.ExpenseCategoryDTO;
import br.com.ienh.springacessobanco.services.ExpenseCategoryService;
import br.com.ienh.springacessobanco.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/expense-categories")
public class ExpenseCategoriesController {

    @Autowired
    ExpenseCategoryService expenseCategoryService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("expenseCategories", expenseCategoryService.obterTodos());
        return "/expense-categories/listar";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("expenseCategory", new ExpenseCategoryDTO());
        return "/expense-categories/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("expenseCategory") ExpenseCategoryDTO expenseCategory, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("users", usersService.obterTodos());
            return "/expense-categories/novoForm";
        }
        expenseCategoryService.salvarExpenseCategory(expenseCategory);
        return "redirect:/expense-categories/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model) {
        model.addAttribute("expenseCategory",
                expenseCategoryService.obterExpenseCategoryPorId(id));
        return "/expense-categories/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("expenseCategory") ExpenseCategoryDTO expenseCategory, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/expense-categories/editarForm";
        }

        expenseCategoryService.atualizarExpenseCategory(expenseCategory);
        return "redirect:/expense-categories/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        expenseCategoryService.excluirExpenseCategory(id);
        return "redirect:/expense-categories/listar";
    }
}
