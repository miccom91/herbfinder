package pl.blaszczak.herbfinder.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.blaszczak.herbfinder.domain.Attribute;
import pl.blaszczak.herbfinder.repository.AttributeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AttributeService {

    private final AttributeRepository attributeRepository;

    public List<Attribute> getListAllAttributes() {
        return attributeRepository.findAll();
    }

    public void deleteAttribute(Integer id) {
        attributeRepository.delete(id);
    }

    public Attribute getAttributeById(Integer id) {
        return attributeRepository.getOne(id);
    }

    public void updateAttribute(Attribute attribute) {
        attributeRepository.saveAndFlush(attribute);
    }

    public void createAttribute(Attribute attribute) {
        attributeRepository.save(attribute);
    }
}
