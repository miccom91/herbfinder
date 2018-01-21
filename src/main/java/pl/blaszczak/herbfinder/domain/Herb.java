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
    @Column(length = 10000)
    private String description;
    @ManyToOne
    private Attribute attribute;
    @Column(length = 20000000)
    private byte[] image;
}
