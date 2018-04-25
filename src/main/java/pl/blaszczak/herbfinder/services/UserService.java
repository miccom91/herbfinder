package pl.blaszczak.herbfinder.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.blaszczak.herbfinder.domain.TypeUser;
import pl.blaszczak.herbfinder.domain.User;
import pl.blaszczak.herbfinder.dto.UserTO;
import pl.blaszczak.herbfinder.repository.UserRepository;

import java.util.List;

import static pl.blaszczak.herbfinder.services.HerbService.convertByteToString;
import static pl.blaszczak.herbfinder.services.HerbService.convertFileToByte;

@Service
//stereotyp który wskazuje, że ta klasa jest serwisem, tzn. oferuje pewną logikę biznesową którą będziemy wykorzystywać w innych miejscach np. kontrolerach; ogólnie w wyższych warstwach
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getListAllUser() {
        return userRepository.findAll();
    }

    public void deleteUser(Integer id) {
        userRepository.delete(id);
    }

    public void createUser(UserTO userTO) {
        User user = conwertToUser(userTO);
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        user.setTypeUser(TypeUser.USER);
        user.setIsActive(false);
        userRepository.save(user);
    }

    public UserTO getUserById(Integer id) {
        User user = userRepository.findOne(id);
        return new UserTO(user, convertByteToString(user.getImage()));
    }

    public UserTO getUserByName(String name){
        User user = userRepository.findByName(name);
        return new UserTO(user, convertByteToString(user.getImage()));
    }

    public void updateUser(User user) {
        userRepository.saveAndFlush(user);
    }
    private User conwertToUser(UserTO userTO){
        return User.builder().id(userTO.getId())
                .image(convertFileToByte(userTO.getMultipartFile()))
                .adress(userTO.getAdress())
                .lastname(userTO.getLastname())
                .name(userTO.getName())
                .phone(userTO.getPhone())
                .postnumber(userTO.getPostnumber())
                .password(userTO.getPassword())
                .build();
    }
    public void activeUser(String name){
        User temp = userRepository.findByName(name);
        temp.setIsActive(true);
        userRepository.saveAndFlush(temp);
    }
}
