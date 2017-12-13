package pl.blaszczak.herbfinder.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.blaszczak.herbfinder.domain.Localization;
import pl.blaszczak.herbfinder.domain.User;
import pl.blaszczak.herbfinder.repository.LocalizationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LocalizationService {

    private final LocalizationRepository localizationRepository;
    public void createLocalization(Localization localization){
        localization.setIsPrivate(false);
        localizationRepository.save(localization);
    }

    public List<Localization> getListAllLocalization() {
        return localizationRepository.findAll();
    }

    public void updateLocalization(Localization localization){
        localizationRepository.saveAndFlush(localization);
    }

    public Localization getLocalizationById(Integer id){
        return localizationRepository.findOne(id);
    }

    public void deleteLocalization(Integer id){
        localizationRepository.delete(id);
    }




}