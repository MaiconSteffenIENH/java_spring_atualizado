package br.com.ienh.springacessobanco.services;

import br.com.ienh.springacessobanco.dto.ExpenseCategoryDTO;
import br.com.ienh.springacessobanco.entities.ExpenseCategory;
import br.com.ienh.springacessobanco.repositories.ExpenseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseCategoryService {

    @Autowired
    ExpenseCategoryRepository expenseCategoryRepository;

    public void salvarExpenseCategory(ExpenseCategoryDTO expenseCategoryDTO) {
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setName(expenseCategoryDTO.getName());
        expenseCategory.setDescription(expenseCategoryDTO.getDescription());
        expenseCategoryRepository.save(expenseCategory);
    }

    public void atualizarExpenseCategory(ExpenseCategoryDTO expenseCategoryDTO) {
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setId(expenseCategoryDTO.getId());
        expenseCategory.setName(expenseCategoryDTO.getName());
        expenseCategory.setDescription(expenseCategoryDTO.getDescription());
        expenseCategoryRepository.save(expenseCategory);
    }

    public ExpenseCategoryDTO obterExpenseCategoryPorId(int id) {
        ExpenseCategoryDTO expenseCategoryDTO = null;
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(id).orElse(null);
        if (expenseCategory != null) {
            expenseCategoryDTO = new ExpenseCategoryDTO(expenseCategory.getId(), expenseCategory.getName(), expenseCategory.getDescription());
        }
        return expenseCategoryDTO;
    }

    public void excluirExpenseCategory(int id) {
        expenseCategoryRepository.deleteById(id);
    }

    public List<ExpenseCategoryDTO> obterTodos() {
        List<ExpenseCategoryDTO> expenseCategoriesDTO = new ArrayList<>();
        expenseCategoryRepository.findAll().forEach(expenseCategory -> {
            ExpenseCategoryDTO expenseCategoryDTO = new ExpenseCategoryDTO(expenseCategory.getId(), expenseCategory.getName(), expenseCategory.getDescription());
            expenseCategoriesDTO.add(expenseCategoryDTO);
        });
        return expenseCategoriesDTO;
    }
}
