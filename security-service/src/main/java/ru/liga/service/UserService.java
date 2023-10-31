package ru.liga.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.liga.entity.User;
import ru.liga.repositories.RoleRepository;
import ru.liga.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

   private final UserRepository userRepository;
   private final RoleRepository roleRepository;

   public Optional<User> findByUsername(String userName){
       return userRepository.findByUserName(userName); 
   }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       User user = findByUsername(username).orElseThrow(()-> new UsernameNotFoundException(String.format("Пользователь '%s' не найден ",username)));
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                user.getRoles().stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }

    public void createNewUser(User user){
       user.setRoles(List.of(roleRepository.findByName("ROLE_USER").get()));
       userRepository.save(user);
    }
}
