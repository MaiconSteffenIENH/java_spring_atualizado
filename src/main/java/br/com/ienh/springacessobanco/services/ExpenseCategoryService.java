package br.com.ienh.springacessobanco.services;

import br.com.ienh.springacessobanco.dto.ExpenseCategoryDTO;
import br.com.ienh.springacessobanco.entities.ExpenseCategory;
import br.com.ienh.springacessobanco.repositories.ExpenseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseCategoryService {

    @Autowired
    ExpenseCategoryRepository expenseCategoryRepository;

    public void salvarExpenseCategory(ExpenseCategoryDTO expenseCategoryDTO) {
        if(expenseCategoryDTO.getUserId() == 0) {
            ExpenseCategory expenseCategory = new ExpenseCategory();
            expenseCategory.setName(expenseCategoryDTO.getName());
            expenseCategory.setDescription(expenseCategoryDTO.getDescription());
            expenseCategoryRepository.save(expenseCategory);
        }
    }

    public void atualizarExpenseCategory(ExpenseCategoryDTO expenseCategoryDTO) {
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(expenseCategoryDTO.getId()).orElse(null);
        if (expenseCategory != null) {
            expenseCategory.setName(expenseCategoryDTO.getName() != null ? expenseCategoryDTO.getName() : expenseCategory.getName());
            expenseCategory.setDescription(expenseCategoryDTO.getDescription() != null ? expenseCategoryDTO.getDescription() : expenseCategory.getDescription());
            expenseCategoryRepository.save(expenseCategory);
        }
    }

    public ExpenseCategoryDTO obterExpenseCategoryPorId(int id) {
        Optional<ExpenseCategory> expenseCategory = expenseCategoryRepository.findById(id);
        if(expenseCategory.isPresent()) {
            ExpenseCategory existingExpenseCategory = expenseCategory.get();
            return new ExpenseCategoryDTO(
                    existingExpenseCategory.getId(),
                    existingExpenseCategory.getName(),
                    existingExpenseCategory.getDescription());
        }
        return null;
    }

    public void excluirExpenseCategory(int id) {
        expenseCategoryRepository.deleteById(id);
    }

    public List<ExpenseCategoryDTO> obterTodos() {
        List <ExpenseCategoryDTO> expenseCategoriesDTO = new ArrayList<>();
        expenseCategoryRepository.findAll().forEach(expenseCategory -> {
            expenseCategoriesDTO.add(new ExpenseCategoryDTO(
                    expenseCategory.getId(),
                    expenseCategory.getName(),
                    expenseCategory.getDescription()));
        });
        return expenseCategoriesDTO;
    }
}
