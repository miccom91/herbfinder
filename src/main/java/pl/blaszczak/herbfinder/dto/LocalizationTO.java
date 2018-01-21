package pl.blaszczak.herbfinder.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.blaszczak.herbfinder.domain.Ecology;
import pl.blaszczak.herbfinder.domain.Herb;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
public class LocalizationTO {
    private Integer id;
    @Size(max = 1000, message = "Komentarz jest za długi")
    public String comment;
    private double localizationN;
    private double localizationE;
    private Boolean isPrivate;
    private Ecology ecology;
    private Integer adminMark;
    private Herb herb;
}
