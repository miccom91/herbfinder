package pl.blaszczak.herbfinder.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.blaszczak.herbfinder.domain.Ecology;
import pl.blaszczak.herbfinder.domain.Localization;
import pl.blaszczak.herbfinder.repository.LocalizationRepository;
import pl.blaszczak.herbfinder.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LocalizationService {

    private final LocalizationRepository localizationRepository;

    private final UserRepository userRepository;

    public void createLocalization(Localization localization,String name) {
        localization.setIsPrivate(false);
        localization.setAdminMark(0);
        localization.setEcology(Ecology.GOOD);
        localization.setUser(userRepository.findByEmail(name));
        localizationRepository.save(localization);
    }

    public List<Localization> getListAllLocalization() {
        return localizationRepository.findAll();
    }

    public void updateLocalization(Localization localization) {
        localizationRepository.saveAndFlush(localization);
    }

    public Localization getLocalizationById(Integer id) {
        return localizationRepository.findOne(id);
    }

    public void deleteLocalization(Integer id) {
        localizationRepository.delete(id);
    }


}
