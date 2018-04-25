package pl.blaszczak.herbfinder.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//pojo(doczytac) tworzenie prostych konstr.
public class Herb {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Column(length = 10000)
    private String description;
    @ManyToOne
    private Attribute attribute;
    @Column(length = 5000000)
    private byte[] image;
}
