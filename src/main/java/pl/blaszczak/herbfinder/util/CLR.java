package pl.blaszczak.herbfinder.util;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.blaszczak.herbfinder.domain.*;
import pl.blaszczak.herbfinder.repository.AttributeRepository;
import pl.blaszczak.herbfinder.repository.HerbRepository;
import pl.blaszczak.herbfinder.repository.LocalizationRepository;
import pl.blaszczak.herbfinder.repository.UserRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@AllArgsConstructor
public class CLR implements CommandLineRunner {

    private final UserRepository userRepository;
    private final LocalizationRepository localizationRepository;
    private final HerbRepository herbRepository;
    private final AttributeRepository attributeRepository;

    @Override
    public void run(String... strings) throws Exception {
        userRepository.save(User.builder().email("admin").name("admin").password("$2a$12$gEuJFWGvvIQs5sGKd8WWyeoWXDPO.m39oaBzCO4XmlL0zzXSoNic2").isActive(true).typeUser(TypeUser.ADMIN).image(readFile("./src/main/resources/static/photos/user-male-icon.png")).build());
        User user = User.builder().email("user").name("user").password("$2a$12$mbugI6pcCLOYrvxDKdH26O0pWTocMPVHxNDLv4ChJzizoAJr8pP1S").isActive(true).typeUser(TypeUser.USER).image(readFile("./src/main/resources/static/photos/user-male-icon.png")).build();
        userRepository.save(user);
        attributeRepository.save(Attribute.builder().description("Oczyszczająca").build());
        herbRepository.save(Herb.builder().description("rodzaj jednorocznych roślin zielnych lub bylin z rodziny pokrzywowatych (Urticaceae Juss.). Należy do niej co najmniej 50 gatunków rozproszonych na całej kuli ziemskiej. Rośliny niektórych gatunków dostarczają włókna i są jadalne").name("Pokrzywa").image(readFile("./src/main/resources/static/photos/pokrzywa.jpg")).attribute(attributeRepository.findOne(1)).build());
    }

    private  byte[] readFile(String s) {
        Path path = Paths.get(s);
        byte [] array = new byte[0];
        try {
            array = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }
}
