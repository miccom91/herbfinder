package pl.blaszczak.herbfinder.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.blaszczak.herbfinder.domain.User;
import pl.blaszczak.herbfinder.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getListAllUser(){
        return userRepository.findAll();
    }
}
