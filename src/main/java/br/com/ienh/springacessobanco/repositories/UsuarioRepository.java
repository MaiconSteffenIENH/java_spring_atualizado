package br.com.ienh.springacessobanco.repositories;

import br.com.ienh.springacessobanco.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

        public Usuario findByUsername(String username);

}
