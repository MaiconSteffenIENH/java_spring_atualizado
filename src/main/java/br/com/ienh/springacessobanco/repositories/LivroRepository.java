package br.com.ienh.springacessobanco.repositories;

import br.com.ienh.springacessobanco.entities.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, Integer> {
}
