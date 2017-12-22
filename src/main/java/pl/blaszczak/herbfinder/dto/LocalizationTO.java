package pl.blaszczak.herbfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.blaszczak.herbfinder.domain.Ecology;
import pl.blaszczak.herbfinder.domain.Herb;
import pl.blaszczak.herbfinder.domain.User;

@Setter
@Getter
@AllArgsConstructor
public class LocalizationTO {
    private Integer id;
    public String comment;
    private double localizationN;
    private double localizationE;
    private Boolean isPrivate;
    private Ecology ecology;
    private Integer adminMark;
    private User user;
    private Herb herb;
}
