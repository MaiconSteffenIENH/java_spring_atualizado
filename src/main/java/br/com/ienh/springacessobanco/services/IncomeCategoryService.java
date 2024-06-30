package br.com.ienh.springacessobanco.services;

import br.com.ienh.springacessobanco.dto.IncomeCategoryDTO;
import br.com.ienh.springacessobanco.entities.IncomeCategory;
import br.com.ienh.springacessobanco.repositories.IncomeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeCategoryService {

    @Autowired
    IncomeCategoryRepository incomeCategoryRepository;

    public void salvarIncomeCategory(IncomeCategoryDTO incomeCategoryDTO) {
        if (incomeCategoryDTO.getUserId() == 0) {
            IncomeCategory incomeCategory = new IncomeCategory();
            incomeCategory.setName(incomeCategoryDTO.getName());
            incomeCategory.setDescription(incomeCategoryDTO.getDescription());
            incomeCategoryRepository.save(incomeCategory);
        }
    }

    public void atualizarIncomeCategory(IncomeCategoryDTO incomeCategoryDTO) {
        IncomeCategory incomeCategory = incomeCategoryRepository.findById(incomeCategoryDTO.getId()).orElse(null);
        if (incomeCategory != null) {
            incomeCategory.setName(incomeCategoryDTO.getName() != null ? incomeCategoryDTO.getName() : incomeCategory.getName());
            incomeCategory.setDescription(incomeCategoryDTO.getDescription() != null ? incomeCategoryDTO.getDescription() : incomeCategory.getDescription());
            incomeCategoryRepository.save(incomeCategory);
        }
    }

    public IncomeCategoryDTO obterIncomeCategoryPorId(int id) {
        Optional<IncomeCategory> incomeCategory = incomeCategoryRepository.findById(id);
        if(incomeCategory.isPresent()) {
            IncomeCategory existingIncomeCategory = incomeCategory.get();
            IncomeCategoryDTO incomeCategoryDTO = new IncomeCategoryDTO();
            incomeCategoryDTO.setId(existingIncomeCategory.getId());
            incomeCategoryDTO.setName(existingIncomeCategory.getName());
            incomeCategoryDTO.setDescription(existingIncomeCategory.getDescription());
            return incomeCategoryDTO;
        }
        return null;
    }

    public void excluirIncomeCategory(int id) {
        incomeCategoryRepository.deleteById(id);
    }

    public List<IncomeCategoryDTO> obterTodos() {
        List<IncomeCategoryDTO> incomeCategoriesDTO = new ArrayList<>();
        incomeCategoryRepository.findAll().forEach(incomeCategory -> {
            IncomeCategoryDTO incomeCategoryDTO = new IncomeCategoryDTO();
            incomeCategoryDTO.setId(incomeCategory.getId());
            incomeCategoryDTO.setName(incomeCategory.getName());
            incomeCategoryDTO.setDescription(incomeCategory.getDescription());
            incomeCategoriesDTO.add(incomeCategoryDTO);
        });
        return incomeCategoriesDTO;
    }
}
