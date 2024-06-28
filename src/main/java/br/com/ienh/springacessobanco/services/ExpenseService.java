package br.com.ienh.springacessobanco.services;

import br.com.ienh.springacessobanco.dto.ExpenseDTO;
import br.com.ienh.springacessobanco.entities.Expense;
import br.com.ienh.springacessobanco.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    public void salvarExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense();
        expense.setValue(expenseDTO.getValue());
        expense.setDescription(expenseDTO.getDescription());
        expense.setDate(expenseDTO.getDate());
        expense.setCategory(expenseDTO.getCategory());
        expense.setUser(expenseDTO.getUser());
        expenseRepository.save(expense);
    }

    public void atualizarExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense();
        expense.setId(expenseDTO.getId());
        expense.setValue(expenseDTO.getValue());
        expense.setDescription(expenseDTO.getDescription());
        expense.setDate(expenseDTO.getDate());
        expense.setCategory(expenseDTO.getCategory());
        expense.setUser(expenseDTO.getUser());
        expenseRepository.save(expense);
    }

    public ExpenseDTO obterExpensePorId(int id) {
        ExpenseDTO expenseDTO = null;
        Expense expense = expenseRepository.findById(id).orElse(null);
        if (expense != null) {
            expenseDTO = new ExpenseDTO(expense.getId(), expense.getValue(), expense.getDescription(), expense.getDate(), expense.getCategory(), expense.getUser());
        }
        return expenseDTO;
    }

    public void excluirExpense(int id) {
        expenseRepository.deleteById(id);
    }

    public List<ExpenseDTO> obterTodos() {
        List<ExpenseDTO> expensesDTO = new ArrayList<>();
        expenseRepository.findAll().forEach(expense -> {
            ExpenseDTO expenseDTO = new ExpenseDTO(expense.getId(), expense.getValue(), expense.getDescription(), expense.getDate(), expense.getCategory(), expense.getUser());
            expensesDTO.add(expenseDTO);
        });
        return expensesDTO;
    }
}
