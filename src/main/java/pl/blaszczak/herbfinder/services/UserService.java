package pl.blaszczak.herbfinder.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.blaszczak.herbfinder.domain.TypeUser;
import pl.blaszczak.herbfinder.domain.User;
import pl.blaszczak.herbfinder.repository.UserRepository;

import java.util.List;

@Service
//stereotyp który wskazuje, że ta klasa jest serwisem, tzn. oferuje pewną logikę biznesową którą będziemy wykorzystywać w innych miejscach np. kontrolerach; ogólnie w wyższych warstwach
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> getListAllUser() {
        return userRepository.findAll();
    }

    public void deleteUser(Integer id) {
        userRepository.delete(id);
    }

    public void createUser(User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        user.setTypeUser(TypeUser.USER);
        user.setIsActive(false);
        userRepository.save(user);
    }

    public User getUserById(Integer id) {
        return userRepository.findOne(id);
    }

    public void updateUser(User user) {
        userRepository.saveAndFlush(user);
    }

}
