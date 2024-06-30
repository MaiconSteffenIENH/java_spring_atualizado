package br.com.ienh.springacessobanco.controllers;

import br.com.ienh.springacessobanco.dto.IncomeCategoryDTO;
import br.com.ienh.springacessobanco.dto.IncomeDTO;
import br.com.ienh.springacessobanco.dto.UserDTO;
import br.com.ienh.springacessobanco.services.IncomeCategoryService;
import br.com.ienh.springacessobanco.services.IncomeService;
import br.com.ienh.springacessobanco.services.UsersService;
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
    private IncomeService incomeService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private IncomeCategoryService incomeCategoryService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("incomes", incomeService.obterTodos());
        return "/incomes/listar";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("income", new IncomeDTO());
        model.addAttribute("users", usersService.obterTodos());
        model.addAttribute("categories", incomeCategoryService.obterTodos());
        return "/incomes/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("income") IncomeDTO income, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/incomes/novoForm";
        }
        incomeService.salvarIncome(income);
        return "redirect:/incomes/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model) {
        IncomeDTO income = incomeService.obterIncomePorId(id);
        model.addAttribute("income", income);
        model.addAttribute("users", usersService.obterTodos());
        model.addAttribute("categories", incomeCategoryService.obterTodos());
        return "/incomes/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("income") IncomeDTO incomeDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("users", usersService.obterTodos());
            model.addAttribute("categories", incomeCategoryService.obterTodos());
            return "/incomes/editarForm";
        }
        incomeService.atualizarIncome(incomeDTO);
        return "redirect:/incomes/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        incomeService.excluirIncome(id);
        return "redirect:/incomes/listar";
    }
}
