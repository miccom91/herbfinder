package pl.blaszczak.herbfinder.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import pl.blaszczak.herbfinder.domain.Attribute;

@Getter
@Setter
@NoArgsConstructor
public class HerbTO {
    private Integer id;
    private String name;
    private String description;
    private Attribute attribute;
    private MultipartFile multipartFile;
    private String image;
}
