// UsersRepository.java (Repositório)
package br.com.ienh.springacessobanco.repositories;

import br.com.ienh.springacessobanco.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByName(String name);
    Users findByEmail(String email);
}
