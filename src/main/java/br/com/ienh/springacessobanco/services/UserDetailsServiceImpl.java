package br.com.ienh.springacessobanco.services;

import br.com.ienh.springacessobanco.entities.Users;
import br.com.ienh.springacessobanco.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        final Users users = usersRepository.findByName(name);
        if(users == null) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + name);
        }
        return User.withUsername(users.getName())
                .password(users.getPassword())
                .roles(users.getRole())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();

    }
}