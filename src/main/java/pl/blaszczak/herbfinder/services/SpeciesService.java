package pl.blaszczak.herbfinder.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.blaszczak.herbfinder.domain.Species;
import pl.blaszczak.herbfinder.domain.User;
import pl.blaszczak.herbfinder.repository.SpeciesRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SpeciesService {
    private final SpeciesRepository speciesRepository;

    public List<Species> getListAllSpecies() {
        return speciesRepository.findAll();
    }

    public void deleteSpecies(Integer id) {
        speciesRepository.delete(id);
    }

    public void createSpecies(Species species) {
        speciesRepository.save(species);
    }

    public Species getSpeciesById(Integer id) {
        return speciesRepository.findOne(id);
    }

    public void updateSpecies(Species species) {
        speciesRepository.saveAndFlush(species);
    }
}