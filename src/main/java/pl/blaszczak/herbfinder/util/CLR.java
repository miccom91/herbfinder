package pl.blaszczak.herbfinder.util;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.blaszczak.herbfinder.domain.Herb;
import pl.blaszczak.herbfinder.domain.Localization;
import pl.blaszczak.herbfinder.domain.User;
import pl.blaszczak.herbfinder.repository.HerbRepository;
import pl.blaszczak.herbfinder.repository.LocalizationRepository;
import pl.blaszczak.herbfinder.repository.UserRepository;

@Component
@AllArgsConstructor
public class CLR implements CommandLineRunner {

    private final UserRepository userRepository;
    private final LocalizationRepository localizationRepository;
    private final HerbRepository herbRepository;

    @Override
    public void run(String... strings) throws Exception {
        userRepository.save(User.builder().name("znenek").lastname("Martyiuk").build());
        userRepository.save(User.builder().name("znenek").lastname("Martyiuk").build());
        userRepository.save(User.builder().name("znenek").lastname("Martyiuk").build());
        userRepository.save(User.builder().name("znenek").lastname("Martyiuk").build());
        localizationRepository.save(Localization.builder().localizationE(59.1231).localizationN(59.1231).isPrivate(true).build());
        herbRepository.save(Herb.builder().name("Pokrzywa").discription("Zioło na oczyszczenie").build());
    }
}
