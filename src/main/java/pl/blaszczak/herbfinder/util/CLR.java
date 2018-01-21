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
        userRepository.save(User.builder().email("admin").name("admin").password("$2a$12$gEuJFWGvvIQs5sGKd8WWyeoWXDPO.m39oaBzCO4XmlL0zzXSoNic2").isActive(true).typeUser(TypeUser.ADMIN).build());
        User user = User.builder().email("user").name("user").password("$2a$12$mbugI6pcCLOYrvxDKdH26O0pWTocMPVHxNDLv4ChJzizoAJr8pP1S").isActive(true).typeUser(TypeUser.USER).build();
        userRepository.save(user);
        attributeRepository.save(Attribute.builder().description("Oczyszczająca").build());
        attributeRepository.save(Attribute.builder().description("TestTest").build());
        attributeRepository.save(Attribute.builder().description("Testttrt").build());
    }
}
