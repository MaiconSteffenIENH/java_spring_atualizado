package br.com.ienh.springacessobanco.services;

import br.com.ienh.springacessobanco.dto.IncomeCategoryDTO;
import br.com.ienh.springacessobanco.entities.IncomeCategory;
import br.com.ienh.springacessobanco.repositories.IncomeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeCategoryService {

    @Autowired
    IncomeCategoryRepository incomeCategoryRepository;

    public void salvarIncomeCategory(IncomeCategoryDTO incomeCategoryDTO) {
        IncomeCategory incomeCategory = new IncomeCategory();
        incomeCategory.setName(incomeCategoryDTO.getName());
        incomeCategory.setDescription(incomeCategoryDTO.getDescription());
        incomeCategoryRepository.save(incomeCategory);
    }

    public void atualizarIncomeCategory(IncomeCategoryDTO incomeCategoryDTO) {
        IncomeCategory incomeCategory = new IncomeCategory();
        incomeCategory.setId(incomeCategoryDTO.getId());
        incomeCategory.setName(incomeCategoryDTO.getName());
        incomeCategory.setDescription(incomeCategoryDTO.getDescription());
        incomeCategoryRepository.save(incomeCategory);
    }

    public IncomeCategoryDTO obterIncomeCategoryPorId(int id) {
        IncomeCategoryDTO incomeCategoryDTO = null;
        IncomeCategory incomeCategory = incomeCategoryRepository.findById(id).orElse(null);
        if (incomeCategory != null) {
            incomeCategoryDTO = new IncomeCategoryDTO(incomeCategory.getId(), incomeCategory.getName(), incomeCategory.getDescription());
        }
        return incomeCategoryDTO;
    }

    public void excluirIncomeCategory(int id) {
        incomeCategoryRepository.deleteById(id);
    }

    public List<IncomeCategoryDTO> obterTodos() {
        List<IncomeCategoryDTO> incomeCategoriesDTO = new ArrayList<>();
        incomeCategoryRepository.findAll().forEach(incomeCategory -> {
            IncomeCategoryDTO incomeCategoryDTO = new IncomeCategoryDTO(incomeCategory.getId(), incomeCategory.getName(), incomeCategory.getDescription());
            incomeCategoriesDTO.add(incomeCategoryDTO);
        });
        return incomeCategoriesDTO;
    }
}
