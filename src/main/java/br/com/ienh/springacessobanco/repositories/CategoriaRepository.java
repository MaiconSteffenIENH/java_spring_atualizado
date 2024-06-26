package br.com.ienh.springacessobanco.repositories;

import br.com.ienh.springacessobanco.entities.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{

}
