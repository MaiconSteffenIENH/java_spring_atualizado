package br.com.ienh.springacessobanco.repositories;

import br.com.ienh.springacessobanco.entities.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{

    Optional<Object> findById(Long aLong);
}
