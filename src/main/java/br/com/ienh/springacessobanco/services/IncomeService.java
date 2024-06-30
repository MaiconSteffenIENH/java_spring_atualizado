package br.com.ienh.springacessobanco.services;

import br.com.ienh.springacessobanco.dto.IncomeDTO;
import br.com.ienh.springacessobanco.entities.Income;
import br.com.ienh.springacessobanco.entities.Users;
import br.com.ienh.springacessobanco.repositories.IncomeCategoryRepository;
import br.com.ienh.springacessobanco.repositories.IncomeRepository;
import br.com.ienh.springacessobanco.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeService {

    @Autowired
    IncomeRepository incomeRepository;
    @Autowired
    IncomeCategoryRepository incomeCategoryRepository;
    @Autowired
    UsersRepository usersRepository;

    public void salvarIncome(IncomeDTO incomeDTO) {
        Income income = new Income();
        income.setValue(incomeDTO.getValue());
        income.setDescription(incomeDTO.getDescription());
        income.setDate(incomeDTO.getDate());
        income.setCategory(incomeCategoryRepository.findById(incomeDTO.getCategoryId()).get());
        income.setUser(usersRepository.findById(incomeDTO.getUserId()).get());
        incomeRepository.save(income);
    }

    public void atualizarIncome(IncomeDTO incomeDTO) {
        Income income = new Income();
        income.setId(incomeDTO.getId());
        income.setValue(incomeDTO.getValue());
        income.setDescription(incomeDTO.getDescription());
        income.setDate(incomeDTO.getDate());
        income.setCategory(incomeCategoryRepository.findById(incomeDTO.getCategoryId()).get());
        income.setUser(usersRepository.findById(incomeDTO.getUserId()).get());
        incomeRepository.save(income);
    }

    public IncomeDTO obterIncomePorId(int id) {
        IncomeDTO incomeDTO = null;
        Income income = incomeRepository.findById(id).orElse(null);
        if (income != null) {
            incomeDTO = new IncomeDTO(income.getId(), income.getValue(), income.getDescription(), income.getDate(), income.getCategory().getId(), income.getUser().getId());
        }
        return incomeDTO;
    }

    public void excluirIncome(int id) {
        incomeRepository.deleteById(id);
    }

    public List<Income> obterTodos() {
        return incomeRepository.findAll();
    }
}
