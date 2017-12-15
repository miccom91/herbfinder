package pl.blaszczak.herbfinder.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.blaszczak.herbfinder.domain.Herb;
import pl.blaszczak.herbfinder.repository.HerbRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class HerbService {

    private final HerbRepository herbRepository;

    public List<Herb> getListAllHerbs() {
        return herbRepository.findAll();
    }


    public void deleteHerb(Integer id) {
        herbRepository.delete(id);
    }

    public Herb getHerbById(Integer id) {
        return herbRepository.getOne(id);
    }

    public void updateHerb(Herb herb) {
        herbRepository.saveAndFlush(herb);
    }

    public void createHerb(Herb herb) {
        herbRepository.save(herb);

    }


}
