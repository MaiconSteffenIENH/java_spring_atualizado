package br.com.ienh.springacessobanco.services;

import br.com.ienh.springacessobanco.dto.UserDTO;
import br.com.ienh.springacessobanco.entities.Users;
import br.com.ienh.springacessobanco.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Users> obterTodos() {
        return usersRepository.findAll();
    }

    public UserDTO obterUserPorId(int id) {
        Optional<Users> user = usersRepository.findById(id);
        if (user.isPresent()) {
            Users existingUser = user.get();
            UserDTO userDTO = new UserDTO();
            userDTO.setId(existingUser.getId());
            userDTO.setName(existingUser.getName());
            userDTO.setEmail(existingUser.getEmail());
            userDTO.setPassword(existingUser.getPassword());
            return userDTO;
        }
        return null;
    }

    public void salvarUser(UserDTO userDTO) {
        Users user = new Users();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // Encode password
        user.setRole(userDTO.getRole() != null && !userDTO.getRole().isEmpty() ? userDTO.getRole() : "USER");
        usersRepository.save(user);
    }

    public void atualizarUser(UserDTO userDTO) {
        Users user = usersRepository.findById(userDTO.getId()).orElse(null);
        if (user != null) {
            user.setName(userDTO.getName() != null ? userDTO.getName() : user.getName());
            user.setEmail(userDTO.getEmail() != null ? userDTO.getEmail() : user.getEmail());
            if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
                user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            }
            user.setRole(userDTO.getRole() != null ? userDTO.getRole() : user.getRole());
            usersRepository.save(user);
        }
    }

    public void excluirUser(int id) {
        usersRepository.deleteById(id);
    }
}
