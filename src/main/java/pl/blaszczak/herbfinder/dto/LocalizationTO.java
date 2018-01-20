package pl.blaszczak.herbfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.blaszczak.herbfinder.domain.Ecology;
import pl.blaszczak.herbfinder.domain.Herb;
import pl.blaszczak.herbfinder.domain.User;

import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
public class LocalizationTO {
    private Integer id;
    @Size(max = 1000, message = "Komentarz jest za długi")
    public String comment;
    @Size(min = 49, max = 54, message = "Szerkość geograficzna Polski jest pomiedzy 49 a 54 stopnie")
    private double localizationN;
    @Size(min = 14, max = 24, message = "Długość geograficzna Polski jest pomiedzy 14 a 24 stopnie")
    private double localizationE;
    private Boolean isPrivate;
    private Ecology ecology;
    private Integer adminMark;
    private Herb herb;
}
