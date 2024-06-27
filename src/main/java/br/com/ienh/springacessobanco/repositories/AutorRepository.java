package br.com.ienh.springacessobanco.repositories;

import br.com.ienh.springacessobanco.entities.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Integer> {
}
