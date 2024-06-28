package br.com.ienh.springacessobanco.controllers;

import br.com.ienh.springacessobanco.dto.IncomeCategoryDTO;
import br.com.ienh.springacessobanco.dto.UserDTO;
import br.com.ienh.springacessobanco.services.IncomeCategoryService;
import br.com.ienh.springacessobanco.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/income-categories")
public class IncomeCategoriesController {

    @Autowired
    IncomeCategoryService incomeCategoryService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("incomeCategories", incomeCategoryService.obterTodos());
        return "/income-categories/listar";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("incomeCategory", new IncomeCategoryDTO());
        model.addAttribute("users", usersService.obterTodos());
        return "/income-categories/novoForm";
    }

    @PostMapping("/novo")
    public String novoSalvar(@Valid @ModelAttribute("incomeCategory") IncomeCategoryDTO incomeCategory,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("users", usersService.obterTodos());
            return "/income-categories/novoForm";
        }

        try {
            UserDTO user = usersService.obterUserPorId(incomeCategory.getUserId());
            if (user == null) {
                bindingResult.rejectValue("userId", "error.incomeCategory", "Usuário não encontrado.");
                model.addAttribute("users", usersService.obterTodos());
                return "/income-categories/novoForm";
            }
            incomeCategory.setUser(user);

            incomeCategoryService.salvarIncomeCategory(incomeCategory);
            return "redirect:/income-categories/listar";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Erro ao salvar categoria de receita: " + e.getMessage());
            model.addAttribute("users", usersService.obterTodos());
            return "/income-categories/novoForm";
        }
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable int id, Model model){
        model.addAttribute("incomeCategory", incomeCategoryService.obterIncomeCategoryPorId(id));
        return "/income-categories/editarForm";
    }

    @PostMapping("/editar")
    public String editarSalvar(@Valid @ModelAttribute("incomeCategory") IncomeCategoryDTO incomeCategory, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "/income-categories/editarForm";
        }
        IncomeCategoryDTO incomeCategoryAtual = incomeCategoryService.obterIncomeCategoryPorId(incomeCategory.getId());
        if(incomeCategory.getName() != null && !incomeCategory.getName().isEmpty()) {
            incomeCategoryAtual.setName(incomeCategory.getName());
        }
        if(incomeCategory.getDescription() != null && !incomeCategory.getDescription().isEmpty()) {
            incomeCategoryAtual.setDescription(incomeCategory.getDescription());
        }
        incomeCategoryService.atualizarIncomeCategory(incomeCategoryAtual);
        return "redirect:/income-categories/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        incomeCategoryService.excluirIncomeCategory(id);
        return "redirect:/income-categories/listar";
    }
}