package br.com.ienh.springacessobanco.services;

import br.com.ienh.springacessobanco.dto.IncomeDTO;
import br.com.ienh.springacessobanco.entities.Income;
import br.com.ienh.springacessobanco.repositories.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeService {

    @Autowired
    IncomeRepository incomeRepository;

    public void salvarIncome(IncomeDTO incomeDTO) {
        Income income = new Income();
        income.setValue(incomeDTO.getValue());
        income.setDescription(incomeDTO.getDescription());
        income.setDate(incomeDTO.getDate());
        income.setCategory(incomeDTO.getCategory());
        income.setUser(incomeDTO.getUser());
        incomeRepository.save(income);
    }

    public void atualizarIncome(IncomeDTO incomeDTO) {
        Income income = new Income();
        income.setId(incomeDTO.getId());
        income.setValue(incomeDTO.getValue());
        income.setDescription(incomeDTO.getDescription());
        income.setDate(incomeDTO.getDate());
        income.setCategory(incomeDTO.getCategory());
        income.setUser(incomeDTO.getUser());
        incomeRepository.save(income);
    }

    public IncomeDTO obterIncomePorId(int id) {
        IncomeDTO incomeDTO = null;
        Income income = incomeRepository.findById(id).orElse(null);
        if (income != null) {
            incomeDTO = new IncomeDTO(income.getId(), income.getValue(), income.getDescription(), income.getDate(), income.getCategory(), income.getUser());
        }
        return incomeDTO;
    }

    public void excluirIncome(int id) {
        incomeRepository.deleteById(id);
    }

    public List<IncomeDTO> obterTodos() {
        List<IncomeDTO> incomesDTO = new ArrayList<>();
        incomeRepository.findAll().forEach(income -> {
            IncomeDTO incomeDTO = new IncomeDTO(income.getId(), income.getValue(), income.getDescription(), income.getDate(), income.getCategory(), income.getUser());
            incomesDTO.add(incomeDTO);
        });
        return incomesDTO;
    }
}
