package pl.blaszczak.herbfinder.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;
import pl.blaszczak.herbfinder.domain.Herb;
import pl.blaszczak.herbfinder.dto.HerbTO;
import pl.blaszczak.herbfinder.repository.HerbRepository;

import java.io.IOException;
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

    public HerbTO getHerbById(Integer id) {
        Herb herb = herbRepository.getOne(id);
        return new HerbTO(herb, convertByteToString(herb.getImage()));
    }

    public void updateHerb(Herb herb) {
        herbRepository.saveAndFlush(herb);
    }

    public void createHerb(HerbTO herbTO) {
        herbRepository.save(conwertToHerb(herbTO));
    }

    private Herb conwertToHerb(HerbTO herbTO) {
        return Herb.builder().image(convertFileToByte(herbTO.getMultipartFile())).attribute(herbTO.getAttribute())
                .name(herbTO.getName()).description(herbTO.getDescription()).build();
    }

    static byte[] convertFileToByte(MultipartFile file) {
        byte[] fileBin = null;

        try {
            fileBin = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileBin;
    }

    static String convertByteToString(byte[] file) {
        return Base64Utils.encodeToString(file);
    }
}
