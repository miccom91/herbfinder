package pl.blaszczak.herbfinder.util;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.blaszczak.herbfinder.domain.User;
import pl.blaszczak.herbfinder.repository.UserRepository;

@Component
@AllArgsConstructor
public class CLR implements CommandLineRunner{

    private final UserRepository userRepository;
    @Override
    public void run(String... strings) throws Exception {
        userRepository.save(User.builder().name("znenek").lastname("Martyiuk").build());
        userRepository.save(User.builder().name("znenek").lastname("Martyiuk").build());
        userRepository.save(User.builder().name("znenek").lastname("Martyiuk").build());
        userRepository.save(User.builder().name("znenek").lastname("Martyiuk").build());

    }
}
