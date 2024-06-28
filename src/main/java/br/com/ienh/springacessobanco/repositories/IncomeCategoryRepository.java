package br.com.ienh.springacessobanco.repositories;

import br.com.ienh.springacessobanco.entities.IncomeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeCategoryRepository extends JpaRepository<IncomeCategory, Integer> {
}
