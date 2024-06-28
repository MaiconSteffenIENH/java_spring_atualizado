package br.com.ienh.springacessobanco.repositories;

import br.com.ienh.springacessobanco.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer> {
}
