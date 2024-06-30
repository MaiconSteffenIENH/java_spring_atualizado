package br.com.ienh.springacessobanco.services;

import br.com.ienh.springacessobanco.dto.ExpenseDTO;
import br.com.ienh.springacessobanco.entities.Expense;
import br.com.ienh.springacessobanco.repositories.ExpenseCategoryRepository;
import br.com.ienh.springacessobanco.repositories.ExpenseRepository;
import br.com.ienh.springacessobanco.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    ExpenseCategoryRepository expenseCategoryRepository;
    @Autowired
    UsersRepository usersRepository;

    public void salvarExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense();
        expense.setValue(expenseDTO.getValue());
        expense.setDescription(expenseDTO.getDescription());
        expense.setDate(expenseDTO.getDate());
        expense.setCategory(expenseCategoryRepository.findById(expenseDTO.getCategoryId()).get());
        expense.setUser(usersRepository.findById(expenseDTO.getUserId()).get());
        expenseRepository.save(expense);
    }

    public void atualizarExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense();
        expense.setId(expenseDTO.getId());
        expense.setValue(expenseDTO.getValue());
        expense.setDescription(expenseDTO.getDescription());
        expense.setDate(expenseDTO.getDate());
        expense.setCategory(expenseCategoryRepository.findById(expenseDTO.getCategoryId()).get());
        expense.setUser(usersRepository.findById(expenseDTO.getUserId()).get());
        expenseRepository.save(expense);
    }

    public ExpenseDTO obterExpensePorId(int id) {
        ExpenseDTO expenseDTO = null;
        Expense expense = expenseRepository.findById(id).orElse(null);
        if (expense != null) {
            expenseDTO = new ExpenseDTO(expense.getId(), expense.getValue(), expense.getDescription(), expense.getDate(), expense.getCategory().getId(), expense.getUser().getId());
        }
        return expenseDTO;
    }

    public void excluirExpense(int id) {
        expenseRepository.deleteById(id);
    }

    public List<Expense> obterTodos() {
        return expenseRepository.findAll();
    }
}
