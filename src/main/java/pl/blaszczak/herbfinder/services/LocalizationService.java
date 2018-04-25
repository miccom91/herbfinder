package pl.blaszczak.herbfinder.services;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.blaszczak.herbfinder.domain.Ecology;
import pl.blaszczak.herbfinder.domain.Localization;
import pl.blaszczak.herbfinder.dto.LocalizationTO;
import pl.blaszczak.herbfinder.repository.LocalizationRepository;
import pl.blaszczak.herbfinder.repository.UserRepository;

import java.util.List;

@Service
public class LocalizationService {
    @Autowired
    private LocalizationRepository localizationRepository;
    @Autowired
    private UserRepository userRepository;

    public void createLocalization(LocalizationTO localizationTO,String name) {
        Localization localization = convertToLocalization(localizationTO);
        localization.setUser(userRepository.findByEmail(name));
        localization.setAdminMark(0);
        localization.setIsPrivate(false);
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

    private Localization convertToLocalization(LocalizationTO localizationTO){
        return Localization.builder().comment(localizationTO.getComment())
                .herb(localizationTO.getHerb()).adminMark(localizationTO.getAdminMark())
                .isPrivate(localizationTO.getIsPrivate())
                .localizationE(localizationTO.getLocalizationE())
                .localizationN(localizationTO.getLocalizationN())
                .ecology(localizationTO.getEcology())
                .build();
    }
}
