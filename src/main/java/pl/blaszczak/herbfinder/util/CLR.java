package pl.blaszczak.herbfinder.util;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.blaszczak.herbfinder.domain.*;
import pl.blaszczak.herbfinder.repository.AttributeRepository;
import pl.blaszczak.herbfinder.repository.HerbRepository;
import pl.blaszczak.herbfinder.repository.LocalizationRepository;
import pl.blaszczak.herbfinder.repository.UserRepository;

@Component
@AllArgsConstructor
public class CLR implements CommandLineRunner {

    private final UserRepository userRepository;
    private final LocalizationRepository localizationRepository;
    private final HerbRepository herbRepository;
    private final AttributeRepository attributeRepository;

    @Override
    public void run(String... strings) throws Exception {
        userRepository.save(User.builder().email("admin").name("admin").password("admin").typeUser(TypeUser.ADMIN).build());
        User user = User.builder().email("user").name("user").password("user").typeUser(TypeUser.USER).build();
        userRepository.save(user);
        Localization localization = Localization.builder().localizationE(59.1231).localizationN(29.1231).isPrivate(true).ecology(Ecology.GOOD).build();
        localization.setUser(user);
        localizationRepository.save(localization);
        herbRepository.save(Herb.builder().name("Pokrzywa").build());
        attributeRepository.save(Attribute.builder().description("Oczyszczająca").build());
    }
}
