package pl.blaszczak.herbfinder.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import pl.blaszczak.herbfinder.domain.Attribute;
import pl.blaszczak.herbfinder.domain.Herb;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class HerbTO {
    private Integer id;
    @Size(min = 3,max = 30, message = "Nazwa rośliny musi mieć min 3 znaki a maksymalnie 30 znaków")
    private String name;
    @Size(max = 1000, message = "Opis jest za długi")
    private String description;
    private Attribute attribute;
    private MultipartFile multipartFile;
    private String image;

    public HerbTO(Herb herb, String image){
        this.id = herb.getId();
        this.description = herb.getDescription();
        this.attribute = herb.getAttribute();
        this.name = herb.getName();
        this.image = image;
    }
}
