package pl.blaszczak.herbfinder.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Localization {
    @Id
    @GeneratedValue

    private Integer id;
    public String comment;
    private double localizationN;
    private double localizationE;
    private Boolean isPrivate;
    private String ecology;
    private Integer adminMark;


}