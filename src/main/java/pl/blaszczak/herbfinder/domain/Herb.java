package pl.blaszczak.herbfinder.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany
    private List<Attribute> attributes;
}
