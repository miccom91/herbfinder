package pl.blaszczak.herbfinder.domain;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor   //pojo(doczytac) tworzenie prostych konstr.
@AllArgsConstructor
@Builder

public class Herb {
    @Id
    @GeneratedValue

    private Integer id;
    private String name;
    private String ecology;
    private double localization1;
    private double localization2;
    private String  comment;
    private Boolean isPrivate;
    private Integer adminMark;


}
